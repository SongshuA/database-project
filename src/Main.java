
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uikit.MainContainer;
import uikit.common.Container;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage){
        Container container = new MainContainer();

        Scene scene = new Scene(container, 1280, 900);
        scene.getStylesheets().add(Main.class.getResource("root.css").toString());
        primaryStage.setScene(scene);
        primaryStage.setTitle("物业管理系统");
        primaryStage.show();
    }
}
