package entity;


public class ParkingSlot implements Entity{

  private Integer id;
  private String position;
  private Integer occupied;
  private String communityName;

  public ParkingSlot(){}

  public ParkingSlot(Integer id, String position,Integer occupied, String communityName) {
    this.id = id;
    this.position = position;
    this.occupied = occupied;
    this.communityName = communityName;
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
