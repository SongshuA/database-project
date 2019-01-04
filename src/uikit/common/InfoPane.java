package uikit.common;

import entity.Entity;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class InfoPane extends GridPane {
    private Class entityClass;
    private Field[] fields;
    private Map<String, TextField> values;

    public InfoPane(Class entityClass){
        this.getStyleClass().add("info-pane");
        this.entityClass = entityClass;
        fields = entityClass.getDeclaredFields();
        values = new HashMap<>();

        int rows = fields.length;
        for(int i = 0; i < rows; i++){
            String title = Utils.translate(entityClass, fields[i].getName());
            Label label = new Label(title);
            TextField tf = new TextField();
            tf.setPromptText(title);
            values.put(fields[i].getName(), tf);

            this.add(label, 0, i);
            this.add(tf, 1, i);
        }
    }

    public Entity getEntity(){
        try{
            Entity entity = (Entity) entityClass.newInstance();
            for(Field f : fields){
                String value = values.get(f.getName()).getText();
                if(!value.isEmpty())
                    Utils.setter(entity, f.getName(), value, f.getType());
            }
            return entity;

        }catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setEntity(Entity entity){
        if(entity == null){
            for(Map.Entry<String, TextField> entry : values.entrySet()){
                entry.getValue().setText("");
            }
            return;
        }
        for(Field f : fields){
            Object value = Utils.getter(entity, f.getName());
            if(value != null)
                values.get(f.getName()).setText(value.toString());
            else
                values.get(f.getName()).setText("");
        }
    }
}
