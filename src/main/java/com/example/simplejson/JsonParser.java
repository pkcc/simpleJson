package com.example.simplejson;

import com.example.simplejson.mapper.Mapper;
import com.example.simplejson.parser.JsonArray;
import com.example.simplejson.parser.JsonObject;
import com.example.simplejson.parser.Parser;
import com.example.simplejson.serializer.Serializer;

public class JsonParser {
    public static JsonObject parseObject(String string) {
        return (JsonObject) new Parser(string).parse();
    }

    public static JsonArray parseArray(String string) {
        return (JsonArray) new Parser(string).parse();
    }

    public static <T> T deserialize(String str, Class<T> clazz) {
        JsonObject jsonObject = parseObject(str);
        return Mapper.toBean(jsonObject, clazz);
    }

    public static String serialize(Object object) {
        JsonObject jsonObject = Mapper.toJsonObject(object);
        return Serializer.serialize(jsonObject);
    }
}
