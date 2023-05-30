package figo.devops.bogate.domain;

import figo.devops.bogate.domain.template.AbsIntEntity;
import figo.devops.bogate.enums.CardStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CardStatus extends AbsIntEntity {

     private Integer code;
      @Enumerated(EnumType.STRING)
      private CardStatusEnum cardStatus;

      public CardStatus(CardStatusEnum cardStatusEnum){
          this.code=cardStatusEnum.getCode();
      }

}
