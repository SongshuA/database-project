package entity;

public class DeviceTroubleshooting implements Entity{
    private Integer deviceId;
    private Integer brokenCount;//损坏次数
    private Integer repairCount;//保修次数
    private Double countFee;

    public DeviceTroubleshooting(){}

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getBrokenCount() {
        return brokenCount;
    }

    public void setBrokenCount(Integer brokenCount) {
        this.brokenCount = brokenCount;
    }

    public Integer getRepairCount() {
        return repairCount;
    }

    public void setRepairCount(Integer repairCount) {
        this.repairCount = repairCount;
    }

    public Double getCountFee() {
        return countFee;
    }

    public void setCountFee(Double countFee) {
        this.countFee = countFee;
    }

    public DeviceTroubleshooting(Integer deviceId, Integer brokenCount, Integer repairCount, Double countFee) {
        this.deviceId = deviceId;
        this.brokenCount = brokenCount;
        this.repairCount = repairCount;
        this.countFee = countFee;
    }
}
