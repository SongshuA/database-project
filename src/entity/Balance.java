package entity;

import java.sql.Timestamp;

public class Balance implements Entity{
    private Float amount;
    private String type;
    private Timestamp time;

    public Balance(){}

    public Balance(Float amount, String type, Timestamp time) {
        this.amount = amount;
        this.type = type;
        this.time = time;
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
