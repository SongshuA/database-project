package uikit.common;

import entity.Entity;
import org.json.JSONException;
import org.json.JSONObject;
import sun.applet.Main;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static JSONObject vocab;

    private Utils(){}

    public static void setter(Entity entity, String attr, String value, Class<?> parameterType){
        try {
            Object actualValue = value;
            if(!parameterType.equals(String.class)){
                Method trans = parameterType.getMethod("valueOf", String.class);
                actualValue = trans.invoke(null, value);
            }
            Method met = entity.getClass().getMethod("set" + transVariableName(attr), parameterType);
            met.invoke(entity, actualValue);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Object getter(Entity entity, String attr) {
        try {
            Method met = entity.getClass().getMethod("get" + transVariableName(attr));
            return met.invoke(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String transVariableName(String s){	// 将单词的首字母大写
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }

    public static String translate(Class<?> classObj, String fieldName){
        if(vocab == null){
            try {
                vocab = readJSON(Main.class.getResourceAsStream("/vocab.json"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String name = classObj.getSimpleName();
        try{
            if(vocab.has(name)) {
                JSONObject sub = vocab.getJSONObject(name);
                if (sub.has(fieldName))
                    return sub.getString(fieldName);

                else if (vocab.has("common")) {
                    sub = vocab.getJSONObject("common");
                    if (sub.has(fieldName))
                        return sub.getString(fieldName);
                }
            }

        }catch (JSONException e){
            return fieldName;
        }
        return fieldName;
    }

    private static JSONObject readJSON(InputStream stream) throws IOException {
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        String s = null;
        while(((s = br.readLine()) != null))
            result.append(s);
        br.close();
        try {
            return new JSONObject(result.toString());
        } catch (JSONException e) {
            return null;
        }
    }

    public static Float parseFloat(String str){
        try{
            return Float.parseFloat(str);
        }catch (NumberFormatException e){
            return null;
        }
    }

    public static Integer parseInt(String str){
        try{
            return Integer.parseInt(str);
        }catch (NumberFormatException e){
            return null;
        }
    }
}
