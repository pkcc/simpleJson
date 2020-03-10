package com.example.simplejson.parser;

import java.util.ArrayList;

public class JsonArray extends ArrayList<Object> {

    public JsonObject getObject(int i) {
        return (JsonObject) get(i);
    }

    public JsonArray getArray(int i) {
        return (JsonArray) get(i);
    }

    public String getString(int i) {
        return (String) get(i);
    }

    public Long getLong(int i) {
        return (Long) get(i);
    }

    public Double getDouble(int i) {
        return (Double) get(i);
    }

    public Boolean getBool(int i) {
        return (Boolean) get(i);
    }

}
