package bank.system.manager.account.application.dto;

import bank.system.manager.shared.audited.AuditedCreateDto;

public class AccountCreateDto extends AuditedCreateDto {
    private double sum;
    private long ownerId;
    private double year;

    public AccountCreateDto() {
    }

    public AccountCreateDto(double sum, long ownerId, double year) {
        this.sum = sum;
        this.ownerId = ownerId;
        this.year = year;
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

    public double getYear() {
        return year;
    }

    public void setYear(double year) {
        this.year = year;
    }
}
