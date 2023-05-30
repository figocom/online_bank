package figo.devops.bogate.enums;

public enum ResidentTypeEnum {
    RESIDENT("RSDN0"),
    NON_RESIDENT("RSDN1");
    private final String residentType;
    ResidentTypeEnum(String residentType){
        this.residentType=residentType;
    }
    public String getResidentType() {
        return residentType;
    }
}
