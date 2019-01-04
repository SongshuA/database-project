package uikit.common;

import entity.Entity;
import entity.EntityManager;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;



public abstract class Panel extends VBox {
    private String title;
    protected EntityManager manager;
    protected EntityTable table;
    private InfoPane infoPane;
    protected QueryPane queryPane;

    public Panel(Class entityClass, EntityManager manager, String[] queryItems, boolean writable){
        this.getStyleClass().add("panel");
        this.title = Utils.translate(entityClass, entityClass.getSimpleName());
        this.manager = manager;

        if(queryItems != null && queryItems.length > 0){
            queryPane = new QueryPane(entityClass, queryItems);
            this.getChildren().add(queryPane);
        }

        table = new EntityTable(entityClass, manager);
        setVgrow(table, Priority.ALWAYS);

        if(writable){
            table.getSelectionModel().selectedItemProperty().addListener(
                    (ObservableValue<? extends Entity> observable, Entity oldValue, Entity newValue) -> {
                        infoPane.setEntity(newValue);
                    }
            );
            infoPane = new InfoPane(entityClass);
            HBox buttonBar = generateButtonBar();
            this.getChildren().addAll(infoPane, buttonBar);
        }

        this.getChildren().add(table);
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
            Entity entity = infoPane.getEntity();
            if(entity != null)
                manager.insert(entity);
            table.refresh();
        });

        deleteButton.setOnAction(e -> {
            Entity entity = table.getSelectionModel().getSelectedItem();
            if(entity != null)
                manager.delete(entity);
            table.refresh();
        });

        updateButton.setOnAction(e -> {
            manager.update(infoPane.getEntity());
            table.refresh();
        });

        buttonBar.getChildren().addAll(updateButton, insertButton, deleteButton);
        return buttonBar;
    }

    public String getTitle() {
        return title;
    }
}
