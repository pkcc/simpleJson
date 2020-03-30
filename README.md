# Simple Json

一个学完编译原理词法和语法分析后写的练手小项目

支持对象实体映射

## 使用方法

**序列化**

```java
String result = JsonParser.serialize(javaBean);
```

**反序列化**

```java
JavaBean result = JsonParser.deserialize(jsonStr, JavaBean.class);
```

## 项目结构
```
├─exception
│      BeanMapperException.java           // 还原JavaBean时出错
│      ParserException.java               // Json字符串语法有错
│      UnsupportedMapTypeException.java   // 还原JavaBean时遇到不支持的类型
│
├─mapper
│      Mapper.java            // 使用反射技术实现JsonObject和JavaBean之间、JsonArray和ArrayList之间的双向转换
│
├─parser                      // 语法分析器
│      JsonArray.java
│      JsonObject.java
│      Parser.java
│      TokenReader.java
│
├─serializer
│      Serializer.java        // 序列化，可将JsonObject和JsonArray转成Json字符串
│
├─tokenizer                   // 词法分析器
|      CharReader.java
|      Token.java
|      Tokenizer.java
|      TokenType.java
│
├─JsonParser.java             // 封装好的接口，提供serialize和deserialize方法
 ```
