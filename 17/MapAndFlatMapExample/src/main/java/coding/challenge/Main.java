package coding.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("1", "2", "3");

        List<Integer> intList = strList.stream()
          .map(Integer::parseInt)
          .collect(Collectors.toList());

        System.out.println("Integer list: " + intList);

        List<List<Object>> objList = Arrays.asList(
          Arrays.asList("This", "is", "a", "flapMap", "example"));

        List<Object> flatList = objList.stream()
          .flatMap(List::stream)
          .collect(Collectors.toList());

        System.out.println("Flat list: " + flatList);
    }
}