package pl.edu.pw.mini.jrafalko.censor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WykonajMetode {
    int liczba() default 0;
    // nie wiem czy trzeba tu default
}
