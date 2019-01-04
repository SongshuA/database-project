package entity;

public class UserRepair implements Entity{
    private Integer householdId;
    private Integer count;
    private Integer cost;

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

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public UserRepair(Integer householdId, Integer count, Integer cost) {
        this.householdId = householdId;
        this.count = count;
        this.cost = cost;
    }
}
