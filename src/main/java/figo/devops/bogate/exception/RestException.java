package figo.devops.bogate.exception;

import figo.devops.bogate.component.MessageService;
import figo.devops.bogate.net.ErrorData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class RestException extends RuntimeException {

    private String userMsg;
    private HttpStatus status;

    private ErrorData errors;
    private Integer errorCode;

    private RestException(String userMsg, HttpStatus status) {
        super(userMsg);
        this.userMsg = userMsg;
        this.status = status;
    }

    private RestException(String userMsg, int errorCode, HttpStatus status) {
        super(userMsg);
        this.errors = new ErrorData(userMsg, errorCode);
        this.userMsg = userMsg;
        this.status = status;
    }

    private RestException(HttpStatus status, ErrorData errors) {
        this.status = status;
        this.errors = errors;
    }

    public static RestException restThrow(String userMsg, HttpStatus httpStatus) {
        return new RestException(userMsg, httpStatus);
    }

    public static RestException restThrow(ErrorData errors, HttpStatus status) {
        return new RestException(status, errors);
    }

    public static RestException restThrow(String message) {
        return new RestException(message, HttpStatus.BAD_REQUEST);
    }


    public static RestException notFound(String resourceKey) {
        return new RestException(
                MessageService.notFound(resourceKey),
                HttpStatus.NOT_FOUND
        );
    }

    public static RestException otherServiceError(String serviceName) {
        return new RestException(
                MessageService.otherServiceError(serviceName),
                HttpStatus.BAD_REQUEST
        );
    }
    public static RestException badRequest(String resourceKey) {
        return new RestException(
                MessageService.getMessage(resourceKey),
                HttpStatus.BAD_REQUEST
        );
    }

    public static RestException alreadyExists(String resourceKey) {
        return new RestException(
                MessageService.alreadyExists(resourceKey),
                HttpStatus.CONFLICT
        );
    }

    public static RestException attackResponse() {
        return new RestException(
                MessageService.getMessage("ATTACK_RESPONSE"),
                HttpStatus.BAD_REQUEST
        );
    }

    public static RestException forbidden() {
        return new RestException(
                MessageService.getMessage("FORBIDDEN"),
                HttpStatus.BAD_REQUEST
        );
    }

    public static RestException internalServerError() {
        return new RestException(
                MessageService.getMessage("INTERNAL_SERVER_ERROR"),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
