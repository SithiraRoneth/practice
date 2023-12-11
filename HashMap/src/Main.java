import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] ar = {"s", "d", "f", "g", "s", "d"};

        HashSet hashSet = new HashSet(Arrays.stream(ar).collect(Collectors.toList()));
        System.out.println(hashSet);

        int[] numbers = {10,20,30,40,50,60,70,80,90,100};
        List<Integer>list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        Collections.reverse(list);

        System.out.println(list);

    }
}