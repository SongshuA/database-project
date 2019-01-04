package entity;

public class ComplaintReport implements Entity{
    private String community_name;
    private Integer houseId;
    private Integer unitId;
    private Integer householdId;
    private String type;
    private Integer count;

    public ComplaintReport(String community_name, Integer houseId, Integer unitId, Integer householdId, String type, Integer count) {
        this.community_name = community_name;
        this.houseId = houseId;
        this.unitId = unitId;
        this.householdId = householdId;
        this.type = type;
        this.count = count;
    }

    public String getCommunity_name() {
        return community_name;
    }

    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Integer householdId) {
        this.householdId = householdId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
