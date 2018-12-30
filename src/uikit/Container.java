package uikit;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.util.HashMap;
import java.util.Map;

public class Container extends BorderPane {
    private Map<String, Panel> navigation;
    private ListView<String> listView;
    private StackPane context;

    public Container(){
        navigation = new HashMap<>();

        listView = new ListView<>();
        listView.setPrefWidth(300);

        listView.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue <? extends String> observable, String oldValue, String newValue) -> {
                    if(navigation.containsKey(oldValue))
                        navigation.get(oldValue).setVisible(false);
                    navigation.get(newValue).setVisible(true);
                }
        );

        context = new StackPane();

        this.setLeft(listView);
        this.setCenter(context);
    }

    public void addPanel(Panel panel){
        listView.getItems().add(panel.getTitle());
        navigation.put(panel.getTitle(), panel);
        panel.setVisible(false);
        context.getChildren().add(panel);
    }
}
