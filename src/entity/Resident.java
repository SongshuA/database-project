package entity;

public class Resident implements Entity{
    private Integer residentId;
    private String name;
    private String contact;
    private Integer householdId;

    public Resident(){}

    public Resident(Integer residentId, String name, String contact, Integer householdId) {
        this.residentId = residentId;
        this.name = name;
        this.contact = contact;
        this.householdId = householdId;
    }

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Integer householdId) {
        this.householdId = householdId;
    }
}
