package entity;

import java.sql.Timestamp;

public class ParkingIncome implements Entity{
    private Integer id;
    private Integer parkingSlotId;
    private Integer householdId;
    private Float amount;
    private Timestamp time;
    private Integer paied;
    private String description;

    public ParkingIncome(){}

    public String getPositon() {
        return positon;
    }

    public void setPositon(String positon) {
        this.positon = positon;
    }

    private String positon;

    public ParkingIncome(Integer id, Integer parkingSlotId, Integer householdId, Float amount, Timestamp time, Integer paied, String description, String positon) {
        this.id = id;
        this.parkingSlotId = parkingSlotId;
        this.householdId = householdId;
        this.amount = amount;
        this.time = time;
        this.paied = paied;
        this.description = description;
        this.positon = positon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParkingSlotId() {
        return parkingSlotId;
    }

    public void setParkingSlotId(Integer parkingSlotId) {
        this.parkingSlotId = parkingSlotId;
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

    public Integer getPaied() {
        return paied;
    }

    public void setPaied(Integer paied) {
        this.paied = paied;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
