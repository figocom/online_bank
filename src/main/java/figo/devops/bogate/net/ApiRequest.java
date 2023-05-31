package figo.devops.bogate.net;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiRequest<T> {
    private static Integer id=1;
    static {
        id++;
    }
    private final String jsonrpc="2.0";
    private String methodName;
    private T params;

    public ApiRequest(String methodName, T params) {
        this.methodName = methodName;
        this.params = params;
    }
}
