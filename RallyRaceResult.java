package main;

import java.util.*;

class RallyRaceResult implements RaceResult {
    private String raceName;
    private String location;
    private Map<Driver, Integer> results;

    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
        this.results = new HashMap<>();
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName){
        this.raceName = raceName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        results.put(driver, points);
        driver.addPoints(points);
    }

    @Override
    public int getDriverPoints(Driver driver) {
        return results.getOrDefault(driver, 0);
    }

    @Override
    public List<Driver> getResults() {
        List<Driver> sortedDrivers = new ArrayList<>(results.keySet());
        sortedDrivers.sort((d1, d2) -> results.get(d2) - results.get(d1));
        return sortedDrivers;
    }
}