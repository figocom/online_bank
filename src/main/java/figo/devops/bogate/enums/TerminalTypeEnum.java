package figo.devops.bogate.enums;

import java.util.List;

public enum TerminalTypeEnum {
    ECOM(List.of(683)),
    P2P(List.of(689,785)),
    BankCRT(List.of(760,711)),
    BankDT(List.of(683)),
    LOAN(List.of(683)),
    DEPOSIT(List.of(683, 703)),
    EXCH(List.of(683)),
    BANK(List.of(683, 760));
    private final List<Integer> terminalTypeIds;

     TerminalTypeEnum(List<Integer> es) {
        this.terminalTypeIds = es;
    }
}
