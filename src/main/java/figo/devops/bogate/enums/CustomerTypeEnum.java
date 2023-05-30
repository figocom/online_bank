package figo.devops.bogate.enums;

public enum CustomerTypeEnum {
    PERSONAL(0),
    CORPORATE(1);

    private final Integer code;

    CustomerTypeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
