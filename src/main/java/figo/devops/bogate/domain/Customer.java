package figo.devops.bogate.domain;

import figo.devops.bogate.domain.template.AbsIntEntity;
import figo.devops.bogate.enums.ClientCreationEnum;
import figo.devops.bogate.enums.CustomerTypeEnum;
import figo.devops.bogate.enums.ResidentTypeEnum;
import figo.devops.bogate.enums.StyleEnum;
import figo.devops.bogate.util.TableKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Where(clause = "deleted=false")
@SQLDelete(sql = ("update " + TableKey.Customer + " set deleted=true where id=?"))
public class Customer extends AbsIntEntity {
    @Column(nullable = false , length = 16)
    private Integer customerId;
    @Column(unique = true,nullable = false , length = 16)
    private Integer personalId;
    @Column(nullable = false , length = 1)
    private Integer customerType;
    @Column(nullable = false , length = 1)
    private Integer procType;
    @Column(nullable = false , length = 6)
    private String contractId;
    @Column(nullable = false , length = 50)
    private String lastName;
    @Column(nullable = false , length = 50)
    private String firstName;
    @Column(nullable = false , length = 50)
    private String middleName;
    @Column(nullable = false , length = 50)
    private String embossedName;
    @Column(nullable = false , length = 5)
    private String style;
    @Column(nullable = false , length = 5)
    private String residentType;
    @Column(nullable = false , length = 8)
    private String birthDate;
    @Column(nullable = false , length = 12)
    private String phoneNumber;

    public Customer(Integer customerId, Integer personalId, CustomerTypeEnum customerTypeEnum, ClientCreationEnum procType, String contractId, String lastName, String firstName, String middleName, String embossedName, StyleEnum style, ResidentTypeEnum residentType, String birthDate, String phoneNumber) {
        this.customerId = customerId;
        this.personalId = personalId;
        this.customerType = customerTypeEnum.getCode();
        this.procType = procType.getCode();
        this.contractId = contractId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.embossedName = embossedName;
        this.style = style.getStyleCode();
        this.residentType = residentType.getResidentType();
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }
}
