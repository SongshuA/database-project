import entity.*;

public class test {
    public static void main(String[] args) {
        UserRepairManager userRepairManager = new UserRepairManager();
        System.out.println(userRepairManager.get().get(0).getCountFee());
    }
}
