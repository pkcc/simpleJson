package com.example.simplejson.parser;

import com.example.simplejson.exception.ParserException;
import com.example.simplejson.tokenizer.Token;
import com.example.simplejson.tokenizer.TokenType;

public class Parser {
    private TokenReader reader;

    public Parser(String str) {
        reader = new TokenReader(str);
    }

    public Object parse() {
        switch (reader.peek().type) {
            case EOF:
                return new JsonObject();
            case BEGIN_OBJECT:
                JsonObject obj = parseObject();
                exceptNextAndGet(TokenType.EOF);
                return obj;
            case BEGIN_ARRAY:
                JsonArray arr = parseArray();
                exceptNextAndGet(TokenType.EOF);
                return arr;
            default:
                throw new ParserException();
        }
    }

    private JsonObject parseObject() {
        JsonObject obj = new JsonObject();
        reader.next();
        while (reader.peek().type != TokenType.END_OBJECT) {
            String key = exceptNextAndGet(TokenType.STRING).value;
            exceptNextAndGet(TokenType.COLON);
            Object value = parseValue();
            obj.put(key, value);
            if (reader.peek().type == TokenType.END_OBJECT) break;
            exceptNextAndGet(TokenType.COMMA);
        }
        reader.next();
        return obj;
    }

    private JsonArray parseArray() {
        reader.next();
        JsonArray arr = new JsonArray();
        while (reader.peek().type != TokenType.END_ARRAY) {
            Object value = parseValue();
            arr.add(value);
            if (reader.peek().type == TokenType.END_ARRAY) break;
            exceptNextAndGet(TokenType.COMMA);
        }
        reader.next();
        return arr;
    }

    private Object parseValue() {
        switch (reader.peek().type) {
            case STRING:
                return reader.next().value;
            case NUMBER:
                if (reader.peek().value.contains(".")) {
                    return Double.parseDouble(reader.next().value);
                } else {
                    return Long.parseLong(reader.next().value);
                }
            case NULL:
                reader.next();
                return null;
            case TRUE:
                reader.next();
                return true;
            case FALSE:
                reader.next();
                return false;
            case BEGIN_OBJECT:
                return parseObject();
            case BEGIN_ARRAY:
                return parseArray();
            default:
                throw new ParserException();
        }
    }

    private Token exceptNextAndGet(TokenType type) {
        if (reader.peek().type != type) throw new ParserException();
        return reader.next();
    }
}
