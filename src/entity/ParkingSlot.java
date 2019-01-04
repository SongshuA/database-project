package entity;


public class ParkingSlot implements Entity{

  private Integer id;
  private String position;
  private Integer occupied;
  private String communityName;
  private String type;
  private Double amount;
  
  public ParkingSlot(){}

  public ParkingSlot(Integer id, String position, Integer occupied, String communityName, String type, Double amount) {
    this.id = id;
    this.position = position;
    this.occupied = occupied;
    this.communityName = communityName;
    this.type = type;
    this.amount = amount;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }


  public Integer getOccupied() {
    return occupied;
  }

  public void setOccupied(Integer occupied) {
    this.occupied = occupied;
  }


  public String getCommunityName() {
    return communityName;
  }

  public void setCommunityName(String communityName) {
    this.communityName = communityName;
  }

}
