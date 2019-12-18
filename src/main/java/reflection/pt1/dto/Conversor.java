package reflection.pt1.dto;

import generico.Geral;

import java.lang.reflect.InvocationTargetException;

public class Conversor {

    public static Object identificaEConverte(String var) {
       if (var.trim().matches("[0-9]")) {
           return Geral.coalesce(
               tryValueOf(var, Integer.class),
               tryValueOf(var, Float.class),
               tryValueOf(var, Double.class),
               tryValueOf(var, Long.class),
               var
            );
       }
       return var;
    }

    private static Object tryValueOf(String var, Class<?> numero) {
        try {
            return numero.getMethod("valueOf",String.class).invoke(null,var);
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {
        } catch (NoSuchMethodException e) {
            System.out.print(numero.getName()+": ");
            e.printStackTrace();
        }
        return null;
    }
}
