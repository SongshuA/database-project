package entity;

public class Community implements Entity{
    public String name;
    public Float propertyFee;
    public Float rentFee;
    public Float purchaseFee;

    public Community(String name, Float propertyFee, Float rentFee, Float purchaseFee) {
        this.name = name;
        this.propertyFee = propertyFee;
        this.rentFee = rentFee;
        this.purchaseFee = purchaseFee;
    }

    public Community(String name){
        this(name, null, null, null);
    }
}
