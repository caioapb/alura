package reflection.pt1;

import reflection.pt1.dto.delegador.Reflexao;
import reflection.pt1.dto.delegador.Request;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflectionPt6 {
    public static void main(String args[]) {
        // ambos invokeds funcionam, mas fiz o primeiro para nao instanciar ver uma forma alternativa
        String path = "/produto/lista";
        Request request = new Request("reflection.pt1.dto", path);
        Reflexao ref = new Reflexao();
        Object instancia = ref.refleteClasse(request.getCaminhoCompleto()).getConstrutor().invoca();
        try {
            Method method = ref.getController().getDeclaredMethod(request.getNomeMetodo());
            Object invoked = method.invoke(instancia); //op1
            //---------------------------------------------
            Object invoked2 = new Reflexao().refleteClasse(request.getCaminhoCompleto()).invocaInstancia()
                    .getMetodo(request.getNomeMetodo()).invoca();

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
