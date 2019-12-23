package reflection.pt2;

import reflection.pt2.annotations.NomeTagXml;
import reflection.pt2.dto.Produto;

import java.lang.reflect.Field;

public class MainReflectionAdvancedPt1 {

    public static void main (String args[]) throws IllegalAccessException, NoSuchFieldException {
        Produto produto = new Produto("Nintendinho", 600.0, "Nintendo");
        Class<?> classe = Produto.class;
//        System.out.println(classe.getField("id"));
        for (Field f: classe.getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println(f.getName()+" "+f.get(produto));
        }

        System.out.println(classe.getDeclaredAnnotation(NomeTagXml.class).outroValue());

    }
}
