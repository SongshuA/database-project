package entity;


public class Household implements Entity{

  private Integer id;
  private Integer unitId;

  public Household(Integer id, Integer unitId){
    this.id = id;
    this.unitId = unitId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getUnitId() {
    return unitId;
  }

  public void setUnitId(Integer unitId) {
    this.unitId = unitId;
  }

}
