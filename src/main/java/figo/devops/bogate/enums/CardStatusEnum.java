package figo.devops.bogate.enums;

public enum CardStatusEnum {
    VALID_CARD(0),
    CALL_ISSUER(1),
    WARM_CARD(2),
    DO_NOT_HONOR(3),
    HONOR_WITH_ID(4),
    NOT_PERMITTED(5),
    LOST_CARD_CAPTURE(6),
    STOLEN_CARD_CAPTURE(7),
    CALL_SECURITY_CAPTURE(8),
    INVALID_CARD_CAPTURE(9),
    PICK_UP_CARD_SPECIAL_CONDITION(10),
    CALL_ACQUIRER_SECURITY(11),
    TEMPORARY_BLOCKED_BY_USER(12),
     PIN_ATTEMPTS_EXCEEDED(13),
    FORCED_PIN_CHANGE(14),
    CREDIT_DEBTS(15),
     UNKNOWN(16),
     PIN_ACTIVATION(17),
     INSTANT_CARD_PERSONIFICATION_WAITING(18),
     FRAUD_PREVENTION(19),
    PERMANENT_BLOCKED_BY_CLIENT(20),
    TEMPORARY_BLOCKED_BY_CLIENT(21);

    private final int code;
    CardStatusEnum(Integer code) {
      this.code=code;
    }

    public  Integer getCode(){
        return this.code;
    }



}
