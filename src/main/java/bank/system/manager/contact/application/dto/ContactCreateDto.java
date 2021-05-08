package bank.system.manager.contact.application.dto;

import bank.system.manager.shared.audited.AuditedCreateDto;

public class ContactCreateDto extends AuditedCreateDto {

    private String address;
    private String city;
    private String email;
    private String mobile;
    private String pin;

    public ContactCreateDto() {
    }

    public ContactCreateDto(String address, String city, String email, String mobile, String pin) {
        this.address = address;
        this.city = city;
        this.email = email;
        this.mobile = mobile;
        this.pin = pin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "ContactCreateDto{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}
