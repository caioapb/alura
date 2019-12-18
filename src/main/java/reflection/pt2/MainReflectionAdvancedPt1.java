package reflection.pt2;

import reflection.pt2.annotations.NomeTagXml;
import reflection.pt2.dto.Produto;

public class MainReflectionAdvancedPt1 {

    public static void main (String args[]) {
        Produto produto1 = new Produto("Nintendinho", 600.0, "Nintendo");

        Class<?> classe = Produto.class;

        System.out.println(classe.getDeclaredAnnotation(NomeTagXml.class).outroValue());

    }
}
