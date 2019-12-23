package reflection.pt1;

import reflection.pt1.dto.delegador2.Reflexao;
import reflection.pt1.dto.delegador2.Request;

public class MainReflectionPt9 {
    public static void main(String args[]) {
        // Preciso voltar ao curso alura reflection pt 1
        String path = "/produto/lista?numero=2&parametro=abc";
        Request request = new Request("reflection.pt1.dto", path);
        Object invocaMetodo =
            new Reflexao()
                .refleteClasse(request.getCaminhoCompleto())
                .invocaInstancia()
                .getMetodo(request.getNomeMetodo(), request.getQueryParams())
//                .comTratamentoDeExcecao((metodo, ex)-> {
//                    System.out.println("Erro no metodo " + metodo.getNome() + " da classe " +
//                            metodo.getDeçlaringClass().getNome()+".\n\n");
//                    throw new RuntimeException("Erro no metodo");
//                })//invokedTargetException
                .invoca();

    }
}
