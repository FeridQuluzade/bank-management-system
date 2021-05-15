package bank.system.manager.payees.application.dto;

import bank.system.manager.shared.audited.AuditedCreateDto;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class PayeeCreateDto extends AuditedCreateDto {
    @JsonIgnore
    private double payment_year;
    @JsonIgnore
    private double payment_month;

    private long accountid;

    public PayeeCreateDto() {
    }

    public PayeeCreateDto(double payment_year, double payment_month, long accountid) {
        this.payment_year = payment_year;
        this.payment_month = payment_month;
        this.accountid = accountid;
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
