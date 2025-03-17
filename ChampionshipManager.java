package main;

import java.util.*;

/**
 * ChampionshipManager is responsible for managing the rally championship,
 * including driver registration and race results.
 * Implemented as a Singleton to ensure only one instance exists.
 */
class ChampionshipManager {
    private static ChampionshipManager instance;
    
    private List<Driver> drivers;
    private List<RallyRaceResult> races;
    private static int totalDrivers = 0;
    private static int totalRaces = 0;

    /**
     * Private constructor to enforce the Singleton pattern.
     */
    private ChampionshipManager() {
        drivers = new ArrayList<>();
        races = new ArrayList<>();
    }

    /**
     * Returns the single instance of ChampionshipManager.
     * @return The ChampionshipManager instance.
     */
    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }
    
    /**
     * Registers a new driver to the championship.
     * @param driver The driver to be registered.
     */
    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++;
    }

    /**
     * Adds a race result to the championship.
     * @param result The race result object.
     */
    public void addRaceResult(RallyRaceResult result) {
        races.add(result);
        totalRaces++;
    }

    /**
     * Retrieves the championship standings, sorted by points in descending order.
     * @return A sorted list of drivers by points.
     */
    public List<Driver> getStandings() {
        drivers.sort((d1, d2) -> d2.getPoints() - d1.getPoints());
        return drivers;
    }

    /**
     * Retrieves the current leading driver in the championship.
     * @return The driver with the highest points.
     */
    public Driver getLeadingDriver() {
        return getStandings().get(0);
    }

    /**
     * Gets the total number of registered drivers.
     * @return The total number of drivers.
     */
    public static int getTotalDrivers() {
        return totalDrivers;
    }

    /**
     * Gets the total number of races held.
     * @return The total number of races.
     */
    public static int getTotalRaces() {
        return totalRaces;
    }
}