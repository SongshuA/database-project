package entity;


public class ParkingSlot implements Entity{

  private long id;
  private String position;
  private long occupied;
  private String communityName;

  public ParkingSlot(long id, String position, long occupied, String communityName) {
    this.id = id;
    this.position = position;
    this.occupied = occupied;
    this.communityName = communityName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }


  public long getOccupied() {
    return occupied;
  }

  public void setOccupied(long occupied) {
    this.occupied = occupied;
  }


  public String getCommunityName() {
    return communityName;
  }

  public void setCommunityName(String communityName) {
    this.communityName = communityName;
  }

}
