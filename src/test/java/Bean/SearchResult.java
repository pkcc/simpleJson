package Bean;

import java.util.List;

public class SearchResult {
    private int code;
    private String msg;
    private List<Book> books;

    public SearchResult(int code, String msg, List<Book> books) {
        this.code = code;
        this.msg = msg;
        this.books = books;
    }

    public SearchResult() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", books=" + books +
                '}';
    }
}
