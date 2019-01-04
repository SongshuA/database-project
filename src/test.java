import entity.*;

public class test {
    public static void main(String[] args) {
        FreeHouseManager freeHouseManager = new FreeHouseManager();
        freeHouseManager.get();
        freeHouseManager.get("小区1");
        freeHouseManager.update(new FreeHouse(4,2,"小区1",100));
    }
}
