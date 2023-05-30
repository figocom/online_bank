package figo.devops.bogate.enums;

public enum CurrencyEnum {

    UZS( 860, "UZS"),
    USD( 840, "USD"),
    EUR( 978, "EUR"),
    RUB( 643, "RUB");

    private final Integer code;

    CurrencyEnum(Integer code, String value) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
