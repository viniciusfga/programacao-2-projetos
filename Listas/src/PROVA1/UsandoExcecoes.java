package PROVA1;

public class UsandoExcecoes {


    public static void main(String args[]) {
        try {
            method1();
        } catch (UserException e) {
            System.err.println(e.getMessage() + "/n The stack trace is : ");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Outra exceção ocorreu.");
            e.printStackTrace();
        } finally {
            System.out.println("Bloco Finally Executado");
        }

    }
    public static void method1() throws UserException {
        method2();
    }

    public static void method2() throws UserException {
        method3();
    }

    public static void method3() throws UserException {
        throw new UserException();
    }
}

class UserException extends Exception {
    public UserException() {
        super("This is a user defined exception. ");
    }

}

