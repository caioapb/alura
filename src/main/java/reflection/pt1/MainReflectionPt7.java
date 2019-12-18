package reflection.pt1;

import reflection.pt1.dto.delegador.Reflexao;
import reflection.pt1.dto.delegador.Request;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflectionPt7 {
    public static void main(String args[]) {
        String path = "/produto/lista";
        Request request = new Request("reflection.pt1.dto", path);
        Reflexao ref = new Reflexao();
        Object instancia = ref.refleteClasse(request.getCaminhoCompleto()).getConstrutor("teste")
                .invoca();
        try {
            Method method = ref.getController().getDeclaredMethod(request.getNomeMetodo());
            Object invocaMetodo = method.invoke(instancia); //op1
            //---------------------------------------------
            Object invocaMetodo2 = new Reflexao().refleteClasse(request.getCaminhoCompleto()).invocaInstancia()
                .getMetodo(request.getNomeMetodo(), "teste2").invoca();

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
