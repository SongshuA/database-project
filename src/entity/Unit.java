package entity;


public class Unit implements Entity{

  private Integer id;
  private Integer houseId;
  private String communityName;

  public Unit(Integer id, Integer houseId, String communityName) {
    this.id = id;
    this.houseId = houseId;
    this.communityName = communityName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getHouseId() {
    return houseId;
  }

  public void setHouseId(Integer houseId) {
    this.houseId = houseId;
  }


  public String getCommunityName() {
    return communityName;
  }

  public void setCommunityName(String communityName) {
    this.communityName = communityName;
  }

}
