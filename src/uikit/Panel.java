package uikit;

import entity.Entity;
import entity.EntityManager;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;



public class Panel extends VBox {
    private String title;
    private EntityManager manager;
    private EntityTable table;
    private InfoPane infoPane;

    public Panel(String title, Class entityClass, EntityManager manager){
        this.getStyleClass().add("panel");
        this.title = title;
        this.manager = manager;

        infoPane = new InfoPane(entityClass);

        table = new EntityTable(entityClass, manager);
        table.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends Entity> observable, Entity oldValue, Entity newValue) -> {
                    infoPane.setEntity(newValue);
                }
        );

        setVgrow(table, Priority.ALWAYS);


        HBox buttonBar = generateButtonBar();

        this.getChildren().addAll(infoPane, buttonBar, table);
    }

    private HBox generateButtonBar(){
        HBox buttonBar = new HBox();
        buttonBar.setSpacing(10.0);
        Button updateButton = new Button("修改");
        updateButton.getStyleClass().addAll("btn", "btn-blue");
        Button insertButton = new Button("插入");
        insertButton.getStyleClass().addAll("btn", "btn-green");
        Button deleteButton = new Button("删除");
        deleteButton.getStyleClass().addAll("btn", "btn-red");

        insertButton.setOnAction(e -> {
            manager.insert(infoPane.getEntity());
        });

        deleteButton.setOnAction(e -> {
            Entity entity = table.getSelectionModel().getSelectedItem();
            if(entity != null)
                manager.delete(entity);
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
