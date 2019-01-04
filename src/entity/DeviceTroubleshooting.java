package entity;

public class DeviceTroubleshooting implements Entity{
    private Integer deviceId;
    private Integer brokenCount;
    private Integer repairCount;
    private double countFee;

    public DeviceTroubleshooting(){}

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getBrokenCount() {
        return brokenCount;
    }

    public void setBrokenCount(int brokenCount) {
        this.brokenCount = brokenCount;
    }

    public int getRepairCount() {
        return repairCount;
    }

    public void setRepairCount(int repairCount) {
        this.repairCount = repairCount;
    }

    public double getCountFee() {
        return countFee;
    }

    public void setCountFee(double countFee) {
        this.countFee = countFee;
    }

    public DeviceTroubleshooting(Integer deviceId, Integer brokenCount, Integer repairCount, double countFee) {
        this.deviceId = deviceId;
        this.brokenCount = brokenCount;
        this.repairCount = repairCount;
        this.countFee = countFee;
    }
}
