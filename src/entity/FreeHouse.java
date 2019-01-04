package entity;

public class FreeHouse implements Entity{
    private Integer house_ID;
    private Integer unit_ID;
    private String community_name;
    private Integer size;

    public FreeHouse(){}

    public FreeHouse(Integer house_ID, Integer unit_ID, String community_name, Integer size) {
        this.house_ID = house_ID;
        this.unit_ID = unit_ID;
        this.community_name = community_name;
        this.size = size;
    }

    public Integer getHouse_ID() {
        return house_ID;
    }

    public void setHouse_ID(Integer house_ID) {
        this.house_ID = house_ID;
    }

    public Integer getUnit_ID() {
        return unit_ID;
    }

    public void setUnit_ID(Integer unit_ID) {
        this.unit_ID = unit_ID;
    }

    public String getCommunity_name() {
        return community_name;
    }

    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
