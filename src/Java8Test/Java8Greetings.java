package Java8Test;

/**
 * @author c59785a
 * Created on 2020-08-31 13:28
 **/

public class Java8Greetings {

    final static String salutation = "Hello! ";

    public static void main(String args[]) {
        GreetingService g1 = message ->
        System.out.println(salutation + message);
        g1.sayMessage("Mahesh");

    }

    //interface and method
    interface GreetingService {
        void sayMessage(String message);
    }
}