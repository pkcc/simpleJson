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

