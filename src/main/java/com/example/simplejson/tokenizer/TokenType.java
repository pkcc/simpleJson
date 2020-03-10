package com.example.simplejson.tokenizer;

public enum TokenType {
    BEGIN_OBJECT,
    END_OBJECT,
    BEGIN_ARRAY,
    END_ARRAY,
    NULL,
    TRUE,
    FALSE,
    NUMBER,
    STRING,
    COMMA,  //逗号 ,
    COLON,  //冒号 :
    EOF,
}
