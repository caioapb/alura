package estudo.bot.request.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Repeatable(RequestMethod.List.class)
public @interface RequestMethod {
    String value(); //biblioteca
    String path() default "";

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.PARAMETER})
    @interface List {
        RequestMethod[] value();
    }
}
