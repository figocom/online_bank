package figo.devops.bogate.controller;

import figo.devops.bogate.dto.TerminalAddDTO;
import figo.devops.bogate.dto.TerminalRemoveDTO;
import figo.devops.bogate.net.ApiRequest;
import figo.devops.bogate.net.ApiResponse;
import figo.devops.bogate.net.MarkerData;
import figo.devops.bogate.util.AppConstant;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(AppConstant.BASE_PATH+TerminalController.TerminalControllerPath)
public interface TerminalController {
    String TerminalControllerPath="/terminal";
    String ADD_Terminal_Url="/add";
    String Remove_Terminal_url="/remove";
    @PostMapping(ADD_Terminal_Url)
    ApiResponse<? extends MarkerData> addTerminal(@RequestBody @Valid ApiRequest<TerminalAddDTO> request);
    @PostMapping(Remove_Terminal_url)
    ApiResponse<? extends MarkerData> removeTerminal(@RequestBody @Valid ApiRequest<TerminalRemoveDTO> request);
}
