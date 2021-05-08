package bank.system.manager.contact.application.dto;

import bank.system.manager.shared.audited.AuditedUpdateDto;

public class ContactUpdateDto extends AuditedUpdateDto {
    private long id;
    private String address;
    private String city;
    private String email;
    private String mobile;
    private String pin;

    public ContactUpdateDto() {
    }

    public ContactUpdateDto(long id,
                            String address,
                            String city,
                            String email,
                            String mobile,
                            String pin) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.email = email;
        this.mobile = mobile;
        this.pin = pin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return "ContactUpdateDto{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}
