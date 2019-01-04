package entity;


import java.sql.Timestamp;

public class Complaint implements Entity{

  private Integer id;
  private String type;
  private Timestamp time;
  private String description;
  private Integer householdId;
  private Timestamp schedule;
  private String outcome;
  private Timestamp outcomeTime;

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


  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
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


  public Timestamp getSchedule() {
    return schedule;
  }

  public void setSchedule(Timestamp schedule) {
    this.schedule = schedule;
  }


  public String getOutcome() {
    return outcome;
  }

  public void setOutcome(String outcome) {
    this.outcome = outcome;
  }


  public Timestamp getOutcomeTime() {
    return outcomeTime;
  }

  public void setOutcomeTime(Timestamp outcomeTime) {
    this.outcomeTime = outcomeTime;
  }

}
