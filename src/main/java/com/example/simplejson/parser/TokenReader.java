package com.example.simplejson.parser;

import com.example.simplejson.tokenizer.Token;
import com.example.simplejson.tokenizer.Tokenizer;

public class TokenReader {
    private Token nextToken;
    private Tokenizer tokenizer;

    public TokenReader(String str) {
        tokenizer = new Tokenizer(str);
        nextToken = tokenizer.nextToken();
    }

    public Token peek() {
        return nextToken;
    }

    public Token next() {
        Token ret = nextToken;
        nextToken = tokenizer.nextToken();
        return ret;
    }
}
