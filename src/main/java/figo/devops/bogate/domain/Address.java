package figo.devops.bogate.domain;

import figo.devops.bogate.domain.template.AbsIntEntity;
import figo.devops.bogate.util.TableKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted=false")
@SQLDelete(sql = ("update " + TableKey.Address + " set deleted=true where id=?"))
public class Address extends AbsIntEntity {
    @Column(nullable = false)
    private Integer addressId;
    @Column(nullable = false, length = 10)
    private String zipCode;
    @Column(nullable = false, length = 3)
    private String country;
    @Column(nullable = false, length = 20)
    private String city;
    @Column(nullable = false, length = 50)
    private String addressLine;
}
