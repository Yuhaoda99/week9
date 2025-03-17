package main;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ChampionshipStatistics provides utility methods for calculating
 * various championship statistics.
 */
class ChampionshipStatistics {

    /**
     * Calculates the average points per driver.
     * @param drivers The list of drivers in the championship.
     * @return The average points per driver.
     */
    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        return drivers.stream().mapToInt(Driver::getPoints).average().orElse(0);
    }

    /**
     * Determines the most successful country in the championship,
     * based on the highest total driver points.
     * @param drivers The list of drivers.
     * @return The most successful country.
     */
    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        if (drivers.isEmpty()) return "Unknown";

        return drivers.stream()
                .collect(Collectors.groupingBy(Driver::getCountry, Collectors.summingInt(Driver::getPoints)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Unknown");
    }
}
