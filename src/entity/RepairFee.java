package entity;


public class RepairFee implements Entity{

  private long id;
  private long repairId;

  public RepairFee(long id, long repairId) {
    this.id = id;
    this.repairId = repairId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getRepairId() {
    return repairId;
  }

  public void setRepairId(long repairId) {
    this.repairId = repairId;
  }

}
