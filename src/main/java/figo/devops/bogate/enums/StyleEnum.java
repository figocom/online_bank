package figo.devops.bogate.enums;

public enum StyleEnum {
    MALE("STLE0"),
    FEMALE("STLE1");
    private final String styleCode;
    StyleEnum(String styleCode){
        this.styleCode=styleCode;
    }
    public String getStyleCode() {
        return styleCode;
    }

}
