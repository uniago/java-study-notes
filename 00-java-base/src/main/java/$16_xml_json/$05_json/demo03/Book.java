package $16_xml_json.$05_json.demo03;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigInteger;

public class Book {
    public String name;
    // 表示反序列化isbn时使用自定义的IsbnDeserializer:
    @JsonDeserialize(using = IsbnDeserializer.class)
    public BigInteger isbn;
}
