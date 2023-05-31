package figo.devops.bogate.exception;

import figo.devops.bogate.component.MessageService;
import figo.devops.bogate.net.ApiResponse;
import figo.devops.bogate.net.ErrorData;
import figo.devops.bogate.util.AppConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionHelper {


    private static final String NOT_FOUND = "_NOT_FOUND";
    private static final String NOT_NULL = "_NOT_NULL";
    private static final String UK_CONSTRAINT = "_UK_CONSTRAINT";




    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleException(MethodArgumentNotValidException ex) {
        sendMessageToTelegramChannel(ex);
        List<ErrorData> errors = new ArrayList<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        fieldErrors.forEach(fieldError -> errors.add(new ErrorData(fieldError.getDefaultMessage(), AppConstant.REQUIRED)));
        return new ResponseEntity<>(ApiResponse.errorResponse(errors.get(0)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {TypeMismatchException.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleException(TypeMismatchException ex) {
        sendMessageToTelegramChannel(ex);
        return new ResponseEntity<>(
                ApiResponse.errorResponse(ex.getMessage(), 400),
                HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleException(HttpMessageNotReadableException ex) {
        sendMessageToTelegramChannel(ex);
        return new ResponseEntity<>(
                ApiResponse.errorResponse(ex.getMessage(), AppConstant.CONFLICT),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleException(MissingServletRequestParameterException ex) {
        sendMessageToTelegramChannel(ex);
        return new ResponseEntity<>(
                ApiResponse.errorResponse(ex.getMessage(), 400),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ServletRequestBindingException.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleException(ServletRequestBindingException ex) {
        sendMessageToTelegramChannel(ex);
        return new ResponseEntity<>(
                ApiResponse.errorResponse(ex.getMessage(), 400),
                HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = {MissingServletRequestPartException.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleException(MissingServletRequestPartException ex) {
        sendMessageToTelegramChannel(ex);
        return new ResponseEntity<>(
                ApiResponse.errorResponse(ex.getMessage(), 400),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {BindException.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleException(BindException ex) {
        sendMessageToTelegramChannel(ex);
        return new ResponseEntity<>(
                ApiResponse.errorResponse(ex.getMessage(), 400),
                HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = {AccessDeniedException.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleExceptionAccessDenied(AccessDeniedException ex) {
        sendMessageToTelegramChannel(ex);
        return new ResponseEntity<>(
                ApiResponse.errorResponse(MessageService.getMessage("FORBIDDEN_EXCEPTION"), AppConstant.ACCESS_DENIED),
                HttpStatus.FORBIDDEN);
    }


    @ExceptionHandler(value = {MissingPathVariableException.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleExceptionNotFound(MissingPathVariableException ex) {
        sendMessageToTelegramChannel(ex);
        return new ResponseEntity<>(
                ApiResponse.errorResponse(MessageService.getMessage("PATH_NOTFOUND_EXCEPTION"), AppConstant.NOT_FOUND),
                HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = {NoHandlerFoundException.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleException(NoHandlerFoundException ex) {
        sendMessageToTelegramChannel(ex);
        return new ResponseEntity<>(
                ApiResponse.errorResponse(ex.getMessage(), 404),
                HttpStatus.NOT_FOUND);
    }


    //METHOD XATO BO'LSA
    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleException(HttpRequestMethodNotSupportedException ex) {
        sendMessageToTelegramChannel(ex);
        return new ResponseEntity<>(
                ApiResponse.errorResponse("Method error", 405),
                HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(value = {HttpMediaTypeNotAcceptableException.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleExceptionHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex) {
        sendMessageToTelegramChannel(ex);
        return new ResponseEntity<>(
                ApiResponse.errorResponse("No acceptable", 406),
                HttpStatus.NOT_ACCEPTABLE);
    }


    //METHOD XATO BO'LSA
    @ExceptionHandler(value = {HttpMediaTypeNotSupportedException.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleExceptionHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex) {
        sendMessageToTelegramChannel(ex);
        return new ResponseEntity<>(
                ApiResponse.errorResponse(MessageService.getMessage("UNSUPPORTED_MEDIA_TYPE"), 415),
                HttpStatus.METHOD_NOT_ALLOWED);
    }


    @ExceptionHandler(value = {ConversionNotSupportedException.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleException(ConversionNotSupportedException ex) {
        sendMessageToTelegramChannel(ex);
        return new ResponseEntity<>(
                ApiResponse.errorResponse(ex.getMessage(), AppConstant.SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = {HttpMessageNotWritableException.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleException(HttpMessageNotWritableException ex) {
        sendMessageToTelegramChannel(ex);
        return new ResponseEntity<>(
                ApiResponse.errorResponse(ex.getMessage(), AppConstant.SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleException(Exception ex) {
        sendMessageToTelegramChannel(ex);
        log.error("", ex);
        ex.printStackTrace();
        return new ResponseEntity<>(
                ApiResponse.errorResponse(
                        ex.toString(),
                        AppConstant.SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {AsyncRequestTimeoutException.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleException(AsyncRequestTimeoutException ex) {
        sendMessageToTelegramChannel(ex);
        ex.printStackTrace();
        return new ResponseEntity<>(
                ApiResponse.errorResponse(ex.getMessage(), 503),
                HttpStatus.SERVICE_UNAVAILABLE);
    }


    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleException(DataIntegrityViolationException ex) {
        sendMessageToTelegramChannel(ex);
        ex.printStackTrace();

        try {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) ex.getCause();
            SQLException sqlException = ((ConstraintViolationException) ex.getCause()).getSQLException();
            String message = sqlException.getMessage();


            String sqlState = sqlException.getSQLState();

            //"23503" foreign key ulanolmasa
            //"23502" null property uchun

            //agar biror column dan nullable false qo'yilganda tushadigan exception
            if (sqlState.equals("23502")) {
                String columnName = constraintViolationException.getConstraintName().toUpperCase(Locale.ROOT);
                String clientMessage = columnName + NOT_NULL;

                System.out.println(clientMessage);

                return new ResponseEntity<>(
                        ApiResponse.errorResponse(MessageService.getMessage(clientMessage), 400),
                        HttpStatus.BAD_REQUEST
                );
            }
            if (sqlState.equals("23503")) {
                String detail = "Detail:";

                //DETAIL: SO'ZINI INDEKSINI ANIQLAB OLYAPMAN ARENTIR SIFATIDA
                int arentir = message.indexOf(detail);

                //DETAIL SO'ZIDAN KEYINGI OCHILGAN 1-QAVS NI INDEXINI OLIB +1 QO'SHTIM
                int fromColumnName = message.indexOf("(", arentir) + 1;

                //DETAIL SO'ZIDAN KEYINGI YOPILGAN 1-QAVS NI INDEXINI OLIB -3 AYIRDIM
                int toColumnName = message.indexOf(")", fromColumnName) - 3;

                //MESSAGEDAN COLUMN NAME NI QIRQIB OLIB UNI UPPER_CASE QILINDI
                String columnName = message.substring(fromColumnName, toColumnName).toUpperCase(Locale.ROOT);

                //MESSAGE_BY_LANG GA BERISH UCHUN
                String clientMessage = columnName + NOT_FOUND;
                return new ResponseEntity<>(
                        ApiResponse.errorResponse(MessageService.getMessage(clientMessage), 400),
                        HttpStatus.BAD_REQUEST
                );
            } else if (sqlState.equals("23505")) {

                //MESSAGE_BY_LANG GA BERISH UCHUN
                String clientMessage = constraintViolationException.getConstraintName().toUpperCase(Locale.ROOT) + UK_CONSTRAINT;
                return new ResponseEntity<>(
                        ApiResponse.errorResponse(MessageService.getMessage(clientMessage), 400),
                        HttpStatus.BAD_REQUEST
                );
            }
        } catch (Exception exception) {

            return new ResponseEntity<>(
                    ApiResponse.errorResponse("Server error. Please try again", AppConstant.SERVER_ERROR),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(
                ApiResponse.errorResponse("Server error. Please try again. Mehrojbek tekshirmadida", AppConstant.SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }


    // FOYDALANUVCHI TOMONIDAN XATO SODIR BO'LGANDA
    @ExceptionHandler(value = {RestException.class})
    public ResponseEntity<ApiResponse<ErrorData>> handleException(RestException ex) {
        sendMessageToTelegramChannel(ex);
        ex.printStackTrace();

        if (ex.getErrors() != null)
            return new ResponseEntity<>(ApiResponse.errorResponse(ex.getErrors()), ex.getStatus());
        return new ResponseEntity<>(ApiResponse.errorResponse(ex.getUserMsg(), ex.getErrorCode() != null ? ex.getErrorCode() : ex.getStatus().value()), ex.getStatus());
    }


    private void sendMessageToTelegramChannel(Exception ex) {
        log.info("sendMessageToTelegramChannel");
        try {
            String message = ex.getMessage();
             // rabbitMQ or Kafka send message to telegram channel
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
