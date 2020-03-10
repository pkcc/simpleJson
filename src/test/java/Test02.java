import Bean.Book;
import Bean.Comment;
import Bean.SearchResult;
import com.example.simplejson.JsonParser;
import org.junit.Test;

import java.util.Arrays;

public class Test02 {

    @Test
    public void test01() {
        SearchResult res = getSearchResult();
        String s = JsonParser.serialize(res);
        System.out.println(s);
    }

    private SearchResult getSearchResult() {
        Comment comment1 = new Comment("tom", "very good!");
        Comment comment2 = new Comment("jack", "very cheap!");
        Book book1 = new Book("book1", 18.9, true, Arrays.asList(comment1, comment2));
        Book book2 = new Book("book2", 100.9, false, Arrays.asList(comment1, comment2));
        return new SearchResult(200, "OK", Arrays.asList(book1, book2));
    }

    @Test
    public void test02() {
        String str = "{\"msg\":\"OK\",\"code\":200,\"books\":[{\"comments\":[{\"name\":\"tom\",\"content\":\"very good!\"},{\"name\":\"jack\",\"content\":\"very cheap!\"}],\"price\":18.9,\"name\":\"book1\",\"onSale\":true},{\"comments\":[{\"name\":\"tom\",\"content\":\"very good!\"},{\"name\":\"jack\",\"content\":\"very cheap!\"}],\"price\":100.9,\"name\":\"book2\",\"onSale\":false}]}\n";
        SearchResult res = JsonParser.deserialize(str, SearchResult.class);
        System.out.println(res);
    }
}
