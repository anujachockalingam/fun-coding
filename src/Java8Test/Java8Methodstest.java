package Java8Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author c59785a
 * Created on 2020-08-31 13:35
 *
 *
 * Method references help to point to methods by their names. A method reference is described using "::" symbol.
 * A method reference can be used to point the following types of methods −
 *
 * Static methods
 * Instance methods
 * Constructors using new operator (TreeSet::new)
 **/

public class Java8Methodstest {

    public static void main(String args[]) {
        List names = new ArrayList();

        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");


        //Here we have passed System.out::println method as a static method reference.
        names.forEach(System.out::println);


    }
}

