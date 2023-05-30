package figo.devops.bogate.enums;

public enum AccountProcTypeEnum {
    NEW_ACCOUNT(1),
    USE_EXISTING(3);
    private final Integer code;

    AccountProcTypeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
