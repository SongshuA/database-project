package entity;

public class Device implements Entity{

  private Integer id;
  private String type;
  private String communityName;

  public Device(Integer id, String type, String communityName){
    this.id = id;
    this.type = type;
    this.communityName = communityName;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getCommunityName() {
    return communityName;
  }

  public void setCommunityName(String communityName) {
    this.communityName = communityName;
  }

}
