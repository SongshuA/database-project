package entity;


public class OtherFee implements Entity{

  private long id;
  private long otherFeeId;

  public OtherFee(long id, long otherFeeId) {
    this.id = id;
    this.otherFeeId = otherFeeId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setOtherFeeId(long otherFeeId) {
    this.otherFeeId = otherFeeId;
  }

  public long getOtherFeeId() {
    return otherFeeId;
  }
}
