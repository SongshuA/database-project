package entity;

import java.sql.Timestamp;

public class MonthBill implements Entity{
    private Integer householdId;
    private Float amount;
    private Timestamp time;
    private Boolean paied;
    private String type;

    public MonthBill(Integer householdId, Float amount, Timestamp time, boolean paied, String type) {
        this.householdId = householdId;
        this.amount = amount;
        this.time = time;
        this.paied = paied;
        this.type = type;
    }

    public Integer getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Integer householdId) {
        this.householdId = householdId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Boolean isPaied() {
        return paied;
    }

    public void setPaied(Boolean paied) {
        this.paied = paied;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
