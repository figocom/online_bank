package figo.devops.bogate.domain.template;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;


@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class AbsDateAudit implements Serializable {
    @Builder.Default
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    private Boolean deleted = false;

}
