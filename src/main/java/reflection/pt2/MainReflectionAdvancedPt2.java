package reflection.pt2;


import reflection.pt1.dto.delegador2.Reflexao;
import reflection.pt1.dto.delegador2.Request;
import reflection.pt2.dto.ConversorXML;

public class MainReflectionAdvancedPt2 {

    public static void main (String args[]) throws IllegalAccessException, NoSuchFieldException {
        // estou utilizando como base o relexao do relefction pt1->pt8
        String path = "/produto/getListProduto";
        Request request = new Request("reflection.pt2", path);
        Object invocaMetodo =
            new Reflexao()
                .refleteClasse(request.getCaminhoCompleto())
                .invocaInstancia()
                .getMetodo(request.getNomeMetodo(), request.getQueryParams())
                .invoca();
        invocaMetodo = new ConversorXML().converte(invocaMetodo);
        System.out.println(invocaMetodo);
    }
}
