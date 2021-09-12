package lesson_8.cashingproxy.calulator.pac;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    CacheType cacheType() default CacheType.IN_MEMORY;
    String fileNamePrefix() default "data";
    boolean zip() default false;
    int listList() default 1_000_000;
    Class[] identity() default {String.class, Integer.class};
}
