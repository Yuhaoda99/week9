package main;

import java.util.List;

/**
 * The Main class simulates the rally championship,
 * including driver registration, race simulation, and displaying results.
 */
public class Main {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        // Creating drivers and assigning cars
        Driver driver1 = new Driver("Sébastien Ogier", "France", new GravelCar("Toyota", "Yaris", 279, 20));
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland", new AsphaltCar("Hyundai", "i20", 247, 50));
        Driver driver3 = new Driver("Ott Tänak", "Estonia", new GravelCar("Ford", "Fiesta", 279, 18));
        Driver driver4 = new Driver("Thierry Neuville", "Belgium", new AsphaltCar("Citroën", "C3", 247, 55));
        
        // Registering drivers
        manager.registerDriver(driver1);
        manager.registerDriver(driver2);
        manager.registerDriver(driver3);
        manager.registerDriver(driver4);

        // Simulating race results
        RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyväskylä");
        race1.recordResult(driver1, 1, 25);
        race1.recordResult(driver3, 2, 18);
        race1.recordResult(driver2, 3, 15);
        race1.recordResult(driver4, 4, 12);
        manager.addRaceResult(race1);

        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        race2.recordResult(driver2, 1, 25);
        race2.recordResult(driver4, 2, 18);
        race2.recordResult(driver1, 3, 15);
        race2.recordResult(driver3, 4, 12);
        manager.addRaceResult(race2);

        List<Driver> standings = manager.getStandings();
        int rank = 1;
        for (Driver driver : standings) {
            System.out.println(rank + ". " + driver.getName() + " (" + driver.getCountry() + "): " + driver.getPoints() + " points");
            rank++;
        }
        
        // Displaying championship leader
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        System.out.println(manager.getLeadingDriver().getName() + " with " + manager.getLeadingDriver().getPoints() + " points");
        System.out.println("\n===== RACE RESULTS =====");
        printRaceResults(race1);
        printRaceResults(race2);
        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + (Math.round(driver1.getCar().calculatePerformance() * 10.0) / 10.0));
        System.out.println("Asphalt Car Performance: " + (Math.round(driver2.getCar().calculatePerformance() * 10.0) / 10.0));
    }

    private static void printRaceResults(RallyRaceResult race) {
        System.out.println("Race: " + race.getRaceName() + " (" + race.getLocation() + ")");
        List<Driver> results = race.getResults();
        int position = 1;
        for (Driver driver : results) {
            System.out.println("  Position " + position + ": " + driver.getName() + " - " + race.getDriverPoints(driver) + " points");
            position++;
        }
    }
}
