package estudo.bot.telegram;

import estudo.bot.request.annotations.RequestParam;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@RequestParam(value = "Telegram", convert = "estudo.bot.telegram.ConversorTelegram.convert")
public @interface TelegramParam {
    String value() default "";
    String alias() default ""; // apelido da variavel
    String convert() default ""; // metodo de conversao
    Class<?> from() default Object.class; // tipo de onde deve ser convertido
}
