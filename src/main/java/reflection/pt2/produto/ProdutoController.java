package reflection.pt2.produto;

import reflection.pt2.dto.Produto;

import java.util.Arrays;
import java.util.List;

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

    public Produto getProduto() {
        return new Produto("Nintendinho", 600.0, "Nintendo");
    }

    public List<Produto> getListProduto() {
        return Arrays.asList(
            new Produto("Nintendinho", 400.0, "Nintendo"),
            new Produto("Super Nintendo", 500.0, "Nintendo"),
            new Produto("Nintendo 64", 300.0, "Nintendo"),
            new Produto("Game Cuber", 500.0, "Nintendo"),
            new Produto("Wii", 900.0, "Nintendo"),
            new Produto("Wii U", 1300.0, "Nintendo"),
            new Produto("Switch", 2500.0, "Nintendo")
        );
    }
}
