package entity;


import java.sql.Timestamp;

public class RepairFee implements Entity {
    private Integer repairFeeId;
    private Double amount;
    private Timestamp time;
    private Integer paied;
    private String description;

    public RepairFee(Integer repairId, Double amount, Timestamp time, Integer paied, String description) {
        this.repairFeeId = repairId;
        this.amount = amount;
        this.time = time;
        this.paied = paied;
        this.description = description;
    }

    public Integer getRepairFeeId() {
        return repairFeeId;
    }

    public void setRepairFeeId(Integer repairFeeId) {
        this.repairFeeId = repairFeeId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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
