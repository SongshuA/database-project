package entity;


import java.sql.Timestamp;

public class Complaint implements Entity{

  private Integer id;
  private String type;
  private java.sql.Timestamp time;
  private String description;
  private Integer householdId;
  private java.sql.Timestamp schedule;
  private String outcome;
  private java.sql.Timestamp outcomeTime;

  public Complaint(Integer id, String type, Timestamp time, String description, Integer householdId, Timestamp schedule, String outcome, Timestamp outcomeTime) {
    this.id = id;
    this.type = type;
    this.time = time;
    this.description = description;
    this.householdId = householdId;
    this.schedule = schedule;
    this.outcome = outcome;
    this.outcomeTime = outcomeTime;
  }

  public int getId() {
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


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public Integer getHouseholdId() {
    return householdId;
  }

  public void setHouseholdId(Integer householdId) {
    this.householdId = householdId;
  }


  public java.sql.Timestamp getSchedule() {
    return schedule;
  }

  public void setSchedule(java.sql.Timestamp schedule) {
    this.schedule = schedule;
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

}
