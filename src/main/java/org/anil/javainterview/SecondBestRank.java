package org.anil.javainterview;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondBestRank {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("anil",1000);
        map.put("ankit",1200);
        map.put("bhavna",1300);
        map.put("james",1400);
        map.put("micael",1500);
        map.put("tom",1600);
        map.put("daniel",1700);
        
        
        Map.Entry<String,Integer> finalResult = map.entrySet()
                .stream()
                .sorted(Comparator.comparing(entry -> entry.getValue()))
                .toList()
                .get(1);

        System.out.println("finalResult = " + finalResult);

        Map<String,Integer> map2 = new HashMap<>();
        map2.put("anil",1000);
        map2.put("ankit",1200);
        map2.put("bhavna",1200);
        map2.put("james",1200);
        map2.put("micael",1000);
        map2.put("tom",1300);
        map2.put("daniel",1300);



        Map.Entry<Integer,List<String>> finalResult2 = map2.entrySet()
                .stream()
                .collect(Collectors.groupingBy(entry ->entry.getValue(),
                                Collectors.mapping(entry -> entry.getKey(),Collectors.toList())
                                ))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(it -> it.getKey()))
                .toList()
                .get(1);

        System.out.println("finalResult2 = " + finalResult2);

        
    }
}
