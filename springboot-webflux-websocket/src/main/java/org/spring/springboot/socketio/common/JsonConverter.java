package org.spring.springboot.socketio.common;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONException;
import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * 对象和Json转换器
 *
 * @author mongoding
 * @version 1.0
 * @since 2018/1/18
 */
public class JsonConverter {
    public static JSONObject objectToJSONObject(Object object) {
        try {
            String jsonString = new ObjectMapper().writeValueAsString(object);
            return new JSONObject(jsonString);
        } catch (JSONException | JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONArray objectToJSONArray(Object object) {
        try {
            String jsonString = new ObjectMapper().writeValueAsString(object);
            return new JSONArray(jsonString);
        } catch (JSONException | JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T jsonObjectToObject(Object jsonObject, Class<T> clazz) {
        try {
            // List<Car> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>(){});
            return new ObjectMapper().readValue(jsonObject.toString(), clazz);
        } catch (IOException e) {
            return null;
        }
    }
}
