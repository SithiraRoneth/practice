import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String[] ar = {"s", "d", "f", "g", "s", "d"};

        HashSet hashSet = new HashSet(Arrays.stream(ar).collect(Collectors.toList()));
        System.out.println(hashSet);

        int[] x = {1, 2, 3, 4,};
        int[] y = {10, 20, 30, 40};

        int[] xy = mergeArray(x, y);
        System.out.println(Arrays.toString(xy));

        int[] s = {10, 20, 30, 40};
        int[] ints = reverseArray(y);

        System.out.println(Arrays.toString(ints));

        int[] sort = {100, 20, 120, 30, 23};
        int[] sortA = sortArray(sort);
        System.out.println("Array sort");
        System.out.println(Arrays.toString(sortA));

        int[] delete = {200,10,12,30,50};

    }

    private static int[] sortArray(int[] sort) {
        // Bubble sort
        for (int i = 0; i < sort.length - 1; i++) {
            for (int j = 0; j < sort.length - i - 1; j++) {
                if (sort[j] > sort[j + 1]) {
                    int temp = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = temp;
                }
            }
        }
        return sort;
    }

    private static int[] reverseArray(int[] s) {
       /* int[] temp = new int[s.length];
        for (int i = 0; i < s.length / 2; i++) {
            temp[i] = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp[i];
        }
        return s; */

        //Using List

        List<Integer>list = Arrays.stream(s).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::intValue).toArray();

    }

    private static int[] mergeArray(int[] x, int[] y) {
        int[] temp = new int[x.length + y.length];
        for (int i = 0; i < x.length; i++) {
            temp[i] = x[i];
        }
        for (int i = 0; i < y.length; i++) {
            temp[x.length + i] = y[i];
        }
        return temp;
    }
}