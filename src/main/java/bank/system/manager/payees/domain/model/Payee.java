package bank.system.manager.payees.domain.model;

import bank.system.manager.contact.domain.model.BaseEntity;


public class Payee extends BaseEntity {
    private long id;
    private double payment_year;
    private double payment_month;

    private long accountid;

    public Payee() {
    }

    public Payee(long id, double payment_year, double payment_month, long accountid) {
        this.id = id;
        this.payment_year = payment_year;
        this.payment_month = payment_month;
        this.accountid = accountid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPayment_year() {
        return payment_year;
    }

    public void setPayment_year(double payment_year) {
        this.payment_year = payment_year;
    }

    public double getPayment_month() {
        return payment_month;
    }

    public void setPayment_month(double payment_month) {
        this.payment_month = payment_month;
    }

    public long getAccountid() {
        return accountid;
    }

    public void setAccountid(long accountid) {
        this.accountid = accountid;
    }
}
