package com.example.simplejson.tokenizer;

import com.example.simplejson.exception.ParserException;

public class CharReader {
    private String str;
    private int i;

    public CharReader(String str) {
        this.str = str;
        this.i = 0;
    }

    public boolean isEOF() {
        return i >= str.length();
    }

    public char peek() {
        if (isEOF()) throw new ParserException();
        return str.charAt(i);
    }

    public char next() {
        if (isEOF()) throw new ParserException();
        return str.charAt(i++);
    }

    public void rollBack() {
        if (i > 0) i--;
    }
}
