package figo.devops.bogate.service;

import figo.devops.bogate.dto.TerminalAddDTO;
import figo.devops.bogate.dto.TerminalRemoveDTO;

public interface TerminalService {
    void addTerminal(TerminalAddDTO params);

    void removeTerminal(TerminalRemoveDTO params);
}
