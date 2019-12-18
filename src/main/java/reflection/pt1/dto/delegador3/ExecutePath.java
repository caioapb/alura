package reflection.pt1.dto.delegador3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ExecutePath {

    public static Object getter(String base, String path)  {
        try {
            Request request = new Request(base, path);
            Constructor<?> constructor = Class.forName(request.getCaminhoCompleto()).getDeclaredConstructor();
            Object instancia = constructor.newInstance();
            if (request.hasParam()) {
                Method selecionado = getMetodo(instancia, request.getNomeMetodo(), request.getQueryParams());
                return invoca(instancia, selecionado, request.getQueryParams());
            }
            return instancia;
        } catch (NoSuchMethodException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro no metodo");
        }
    }

    private static Method getMetodo(Object instancia, String nomeMetodo, Map<String, Object> params) {
        Stream<Method> streamMetodos = Stream.of(instancia.getClass().getDeclaredMethods());
        return streamMetodos.filter(
            metodo ->
                metodo.getName().equals(nomeMetodo) &&
                    metodo.getParameterCount() == params.values().size() &&
                    Stream.of(metodo.getParameters())
                        .allMatch(arg ->
                            //O compilador, por padrão, troca o nome das variaveis para arg0, arg1, etc.
                            //para contornar isso, é necessario a seguinte configuração:
                            //File>Settings(Alt+Ctrl+S)>Build, Execution, Deployment>Compiler>Java Compiler
                            //Campo "Additional command line parameters:" :
                            //  ► "-parameters" (digitado)
                            params.keySet().contains(arg.getName()) &&
                            params.get(arg.getName()).getClass().equals(arg.getType())
                        )
        ).findFirst().orElseThrow(() -> new RuntimeException());
    }

    private static Object invoca(Object instancia, Method method, Map<String, Object> queryParams) throws InvocationTargetException, IllegalAccessException {
        List<Object> paramsMetodo = new ArrayList<>();
        Stream.of(method.getParameters())
            .forEach(p->paramsMetodo.add(queryParams.get(p.getName())));
        return queryParams == null ? method.invoke(instancia) : method.invoke(instancia,paramsMetodo.toArray());
    }
}
