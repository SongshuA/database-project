package uikit;

import entity.EntityManager;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class Panel extends VBox {
    private String title;
    private Class entityClass;
    private EntityManager manager;
    private Table table;

    public Panel(String title, Class entityClass, EntityManager manager){
        this.title = title;
        this.entityClass = entityClass;
        this.manager = manager;
        this.getStyleClass().add("panel");

        table = new Table(entityClass, manager);
        HBox buttonBar = generateButtonBar();

        this.getChildren().addAll(buttonBar, table);
    }

    private HBox generateButtonBar(){
        HBox buttonBar = new HBox();
        buttonBar.setSpacing(10.0);
        Button insertButton = new Button("插入");
        Button deleteButton = new Button("删除");

        deleteButton.setOnAction(e -> {
            manager.delete(table.getSelectedItem());
        });

        buttonBar.getChildren().addAll(insertButton, deleteButton);
        return buttonBar;
    }

    public String getTitle() {
        return title;
    }
}
