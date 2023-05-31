package figo.devops.bogate.domain;

import figo.devops.bogate.domain.template.AbsIntEntity;
import figo.devops.bogate.util.TableKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Where(clause = "deleted=false")
@SQLDelete(sql = ("update " + TableKey.VirtualCard + " set deleted=true where id=?"))
public class VirtualCard extends AbsIntEntity {
    @Column(nullable = false, length = 4)
    private String instId;
    @Column(nullable = false, length = 4)
    private String agentId;
    @Column(nullable = false, length = 75)
    private String ext;
    @Column(nullable = false, length = 16)
    private String merchantId;
    @Column(nullable = false, length = 16)
    private String terminalId;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Card card;
    @ManyToOne
    private Account account;
    @ManyToOne
    private Address address;
    @ManyToOne
    private Document document;

}
