package pl.edu.pw.mini.jrafalko.truck;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TireCompany {
    String manufacturer();  // Nazwa producenta
    String size();          // Rozmiar opony
}
