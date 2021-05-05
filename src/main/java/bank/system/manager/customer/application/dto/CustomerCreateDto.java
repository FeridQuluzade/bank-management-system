package bank.system.manager.customer.application.dto;

public class CustomerCreateDto extends AuditedCreateDto {
    private String name;
    private String gender;
    private String married;
    private String status;
    private long contact_id;
    private String occupation;

    public CustomerCreateDto() {
    }

    public CustomerCreateDto(String name,
                             String gender,
                             String married, String status,
                             long contact_id,
                             String occupation) {
        this.name = name;
        this.gender = gender;
        this.married = married;
        this.status = status;
        this.contact_id = contact_id;
        this.occupation = occupation;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getContact_id() {
        return contact_id;
    }

    public void setContact_id(long contact_id) {
        this.contact_id = contact_id;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "EmployeeCreateDto{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", married='" + married + '\'' +
                ", status='" + status + '\'' +
                ", contact_id=" + contact_id +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
