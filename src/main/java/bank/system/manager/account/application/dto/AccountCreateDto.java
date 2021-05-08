package bank.system.manager.account.application.dto;

import bank.system.manager.shared.audited.AuditedCreateDto;

public class AccountCreateDto extends AuditedCreateDto {
    private double sum;
    private long ownerId;

    public AccountCreateDto() {
    }

    public AccountCreateDto(double sum, long ownerId) {
        this.sum = sum;
        this.ownerId = ownerId;
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

    @Override
    public String toString() {
        return "AccountCreateDto{" +
                "sum=" + sum +
                ", ownerId=" + ownerId +
                '}';
    }
}
