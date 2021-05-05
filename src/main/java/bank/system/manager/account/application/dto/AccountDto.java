package bank.system.manager.account.application.dto;

public class AccountDto {
    private long accId;
    private double sum;
    private long ownerId;

    public AccountDto() {
    }

    public AccountDto(long accId, double sum, long ownerId) {
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

    @Override
    public String toString() {
        return "AccountDto{" +
                "accId=" + accId +
                ", sum=" + sum +
                ", ownerId=" + ownerId +
                '}';
    }
}
