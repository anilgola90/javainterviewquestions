package org.anil.javainterview;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StateWithHighestPopulation {
    public static void main(String[] args) {

        Country country1 = new Country();
        country1.countryName = "India";
        State state1 = new State();
        state1.stateName = "Haryana";
        state1.population = 1500;

        State state2 = new State();
        state2.stateName = "Rajashtan";
        state2.population = 900;

        State state3 = new State();
        state3.stateName = "Gujarat";
        state3.population = 900;
        country1.states = List.of(state1,state2,state3);

        Country country2 = new Country();
        country2.countryName = "America";
        State state4 = new State();
        state4.stateName = "Texas";
        state4.population = 1300;

        State state5 = new State();
        state5.stateName = "California";
        state5.population = 1400;

        State state6 = new State();
        state6.stateName = "Florida";
        state6.population = 1500;
        country2.states = List.of(state4,state5,state6);



       var countryList =  List.of(country1,country2);

        record Triple(String country,String state, int population){
            public String toString(){
                return this.country + ":" + this.state;
            }
        }


       var finalResult =  countryList.stream()
                .flatMap(ctry -> ctry.states.stream()
                        .map(st -> new Triple(ctry.countryName,st.stateName,st.population))
                )
               .collect(Collectors.groupingBy(st -> st.population,
                       Collectors.mapping(st->new Triple(st.country,st.state,st.population),
                               Collectors.toList())))
               .entrySet()
               .stream().sorted(Comparator.comparing(entry -> -entry.getKey()))
               .toList()
             ;

        System.out.println(finalResult);

    }

    static class Country{
        String countryName;
        List<State> states;
    }
    static class State{
        String stateName;
        int population;
    }
}
