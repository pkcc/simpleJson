package com.example.simplejson.parser;

import java.util.HashMap;

public class JsonObject extends HashMap<String, Object> {

    public JsonObject getObject(String key) {
        return (JsonObject) get(key);
    }

    public JsonArray getArray(String key) {
        return (JsonArray) get(key);
    }

    public String getString(String key) {
        return (String) get(key);
    }

    public Long getLong(String key) {
        return (Long) get(key);
    }

    public Double getDouble(String key) {
        return (Double) get(key);
    }

    public Boolean getBool(String key) {
        return (Boolean) get(key);
    }
}
