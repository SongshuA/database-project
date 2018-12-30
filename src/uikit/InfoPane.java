package uikit;

import entity.Entity;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class InfoPane extends GridPane {
    private Class entityClass;
    private Field[] fields;
    private Map<String, TextField> values;

    public InfoPane(Class entityClass){
        this.entityClass = entityClass;
        fields = entityClass.getDeclaredFields();
        values = new HashMap<>();

        int rows = fields.length;
        for(int i = 0; i < rows; i++){
            Label label = new Label(Utils.translate(entityClass, fields[i].getName()));
            TextField tf = new TextField();
            tf.setPromptText(fields[i].getName());
            values.put(fields[i].getName(), tf);

            this.add(label, 0, i);
            this.add(tf, 1, i);
        }
    }

    public Entity getEntity(){
        try{
            Entity entity = (Entity) entityClass.newInstance();
            for(Field f : fields){
                Utils.setter(entity, f.getName(), values.get(f.getName()).getText(), f.getType());
            }
            return entity;

        }catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setEntity(Entity entity){
        for(Field f : fields){
            Object value = Utils.getter(entity, f.getName());
            if(value != null)
                values.get(f.getName()).setText(value.toString());
            else
                values.get(f.getName()).setText("");
        }
    }
}
