package Java8Test;

import java.util.Arrays;
import java.util.List;

public class Java8LambdaTax {

    final static String salutation = "Hello! ";

    public static void main(String args[]) {
        // New way:
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax.stream().map((cost) -> cost + 2 * cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);
    }
    // Applying 12% VAT on each purchase // Old way:
    // List costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
    // double total = 0;
    // for (Integer cost : costBeforeTax)
    // { double price = cost + .12*cost;
    // total = total + price; }
    // System.out.println("Total : " + total);


}