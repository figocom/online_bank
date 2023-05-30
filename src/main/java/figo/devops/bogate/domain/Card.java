package figo.devops.bogate.domain;

import figo.devops.bogate.domain.template.AbsIntEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Card extends AbsIntEntity {
    @Column(nullable = false, length = 3)
    private String cardType;
    @Column(nullable = false, length = 6)
    private String cardMask;
    @Column(nullable = false, length = 4)
    private String cardExpireDate;
}
