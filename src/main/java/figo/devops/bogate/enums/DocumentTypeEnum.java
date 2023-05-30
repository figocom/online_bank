package figo.devops.bogate.enums;

public enum DocumentTypeEnum {
    PASSPORT("IDTP1"),
    MILITARY_ID("IDTP2"),
    Citizen_ID("IDTP4"),
    Registration_ID("IDTP5"),
    Passport_for_non_members_a_citizen_of_Uzbekistan("IDTP7"),
    Without_citizenship("IDTP8");
    private final String documentType;
    DocumentTypeEnum(String documentType){
        this.documentType=documentType;
    }
    public String getDocumentType() {
        return documentType;
    }
}
