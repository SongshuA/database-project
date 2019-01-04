package entity;

public class UserRepair implements Entity{
    private Integer householdId;
    private Integer count;
    private double countFee;

    public Integer getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Integer householdId) {
        this.householdId = householdId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public double getCountFee() {
        return countFee;
    }

    public void setCountFee(Integer countFee) {
        this.countFee = countFee;
    }

    public UserRepair(Integer householdId, Integer count, double countFee) {
        this.householdId = householdId;
        this.count = count;
        this.countFee = countFee;
    }
}
