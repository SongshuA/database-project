package uikit.common;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class QueryPane extends GridPane {
    private List<TextField> tfList;
    private QueryHandler handler;

    public QueryPane(Class entityClass, String[] items){
        super();
        this.getStyleClass().add("parameter-pane");
        tfList = new ArrayList<>();

        int length = items.length;

        for(int i = 0; i < length; i++){
            String title = Utils.translate(entityClass, items[i]);
            Label label = new Label(title);
            TextField tf = new TextField();
            tf.setPromptText(title);
            tfList.add(tf);
            this.add(label, 0, i);
            this.add(tf, 1, i);
        }

        Button confirmBtn = new Button("筛选");
        confirmBtn.getStyleClass().addAll("btn", "btn-green");
        confirmBtn.setOnAction(e -> {
            if(handler != null)
                handler.handle(getValues());
        });
        this.add(confirmBtn, 0, length);
    }

    public String[] getValues(){
        List<String> values = new ArrayList<>();
        for(TextField tf : tfList){
            String text = tf.getText();
            values.add(text);
        }
        return values.toArray(new String[0]);
    }

    public void setOnQuery(QueryHandler handler) {
        this.handler = handler;
    }
}
