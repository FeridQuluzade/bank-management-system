package bank.system.manager.customer.application.dto;

import java.time.LocalDateTime;

public class AuditedUpdateDto {
    private long updatedBy;


    private LocalDateTime updatedDate;

    public long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
