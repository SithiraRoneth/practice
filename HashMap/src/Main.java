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

        int[] sort = {10,1,46,67,23,100,30};

        List<Integer>integerList = Arrays.stream(sort).boxed().sorted().collect(Collectors.toList());
        Collections.sort(integerList);
        System.out.println(integerList);

        int[] duplicate = {10,20,10,40,54,23,32,23,54,40};

        HashSet hashSet1 = new HashSet(Arrays.stream(duplicate).boxed().collect(Collectors.toList()));
        System.out.println(hashSet1);

    }
}