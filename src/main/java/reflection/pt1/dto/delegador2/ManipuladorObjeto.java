package reflection.pt1.dto.delegador2;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

public class ManipuladorObjeto  {
    private Object instancia;

    public ManipuladorObjeto(Object instancia) {
        this.instancia = instancia;
    }

    public ManipuladorMetodo getMetodo(String nomeMetodo) {
        try {
            Method method = instancia.getClass().getDeclaredMethod(nomeMetodo);
            return new ManipuladorMetodo(instancia, method);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public ManipuladorMetodo getMetodo(String nomeMetodo, Map<String, Object> params) {
        Stream<Method> listaMetodos = Stream.of(instancia.getClass().getDeclaredMethods());
        Method selecionado = listaMetodos.filter(
            metodo ->
                metodo.getName().equals(nomeMetodo) &&
                metodo.getParameterCount()==params.values().size() &&
                Stream.of(metodo.getParameters())
                    .allMatch(arg->
                        //O compilador, por padrão, troca o nome das variaveis para arg0, arg1, etc.
                        //para contornar isso, é necessario a seguinte configuração:
                        //File>Settings(Alt+Ctrl+S)>Build, Execution, Deployment>Compiler>Java Compiler
                        //Campo "Additional command line parameters:" :
                        //  ► "-parameters" (digitado)
                        params.keySet().contains(arg.getName()) &&
                        params.get(arg.getName()).getClass().equals(arg.getType())
                    )
            ).findFirst().orElseThrow(()->new RuntimeException());
        return new ManipuladorMetodo(instancia, selecionado, params);
    }
}
