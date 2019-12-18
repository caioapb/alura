package reflection.pt1.dto.delegador2;

public class Reflexao {

   public ManipuladorClasse refleteClasse(String fqn) {
        try {
            return new ManipuladorClasse(Class.forName(fqn));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
