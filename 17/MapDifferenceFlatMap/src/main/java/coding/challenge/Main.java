package coding.challenge;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<List<String>> melonLists = Arrays.asList(
          Arrays.asList("Gac", "Cantaloupe"),
          Arrays.asList("Hemi", "Gac", "Apollo"),
          Arrays.asList("Gac", "Hemi", "Cantaloupe"));

        /*
        List<String> distinctNames1 = melonLists.stream()
          .map(Collection::stream)  // Stream<Stream<String>> 반환
          .collect(Collectors.toList());

        System.out.println("Distinct names 1: " + distinctNames1); */

        List<String> distinctNames2 = melonLists.stream()
          .flatMap(Collection::stream)  // Stream<String> 반환
          .distinct()
          .collect(Collectors.toList());

        System.out.println("Distinct names 2: " + distinctNames2);
    }
}