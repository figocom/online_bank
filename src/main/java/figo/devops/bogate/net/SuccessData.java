package figo.devops.bogate.net;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessData<T> implements MarkerData {
    private String message;
    private String responseSv;
    private String status;
    private T data;
    private SuccessData(T data) {
        this.data = data;
    }

    //SUCCESS RESPONSE WITH DATA AND MESSAGE
    private SuccessData(T data,  String message , String responseSv , String status )  {
        this.data = data;
        this.message = message;
        this.responseSv=responseSv;
        this.status=status;
    }
    public SuccessData(String status, String message){
        this.status=status;
        this.message=message;
    }

}
