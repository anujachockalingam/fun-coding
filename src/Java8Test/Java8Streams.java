package Java8Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author c59785a
 * Created on 2020-08-31 14:00
 **/
public class Java8Streams {
    public static void main(String[] args) {
       /* Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);*/
//
//        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//
////get list of unique squares
//        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());


        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("Filtered List: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);


        List numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> (int) x).summaryStatistics();

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }




}
