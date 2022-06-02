package coding.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> intFilterLists = Arrays.asList(1, 2, -4, 0, 2, 0, -1, 14, 0, -1);

        List<Integer> filter = intFilterLists.stream()
          .filter(i -> i != 0)
          .collect(Collectors.toList());

        System.out.println("Interger filter list: " + filter);
    }
}