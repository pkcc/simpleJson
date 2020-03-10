package com.example.simplejson.tokenizer;

import com.example.simplejson.exception.ParserException;

public class Tokenizer {
    CharReader reader;

    public Tokenizer(String str) {
        reader = new CharReader(str);
    }

    public Token nextToken() {
        char ch;
        do {
            if (reader.isEOF()) return new Token(TokenType.EOF);
            ch = reader.next();
        } while (Character.isWhitespace(ch));
        switch (ch) {
            case '{':
                return new Token(TokenType.BEGIN_OBJECT);
            case '}':
                return new Token(TokenType.END_OBJECT);
            case '[':
                return new Token(TokenType.BEGIN_ARRAY);
            case ']':
                return new Token(TokenType.END_ARRAY);
            case ':':
                return new Token(TokenType.COLON);
            case ',':
                return new Token(TokenType.COMMA);
            case '"':
                reader.rollBack();
                return readString();
            case 'n':
                return readNull();
            case 't':
            case 'f':
                reader.rollBack();
                return readBool();
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case '-':   //负数
                reader.rollBack();
                return readNumber();
            default:
                throw new ParserException();
        }
    }

    private Token readNull() {
        if (reader.next() != 'u' || reader.next() != 'l' || reader.next() != 'l') {
            throw new ParserException();
        }
        return new Token(TokenType.NULL);
    }

    private Token readString() {
        StringBuilder sb = new StringBuilder();
        reader.next();
        while (reader.peek() != '"') {
            if (reader.peek() == '\\') {
                sb.append(readEscapeChar());
            } else {
                sb.append(reader.next());
            }
        }
        reader.next();
        return new Token(TokenType.STRING, sb.toString());
    }

    private char readEscapeChar() {
        reader.next();
        switch (reader.peek()) {
            case '"':
            case '\\':
            case '/':
                return reader.next();
            case 'b':
                reader.next();
                return '\b';
            case 'f':
                reader.next();
                return '\f';
            case 'n':
                reader.next();
                return '\n';
            case 'r':
                reader.next();
                return '\r';
            case 't':
                reader.next();
                return '\t';
            default:
                throw new ParserException();
        }
    }

    private Token readBool() {
        if (reader.next() == 't') {
            if (reader.next() != 'r' || reader.next() != 'u' || reader.next() != 'e') {
                throw new ParserException();
            }
            return new Token(TokenType.TRUE);
        } else {
            if (reader.next() != 'a' || reader.next() != 'l' || reader.next() != 's' || reader.next() != 'e') {
                throw new ParserException();
            }
            return new Token(TokenType.FALSE);
        }
    }

    private Token readNumber() {
        StringBuilder sb = new StringBuilder();

        if (reader.peek() == '-') {
            sb.append(reader.next());
        }

        char ch = reader.peek();
        if (ch == '0') {
            sb.append(reader.next());
        } else if ('1' <= ch && ch <= '9') {
            while (isDigit(reader.peek())) {
                sb.append(reader.next());
            }
        } else throw new ParserException();

        if (reader.peek() == '.') {
            sb.append(reader.next());
            if (!isDigit(reader.peek())) throw new ParserException();
            while (isDigit(reader.peek())) {
                sb.append(reader.next());
            }
        }

        if (reader.peek() == 'e' || reader.peek() == 'E') {
            sb.append(reader.next());

            if (reader.peek() == '+' || reader.peek() == '-') {
                sb.append(reader.next());
            }

            if (!isDigit(reader.peek())) throw new ParserException();
            while (isDigit(reader.peek())) {
                sb.append(reader.next());
            }
        }

        return new Token(TokenType.NUMBER, sb.toString());
    }

    private boolean isDigit(char ch) {
        return '0' <= ch && ch <= '9';
    }
}
