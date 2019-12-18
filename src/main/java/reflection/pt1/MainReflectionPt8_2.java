package reflection.pt1;

import reflection.pt1.dto.delegador3.ExecutePath;

import java.lang.reflect.InvocationTargetException;

public class MainReflectionPt8_2 {
    public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // NESTE EU IREI USAR UMA VERSAO MINHA DO DELEGATOR, TOMANDO COMO BASE
        // O DELEGATOR1(versão que fui aprendendo durante o curso) DELEGATOR2 (versão mais fiel ao curso)
        String path = "/produto/lista?numero=2&parametro=abc";
        ExecutePath.getter("reflection.pt1.dto", path);
    }
}
