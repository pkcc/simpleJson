import com.example.simplejson.JsonParser;
import com.example.simplejson.tokenizer.Token;
import com.example.simplejson.tokenizer.TokenType;
import com.example.simplejson.tokenizer.Tokenizer;
import org.junit.Test;

public class Test01 {

    @Test
    public void test01() {

        String str = "{\n" +
                "\t\"message\": \"ok\",\n" +
                "\t\"nu\": \"11111111111\",\n" +
                "\t\"ischeck\": \"1\",\n" +
                "\t\"com\": \"yuantong\",\n" +
                "\t\"status\": \"200\",\n" +
                "\t\"condition\": \"F00\",\n" +
                "\t\"state\": \"3\",\n" +
                "\t\"data\": [{\n" +
                "\t\t\"time\": \"2020-02-14 21:33:34\",\n" +
                "\t\t\"context\": \"查无结果\",\n" +
                "\t\t\"ftime\": \"2020-02-14 21:33:34\"\n" +
                "\t}]\n" +
                "}";
        Tokenizer tokenizer = new Tokenizer(str);
        Token token;
        while ((token = tokenizer.nextToken()).type != TokenType.EOF) {
            System.out.println(token);
        }
    }

    @Test
    public void test02() {
        String str = "{\n" +
                "\t\"msg\": \"success\",\n" +
                "\t\"code\": 0,\n" +
                "\t\"data\": [{\n" +
                "\t\t\"foods\": [{\n" +
                "\t\t\t\"price\": 1.2,\n" +
                "\t\t\t\"name\": \"noodles\",\n" +
                "\t\t\t\"icon\": \"http://xxx.com\",\n" +
                "\t\t\t\"description\": \"perfect noodles\",\n" +
                "\t\t\t\"id\": \"123456\"\n" +
                "\t\t}],\n" +
                "\t\t\"name\": \"hot rank\",\n" +
                "\t\t\"type\": 1\n" +
                "\t}, {\n" +
                "\t\t\"foods\": [{\n" +
                "\t\t\t\"price\": 10.9,\n" +
                "\t\t\t\"name\": \"cookie\",\n" +
                "\t\t\t\"icon\": \"http://xxx.com\",\n" +
                "\t\t\t\"description\": \"delicious\",\n" +
                "\t\t\t\"id\": \"123457\"\n" +
                "\t\t}],\n" +
                "\t\t\"name\": \"good\",\n" +
                "\t\t\"type\": 2\n" +
                "\t}]\n" +
                "}";
        System.out.println(JsonParser.parseObject(str));
    }

    @Test
    public void test03() {
        String str = "{\"num\": -21.3592e2}";
        System.out.println(JsonParser.parseObject(str));
    }
}
