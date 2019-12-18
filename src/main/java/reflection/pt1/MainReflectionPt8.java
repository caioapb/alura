package reflection.pt1;

import reflection.pt1.dto.delegador2.Reflexao;
import reflection.pt1.dto.delegador2.Request;

public class MainReflectionPt8 {
    public static void main(String args[]) {
        // NESTE EU MUDEI A CLASSE DO REFLEXAO E REQUEST PARA O ORIGINAL DO CURSO
        String path = "/produto/lista?numero=2&parametro=abc";
        Request request = new Request("reflection.pt1.dto", path);
        Object invocaMetodo =
            new Reflexao()
                .refleteClasse(request.getCaminhoCompleto())
                .invocaInstancia()
                .getMetodo(request.getNomeMetodo(), request.getQueryParams()).invoca();

    }
}
