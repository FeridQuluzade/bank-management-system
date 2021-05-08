package bank.system.manager.employee.application.dto;

import bank.system.manager.shared.audited.AuditedUpdateDto;

public class EmployeeUpdateDto extends AuditedUpdateDto {
    private long id;
    private String name;
    private String gender;
    private String married;
    private String password;
    private long contact_id;

    public EmployeeUpdateDto() {
    }

    public EmployeeUpdateDto(long id,
                             String name,
                             String gender,
                             String married,
                             String password,
                             long contact_id) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.married = married;
        this.password = password;
        this.contact_id = contact_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getContact_id() {
        return contact_id;
    }

    public void setContact_id(long contact_id) {
        this.contact_id = contact_id;
    }

    @Override
    public String toString() {
        return "EmployeeUpdateDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", married='" + married + '\'' +
                ", password='" + password + '\'' +
                ", contact_id=" + contact_id +
                '}';
    }
}
