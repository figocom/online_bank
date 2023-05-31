package figo.devops.bogate.domain;

import figo.devops.bogate.domain.template.AbsIntEntity;
import figo.devops.bogate.enums.AccountProcTypeEnum;
import figo.devops.bogate.enums.CurrencyEnum;
import figo.devops.bogate.util.TableKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@SQLDelete(sql = ("update " + TableKey.Account + " set deleted=true where id=?"))
public class Account extends AbsIntEntity {
    @Column(nullable = false, length = 1)
    private Integer accountProcType;
    @Column(nullable = false, length = 25)
    private String accountNumber;
    @Column(nullable = false, length = 3)
    private String currency;

    public Account(AccountProcTypeEnum accountProcType, String accountNumber, CurrencyEnum currency) {
        this.accountProcType = accountProcType.getCode();
        this.accountNumber = accountNumber;
        this.currency = String.valueOf(currency.getCode());
    }
}
