package entity;


import java.sql.Timestamp;

public class Troubleshooting implements Entity{

  private long id;
  private java.sql.Timestamp time;
  private String operator;
  private String description;
  private long repairFeeId;
  private long deviceId;

  public Troubleshooting(long id, Timestamp time, String operator, String description, long repairFeeId, long deviceId) {
    this.id = id;
    this.time = time;
    this.operator = operator;
    this.description = description;
    this.repairFeeId = repairFeeId;
    this.deviceId = deviceId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public long getRepairFeeId() {
    return repairFeeId;
  }

  public void setRepairFeeId(long repairFeeId) {
    this.repairFeeId = repairFeeId;
  }


  public long getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(long deviceId) {
    this.deviceId = deviceId;
  }

}
