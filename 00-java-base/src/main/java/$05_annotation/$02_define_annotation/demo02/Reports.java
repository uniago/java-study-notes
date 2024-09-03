package $05_annotation.$02_define_annotation.demo02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Reports {
    Report[] value();
}
