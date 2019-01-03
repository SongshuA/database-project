
import entity.Community;
import entity.CommunityManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uikit.Container;
import uikit.Panel;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage){
        Container container = new Container();
        container.addPanel(new Panel("社区管理", Community.class, CommunityManager.getInstance()));
//        container.addPanel(new Panel("设备管理"));

        Scene scene = new Scene(container, 1280, 720);
        scene.getStylesheets().add(Main.class.getResource("root.css").toString());
        primaryStage.setScene(scene);
        primaryStage.setTitle("物业管理系统");
        primaryStage.show();
    }
}
