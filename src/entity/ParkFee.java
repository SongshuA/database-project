package entity;


public class ParkFee implements Entity{

  private long id;
  private long parkingSlotId;
  private long householdId;

  public ParkFee(long id, long parkingSlotId, long householdId) {
    this.id = id;
    this.parkingSlotId = parkingSlotId;
    this.householdId = householdId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getParkingSlotId() {
    return parkingSlotId;
  }

  public void setParkingSlotId(long parkingSlotId) {
    this.parkingSlotId = parkingSlotId;
  }


  public long getHouseholdId() {
    return householdId;
  }

  public void setHouseholdId(long householdId) {
    this.householdId = householdId;
  }

}
