package entity;

public class Community implements Entity{
    private String name;
    private Float propertyFee;
    private Float rentFee;
    private Float purchaseFee;

    public Community(String name, Float propertyFee, Float rentFee, Float purchaseFee) {
        this.name = name;
        this.propertyFee = propertyFee;
        this.rentFee = rentFee;
        this.purchaseFee = purchaseFee;
    }

    public Community(String name){
        this(name, null, null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPropertyFee() {
        return propertyFee;
    }

    public void setPropertyFee(Float propertyFee) {
        this.propertyFee = propertyFee;
    }

    public Float getRentFee() {
        return rentFee;
    }

    public void setRentFee(Float rentFee) {
        this.rentFee = rentFee;
    }

    public Float getPurchaseFee() {
        return purchaseFee;
    }

    public void setPurchaseFee(Float purchaseFee) {
        this.purchaseFee = purchaseFee;
    }
}
