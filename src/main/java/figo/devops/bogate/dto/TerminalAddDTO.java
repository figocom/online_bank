package figo.devops.bogate.dto;

import figo.devops.bogate.enums.TerminalTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TerminalAddDTO {
    @Size(min = 1, max = 16)
    @NotBlank(message = "Terminal ID is mandatory")
    private String terminalId;

    private TerminalTypeEnum terminalType;

    @NotBlank(message = "Merchant ID is mandatory")
    @Size(min = 1, max = 16)
    private String merchantId;

    @NotBlank(message = "User ID is mandatory")
    @Size(min = 1, max = 20)
    private String userId;
}
