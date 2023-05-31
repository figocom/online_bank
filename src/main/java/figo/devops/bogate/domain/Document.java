package figo.devops.bogate.domain;

import figo.devops.bogate.domain.template.AbsIntEntity;
import figo.devops.bogate.enums.DocumentTypeEnum;
import figo.devops.bogate.util.TableKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Where(clause = "deleted=false")
@SQLDelete(sql = ("update " + TableKey.Document + " set deleted=true where id=?"))
public class Document extends AbsIntEntity {
    @Column(nullable = false, length = 5)
    private String documentType;
    @Column(nullable = false, length = 2)
    private String series;
    @Column(nullable = false, length = 7)
    private String number;
    @Column(nullable = false, length = 14)
    private String mrz;
    @Column(nullable = false, length = 8)
    private String issueDate;
    @Column(nullable = false, length = 8)
    private String expiryDate;
    @Column(nullable = false, length = 50)
    private String authority;

    public Document(DocumentTypeEnum documentType, String series, String number, String mrz, String issueDate, String expiryDate, String authority) {
        this.documentType = documentType.getDocumentType();
        this.series = series;
        this.number = number;
        this.mrz = mrz;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.authority = authority;
    }
}
