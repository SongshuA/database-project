package uikit.common;

import entity.Entity;
import entity.EntityManager;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.util.List;

public class EntityTable extends TableView<Entity> {
    private EntityManager manager;

    public EntityTable(Class entityClass, EntityManager manager){
        this.getStyleClass().add("entity-table");
        this.manager = manager;

        Field[] fields = entityClass.getDeclaredFields();

        for(Field f : fields){
            TableColumn<Entity, String> column = new TableColumn<>(Utils.translate(entityClass, f.getName()));
            column.setCellValueFactory(new PropertyValueFactory<>(f.getName()));
            column.prefWidthProperty().bind(this.widthProperty().subtract(10).divide(fields.length));
            this.getColumns().add(column);
        }

        refresh();
    }

    public void refresh(){
        this.refresh(manager.get());
    }

    public void refresh(List<Entity> list){
        this.getItems().clear();
        for(Object entity : list)
            this.getItems().add((Entity)entity);
    }

}
