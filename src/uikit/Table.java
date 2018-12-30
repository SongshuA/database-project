package uikit;

import entity.Entity;
import entity.EntityManager;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.lang.reflect.Field;
import java.util.List;

public class Table extends VBox {
    private EntityManager manager;
    private Field[] fields;
    private ListView<Entity> listView;

    public Table(Class entityClass, EntityManager manager){
        this.manager = manager;

        this.fields = entityClass.getDeclaredFields();
        HBox header = new HBox();
        for(Field f : fields){
            Label label = new Label(f.getName());
            label.prefWidthProperty().bind(header.widthProperty().divide(fields.length));
            header.getChildren().add(label);
        }

        listView = new ListView<>();
        listView.setCellFactory((ListView<Entity> l) -> new EntityCell());
        refresh();
        this.getChildren().addAll(header, listView);
    }

    public void refresh(){
        listView.getItems().clear();
        List entities = manager.get();
        for(Object entity : entities)
            listView.getItems().add((Entity)entity);

    }

    public Entity getSelectedItem(){
        return listView.getSelectionModel().getSelectedItem();
    }

    private class EntityCell extends ListCell<Entity>{
        @Override
        protected void updateItem(Entity item, boolean empty) {
            super.updateItem(item, empty);
            if(!empty){
                HBox hBox = new HBox();
                int length = fields.length;
                try{
                    for(Field f : fields){
                        Label label = new Label(f.get(item).toString());
                        label.prefWidthProperty().bind(hBox.widthProperty().divide(length));
                        hBox.getChildren().add(label);
                    }
                }catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                this.setGraphic(hBox);
            }
        }
    }


}
