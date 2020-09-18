package Java8Test;/*
Following are the important points to be considered in the above example.

Lambda expressions are used primarily to define inline implementation of a functional interface, i.e.,
an interface with a single method only.
In the above example, we've used various types of lambda expressions to define the operation method of MathOperation interface.
Then we have defined the implementation of sayMessage of GreetingService.

Lambda expression eliminates the need of anonymous class and gives a very simple yet powerful functional programming capability to Java.
 */

class Java8LambdaTest {

    interface MathOperation {
        int operation(int a, int b);
    }


    public static void main(String[] args) {
        Java8LambdaTest tester = new Java8LambdaTest();

        MathOperation addition = (int a, int b) -> a+b;

        MathOperation sub = (a, b) -> a-b;

        MathOperation mul = (a, b) -> {
            return a*b;
        };
        MathOperation div = (a, b) -> a/b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, sub));
        System.out.println("10 x 5 = " + tester.operate(10, 5, mul));
        System.out.println("10 / 5 = " + tester.operate(10, 5, div));
    }



    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
