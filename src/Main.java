import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.setTitle("物业管理系统");
        primaryStage.show();
    }
}
