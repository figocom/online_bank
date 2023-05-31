package figo.devops.bogate.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TerminalRemoveDTO {
    @NotBlank(message = "Terminal id required")
    @Size(min = 1, max = 16 , message = "not valid size terminal id")
    private String terminalId;
    @NotBlank(message = "Merchant  id required")
    @Size(min = 1, max = 16 , message = "not valid size Merchant  id")
    private String merchantId;
}
