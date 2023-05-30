package figo.devops.bogate.domain;

import figo.devops.bogate.domain.template.AbsIntEntity;
import figo.devops.bogate.enums.AccountProcTypeEnum;
import figo.devops.bogate.enums.CurrencyEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
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
