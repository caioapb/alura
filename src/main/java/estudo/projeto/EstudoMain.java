package estudo.projeto;

import estudo.bot.request.ExecutePath;
import estudo.bot.request.Request;
import estudo.bot.telegram.ProdutoTelegram;
import estudo.bot.telegram.TipoTelegram;

import java.lang.reflect.InvocationTargetException;

public class EstudoMain {

    public static void main (String args[]) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String base = "estudo/projeto";
        Request request = new Request(base, "/produto/mensagem?msg=mensagem");
        System.out.println(ExecutePath.executa(request));


        TipoTelegram tt = new TipoTelegram("marca1", "empresa1", 123);
        ProdutoTelegram produtoTelegram = new ProdutoTelegram("Produto 1", 10, tt);

        request = new Request(base, "/produto/teste");
        request.putParam("pt", produtoTelegram);
//        request.putParam("tt", tt);
        System.out.println(ExecutePath.executa(request));
        System.out.println("---------------");
    }
}
