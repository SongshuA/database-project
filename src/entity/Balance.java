package entity;

import java.sql.Timestamp;

public class Balance implements Entity{
    private Float amount;
    private String type;
    private Timestamp time;
    private String description;

    public Balance(){}

    public Balance(Float amount, String type, Timestamp time, String description) {
        this.amount = amount;
        this.type = type;
        this.time = time;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
