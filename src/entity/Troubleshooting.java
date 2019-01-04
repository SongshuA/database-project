package entity;


import java.sql.Timestamp;

public class Troubleshooting implements Entity {

  private Integer trobleshootingId;
  private Timestamp time;
  private String operator;
  private String description;
  private Integer repairFeeId;
  private Integer deviceId;

  public Troubleshooting(Integer trobleshootingId, Timestamp time, String operator, String description, Integer repairFeeId, Integer deviceId) {
    this.trobleshootingId = trobleshootingId;
    this.time = time;
    this.operator = operator;
    this.description = description;
    this.repairFeeId = repairFeeId;
    this.deviceId = deviceId;
  }

  public Integer getTrobleshootingId() {
    return trobleshootingId;
  }

  public void setTrobleshootingId(Integer trobleshootingId) {
    this.trobleshootingId = trobleshootingId;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
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

  public Integer getRepairFeeId() {
    return repairFeeId;
  }

  public void setRepairFeeId(Integer repairFeeId) {
    this.repairFeeId = repairFeeId;
  }

  public Integer getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(Integer deviceId) {
    this.deviceId = deviceId;
  }
}