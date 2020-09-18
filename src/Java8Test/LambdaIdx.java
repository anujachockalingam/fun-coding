package Java8Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author c59785a
 * Created on 2020-09-01 14:39
 **/
public class LambdaIdx {
    public static void main(String[] args) {
       /* String[] names = {"Sam", "Pamela", "Dave", "Pascal", "Erik"};
        AtomicInteger index = new AtomicInteger();
        List<String> list = Arrays.stream(names)
                .filter(n -> n.length() <= index.incrementAndGet())
                .collect(Collectors.toList());
        list.forEach(x->System.out.println(x));
*/

        String[] names = {"Sam", "Pamela", "Dave", "Pascal", "Erik"};
        List<String> list = IntStream.range(0, names.length)
                .filter(i -> names[i].length() >= i)
                .mapToObj(i -> names[i])
                .collect(Collectors.toList());
        list.forEach(x->System.out.println(x));
    }
}
