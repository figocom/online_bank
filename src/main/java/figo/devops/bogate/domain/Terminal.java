package figo.devops.bogate.domain;

import figo.devops.bogate.domain.template.AbsIntEntity;
import figo.devops.bogate.enums.TerminalTypeEnum;
import figo.devops.bogate.util.TableKey;
import jakarta.persistence.*;
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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "terminalId", "merchantId" }) })
@Where(clause = "deleted=false")
@SQLDelete(sql = ("update " + TableKey.Terminal + " set deleted=true where id=?"))
public class Terminal extends AbsIntEntity {
    @Column(nullable = false, length = 16)
    private String terminalId;
    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private TerminalTypeEnum terminalType;
    @Column(nullable = false, length = 16)
    private String merchantId;
    @Column(nullable = false, length = 20)
    private String userId;
}
