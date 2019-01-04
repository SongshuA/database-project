package entity;

public class Resident implements Entity{
    private Integer residentId;
    private String name;
    private String contact;
    private Integer houseId;

    public Resident(){}

    public Resident(Integer residentId, String name, String contact, Integer houseId) {
        this.residentId = residentId;
        this.name = name;
        this.contact = contact;
        this.houseId = houseId;
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

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
}
