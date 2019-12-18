package reflection.pt1.dto.produto;

public class ProdutoController {

    public ProdutoController() {
    }

    //construtor de exemplo
    public ProdutoController(String string) {
        System.out.println(string);
    }

    public void filtra() {System.out.println("filtra");}
    public void lista() {System.out.println("lista");}

    //com parametro
    public void lista(String parametro) {System.out.println("lista "+parametro);}
    public void lista(String parametro, Integer numero) {System.out.println("lista "+parametro);}
}
