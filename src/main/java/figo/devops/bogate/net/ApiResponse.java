package figo.devops.bogate.net;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Getter
@ToString

@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse <T extends MarkerData> {
    private  Integer id=1;
    private final String jsonrpc="2.0";
    private String methodName;
    private T data;
    public ApiResponse(String methodName, T params) {
        this.methodName = methodName;
        this.data = params;
    }


    public static ApiResponse<ErrorData> errorResponse(String noAcceptable, int i) {
        return new ApiResponse<>("error",new ErrorData(noAcceptable,i));
    }


    public static ApiResponse<ErrorData> errorResponse(ErrorData errors) {
        return new ApiResponse<>("error",errors);
    }
}
