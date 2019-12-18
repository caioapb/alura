package reflection.pt1;

import reflection.pt1.dto.delegador.Reflexao;
import reflection.pt1.dto.delegador.Request;

public class MainReflectionPt5 {
    public static void main(String args[]) {
        // dividindo as atribuições
        String path = "/produto/lista";
        Request request = new Request("reflection.pt1.dto", path);
        Reflexao ref = new Reflexao();
        Object instancia = ref.refleteClasse(request.getCaminhoCompleto()).getConstrutor().invoca();
        // esse segundo instancia nao funcionou e estou com preguiça de arrumar
//        Object instancia2 =ref.refleteClasse(request.getCaminhoCompleto()).getConstrutor("teste").invoca("teste");

    }
}
