package uikit;

import entity.Entity;
import entity.EntityManager;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.lang.reflect.Field;


public class Panel extends VBox {
    private String title;
    private EntityManager manager;
    private EntityTable table;
    private InfoPane infoPane;

    public Panel(String title, Class entityClass, EntityManager manager){
        this.title = title;
        this.manager = manager;
        this.getStyleClass().add("panel");

        infoPane = new InfoPane(entityClass);

        table = new EntityTable(entityClass, manager);
        table.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends Entity> observable, Entity oldValue, Entity newValue) -> {
                    infoPane.setEntity(newValue);
                }
        );


        HBox buttonBar = generateButtonBar();

        this.getChildren().addAll(infoPane, buttonBar, table);
    }

    private HBox generateButtonBar(){
        HBox buttonBar = new HBox();
        buttonBar.setSpacing(10.0);
        Button updateButton = new Button("修改");
        Button insertButton = new Button("插入");
        Button deleteButton = new Button("删除");

        insertButton.setOnAction(e -> {
            manager.insert(infoPane.getEntity());
        });

        deleteButton.setOnAction(e -> {
            manager.delete(table.getSelectionModel().getSelectedItem());
        });

        updateButton.setOnAction(e -> {
            manager.update(infoPane.getEntity());
        });

        buttonBar.getChildren().addAll(updateButton, insertButton, deleteButton);
        return buttonBar;
    }

    public String getTitle() {
        return title;
    }
}
