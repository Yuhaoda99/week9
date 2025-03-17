package main;

import java.util.List;

interface RaceResult {
    void recordResult(Driver driver, int position, int points);
    int getDriverPoints(Driver driver);
    List<Driver> getResults();
}