package entity;


import java.sql.Timestamp;

public class Repair implements Entity{

  private Integer id;
  private String operator;
  private Integer deviceId;
  private java.sql.Timestamp time;
  private java.sql.Timestamp schedule;
  private String description;
  private String outcome;
  private java.sql.Timestamp outcomeTime;
  private Integer householdId;

  public Repair(Integer id, String operator, Integer deviceId, Timestamp time, Timestamp schedule, String description, String outcome, Timestamp outcomeTime, Integer householdId) {
    this.id = id;
    this.operator = operator;
    this.deviceId = deviceId;
    this.time = time;
    this.schedule = schedule;
    this.description = description;
    this.outcome = outcome;
    this.outcomeTime = outcomeTime;
    this.householdId = householdId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }


  public Integer getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(Integer deviceId) {
    this.deviceId = deviceId;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public java.sql.Timestamp getSchedule() {
    return schedule;
  }

  public void setSchedule(java.sql.Timestamp schedule) {
    this.schedule = schedule;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getOutcome() {
    return outcome;
  }

  public void setOutcome(String outcome) {
    this.outcome = outcome;
  }


  public java.sql.Timestamp getOutcomeTime() {
    return outcomeTime;
  }

  public void setOutcomeTime(java.sql.Timestamp outcomeTime) {
    this.outcomeTime = outcomeTime;
  }


  public Integer getHouseholdId() {
    return householdId;
  }

  public void setHouseholdId(Integer householdId) {
    this.householdId = householdId;
  }

}
