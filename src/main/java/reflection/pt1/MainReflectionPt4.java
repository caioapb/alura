package reflection.pt1;

import java.lang.reflect.InvocationTargetException;

public class MainReflectionPt4 {
    public static void main(String args[]) {
        try {
            //Class<?>.newInstance() VS Constructor<?>.newInstance()
            //(o construtor tem ExportException, como sendo um exception random)
            Class<?> classController = Class.forName("reflection.pt1.dto.cliente.ClienteController");
            Object instance
//                    = classController.newInstance(); //este construtor, se der uma exception, nao possui tratamento
                    = classController.getDeclaredConstructor().newInstance(); //este construtor exige a exception a +, para exceptions imprevistas
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
//        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException e) {
            System.out.println("tratado");
        } catch (NoSuchMethodException e) {
            System.out.println("especial");
        } catch (InvocationTargetException e) {
            System.out.println("especial");
        }
    }
}
