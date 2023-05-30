package figo.devops.bogate.enums;

public enum ClientCreationEnum {
    NEW_CLIENT(1),
    USE_EXISTING(3),
    CREATE_SECONDARY(9);
    private final Integer code;

    ClientCreationEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}

