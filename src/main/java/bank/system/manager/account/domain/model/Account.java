package bank.system.manager.account.domain.model;

import bank.system.manager.contact.domain.model.BaseEntity;

public class Account extends BaseEntity {
    private long accId;
    private double sum;
    private long ownerId;

    public Account() {
    }

    public Account(long accId, double sum, long ownerId) {
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
        return "account{" +
                "accId=" + accId +
                ", sum=" + sum +
                ", ownerId=" + ownerId +
                '}';
    }
}
