package bank.system.manager.account.application.dto;

import bank.system.manager.shared.audited.AuditedUpdateDto;

public class AccountUpdateDto extends AuditedUpdateDto {
    private long accId;
    private double sum;
    private long ownerId;

    public AccountUpdateDto() {
    }

    public AccountUpdateDto(long accId, double sum, long ownerId) {
        this.accId = accId;
        this.sum = sum;
        this.ownerId = ownerId;
    }

    public long getAccId() {
        return accId;
    }

    public void setAccId(long accId) {
        this.accId = accId;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }


}
