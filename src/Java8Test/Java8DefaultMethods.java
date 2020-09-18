package Java8Test;

/**
 * @author c59785a
 * Created on 2020-08-31 13:50
 **/
public class Java8DefaultMethods {
    public interface Vehicle {

        default void print() {
            System.out.println("I am a vehicle!");
        }

        static void blowHorn() {
            System.out.println("Blowing horn!!!");
        }
    }
    public interface FourWheeler {

        default void print() {
            System.out.println("I am a four wheeler!");
        }
    }

    class Car implements Vehicle, FourWheeler {

        public void print() {
            Vehicle.super.print();
            FourWheeler.super.print();
            Vehicle.blowHorn();
            System.out.println("I am a car!");
        }
    }
}

