package entity;


public class Resident implements Entity{

  private long id;
  private String name;
  private String contact;
  private long houseId;

  public Resident(long id, String name, String contact, long houseId) {
    this.id = id;
    this.name = name;
    this.contact = contact;
    this.houseId = houseId;
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


  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }


  public long getHouseId() {
    return houseId;
  }

  public void setHouseId(long houseId) {
    this.houseId = houseId;
  }

}
