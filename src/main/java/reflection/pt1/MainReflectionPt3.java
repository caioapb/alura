package reflection.pt1;

import generico.Geral;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MainReflectionPt3 {
    static final String pacoteBase = "reflection.pt1.dto.";
    public static void main(String args[]) {
        // preferencia em usar o produto
        try (Scanner scanner = new Scanner(System.in)) {
            String path = scanner.nextLine(); //ex: /produto/filtra
            comReflection(path);
        }
    }

    public static void comReflection(String path) {
        String partesUrl[] = path.replaceFirst("/", "").split("/");
        String nomeClasse = partesUrl[0];
        String metodo = partesUrl[1];
        String nomeController = Geral.capitalize(nomeClasse)+"Controller";
        //instancias de classe
        try {
            Class<?> classController = Class.forName(pacoteBase+nomeClasse+"."+ nomeController);
            Constructor<?> constructorController = classController.getDeclaredConstructor();
            Constructor<?> constructorControllerParam = classController.getDeclaredConstructor(String.class);
            constructorControllerParam.setAccessible(true);// permite executar o construtor mesmo sendo privado
            Method method = classController.getMethod(metodo);
            Object invoked = method.invoke(constructorController.newInstance());
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }

    }
}
