package com.example.simplejson.serializer;

import com.example.simplejson.parser.JsonArray;
import com.example.simplejson.parser.JsonObject;

import java.util.Iterator;
import java.util.Map;

public class Serializer {
    private static StringBuilder sb;

    private Serializer() {
    }

    public static String serialize(JsonObject jsonObject) {
        sb = new StringBuilder();
        appendObject(jsonObject);
        return sb.toString();
    }

    private static void appendObject(JsonObject obj) {
        sb.append('{');
        Iterator<Map.Entry<String, Object>> it = obj.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            appendString(entry.getKey());
            sb.append(':');
            appendValue(entry.getValue());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append('}');
    }

    private static void appendArray(JsonArray obj) {
        sb.append('[');
        for (int i = 0; i < obj.size(); i++) {
            appendValue(obj.get(i));
            if (i < obj.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(']');
    }

    private static void appendValue(Object obj) {
        if (obj instanceof JsonObject) {
            appendObject((JsonObject) obj);
        } else if (obj instanceof JsonArray) {
            appendArray((JsonArray) obj);
        } else if (obj instanceof String) {
            appendString((String) obj);
        } else {
            sb.append(obj.toString());
        }
    }

    private static void appendString(String str) {
        sb.append('"');
        sb.append(str);
        sb.append('"');
    }
}
