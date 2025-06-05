package cc.kertaskerja.manrisk.manajemenrisiko.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class BaseAuditable {
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    protected LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    protected LocalDateTime updatedDate;

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }
}