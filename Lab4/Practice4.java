package practice.lab4;

import java.io.IOException;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;


public class Practice4 {
    public static class City
    {
        private String name;
        private String state;
        private int population;

        public City(String name, String state, int population)
        {
            this.name = name;
            this.state = state;
            this.population = population;
        }

        public String getName()
        {
            return name;
        }

        public String getState()
        {
            return state;
        }

        public int getPopulation()
        {
            return population;
        }

    }

    public static Stream<City> readCities(String filename) throws IOException
    {
        return Files.lines(Paths.get(filename))
                .map(l -> l.split(", "))
                .map(a -> new City(a[0], a[1], Integer.parseInt(a[2])));
    }

    public static void main(String[] args) throws IOException, URISyntaxException {

        Stream<City> cities = readCities("cities.txt");
        // Q1: count how many cities there are for each state
        // TODO: Map<String, Long> cityCountPerState = ...
        Map <String, Long> cityCountPerState = cities.collect(Collectors.groupingBy(City::getState, Collectors.counting()));
        System.out.println(cityCountPerState);
        
        cities = readCities("cities.txt");
        // Q2: count the total population for each state
        // TODO: Map<String, Integer> statePopulation = ...
        Map<String, Integer> statePopulation = cities.collect(Collectors.groupingBy
                (City::getState, Collectors.summingInt(City::getPopulation))
        );
        System.out.println(statePopulation);

        cities = readCities("cities.txt");
        // Q3: for each state, get the set of cities with >500,000 population
        // TODO: Map<String, Set<City>> largeCitiesByState = ...
        Map<String, Set<City>> largeCitiesByState = cities.collect(Collectors.groupingBy
                (City::getState, Collectors.filtering(x -> x.getPopulation() > 500000, Collectors.toSet()))
        );
        System.out.println(largeCitiesByState);
    
        
        
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

// 如果不是null,调用Consumer
        optional1.ifPresent(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println("value is " + t);
            }
        });
        optional1.ifPresent(x -> System.out.println("value is " + x));

// null,不调用Consumer
        optional2.ifPresent(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println("value is " + t);
            }
        });
    }
}
