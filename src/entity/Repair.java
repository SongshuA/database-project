package entity;

import java.sql.Timestamp;

public class Repair implements Entity {
    private Integer preairId;
    private String operator;
    private Integer device_ID;
    private Timestamp time;
    private Timestamp schedule;
    private String description;
    private String outcome;
    private Timestamp outcomeTime;
    private Integer householdId;
    private Integer repairFeeId;

    public Repair(Integer preairId, String operator, Integer device_ID, Timestamp time, Timestamp schedule, String description, String outcome, Timestamp outcomeTime, Integer householdId, Integer repairFeeId) {
        this.preairId = preairId;
        this.operator = operator;
        this.device_ID = device_ID;
        this.time = time;
        this.schedule = schedule;
        this.description = description;
        this.outcome = outcome;
        this.outcomeTime = outcomeTime;
        this.householdId = householdId;
        this.repairFeeId = repairFeeId;
    }

    public Integer getRepairFeeId() {
        return repairFeeId;
    }

    public void setRepairFeeId(Integer repairFeeId) {
        this.repairFeeId = repairFeeId;
    }

    public Integer getPreairId() {
        return preairId;
    }

    public void setPreairId(Integer preairId) {
        this.preairId = preairId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getDevice_ID() {
        return device_ID;
    }

    public void setDevice_ID(Integer device_ID) {
        this.device_ID = device_ID;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Timestamp getSchedule() {
        return schedule;
    }

    public void setSchedule(Timestamp schedule) {
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

    public Timestamp getOutcomeTime() {
        return outcomeTime;
    }

    public void setOutcomeTime(Timestamp outcomeTime) {
        this.outcomeTime = outcomeTime;
    }

    public Integer getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Integer householdId) {
        this.householdId = householdId;
    }
}
