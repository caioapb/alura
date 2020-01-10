package estudo.projeto.produto;

import estudo.bot.request.annotations.RequestMethod;
import estudo.bot.request.annotations.RequestParam;
import estudo.bot.produto.Produto;
import estudo.bot.produto.Tipo;
import estudo.bot.telegram.ProdutoTelegram;
import estudo.bot.telegram.TelegramParam;
import estudo.bot.telegram.TipoTelegram;

public class ProdutoController {

     public String mensagem(@TelegramParam(alias = "msg") String mensagem) {
        return mensagem;
    }

    public Integer teste () {return 0;}

    public Integer teste (
//        @RequestParam(
        @TelegramParam(
            alias = "pt", from = ProdutoTelegram.class
        ) Produto produto)
    {return 1;}

//    public Integer teste (
//        @RequestParam(
//            value = "telegram",alias = "tt", from = TipoTelegram.class, convert = "estudo.bot.telegram.ConversorTelegram.convertTipo"
//        ) Tipo tipo)
//    {return 2;}
//
//    @RequestMethod(value = "telegram", path = "estudo.bot.telegram.ConversorTelegram")
//    public Integer teste (
//        @RequestParam(
//            value = "telegram", alias = "pt", from = ProdutoTelegram.class, convert = "convertProduto"
//        ) Produto produto,
//        @RequestParam(
//            value = "telegram", alias = "tt", from = TipoTelegram.class, convert = "convertTipo"
//        ) Tipo tipo)
//    {return 3;}

}
