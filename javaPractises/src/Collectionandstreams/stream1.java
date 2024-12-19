package Collectionandstreams;

import java.util.*;
import java.util.stream.Collectors;

public class stream1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ram", "Prathamesh", "Jay", "Rohit");
        
        List<String> filteredNames = names.stream()
                .filter(name -> name.contains("r") || name.contains("R"))
                .collect(Collectors.toList());
        
        System.out.println(filteredNames);
    }
}

