package figo.devops.bogate.controller;

import figo.devops.bogate.dto.TerminalAddDTO;
import figo.devops.bogate.dto.TerminalRemoveDTO;
import figo.devops.bogate.net.*;
import figo.devops.bogate.service.TerminalService;
import figo.devops.bogate.util.AppConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TerminalControllerImpl implements TerminalController {
    private final TerminalService service;

    @Override
    public ApiResponse<?> addTerminal(ApiRequest<TerminalAddDTO> request) {
        service.addTerminal(request.getParams());
        return new ApiResponse<>(AppConstant.BASE_PATH+TerminalControllerPath+ADD_Terminal_Url,
                new SuccessData<>("0", "Terminal Id and Merchant Id added successfully!"));
    }

    @Override
    public ApiResponse<?> removeTerminal(ApiRequest<TerminalRemoveDTO> request) {
        service.removeTerminal(request.getParams());
        return  new ApiResponse<>(AppConstant.BASE_PATH +TerminalControllerPath+Remove_Terminal_url ,
                new SuccessData<>("0" , "Terminal Id and Merchant Id removed Successfully!"));
    }
}
