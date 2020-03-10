package com.example.simplejson.tokenizer;

public class Token {
    public TokenType type;
    public String value;

    public Token(TokenType type) {
        this.type = type;
    }

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        if (value == null) {
            return String.format("{%s}", type);
        } else {
            return String.format("{%s, %s}", type, value);
        }
    }
}
