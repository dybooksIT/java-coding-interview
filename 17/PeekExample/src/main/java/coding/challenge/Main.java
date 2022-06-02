package coding.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> addresses = Arrays.asList("seoul", "pusan", "gwangju", "daegu", "daejun", "suwon");

        System.out.println("After:");
        addresses.stream()
          .peek(p -> System.out.println("\tstream(): " + p))
          .filter(s -> s.startsWith("s"))
          .peek(p -> System.out.println("\tfilter(): " + p))
          .map(String::toUpperCase)
          .peek(p -> System.out.println("\tmap(): " + p))
          .sorted()
          .peek(p -> System.out.println("\tsorted(): " + p))
          .collect(Collectors.toList());
    }
}