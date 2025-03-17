package main;

/**
 * The Driver class represents a rally driver competing in the championship.
 */
class Driver {
    private String name;
    private String country;
    private int points;
    private RallyCar car;

    /**
     * Constructor for Driver.
     * @param name The driver's name.
     * @param country The driver's country.
     * @param car The car assigned to the driver.
     */
    public Driver(String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.car = car;
        this.points = 0;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public int getPoints() { return points; }
    public void setPoints(Integer points) { this.points = points; }

    public RallyCar getCar() { return car; }
    public void setCar(RallyCar car) { this.car = car; }

    /**
     * Adds points to the driver's total score.
     * @param points The points to be added.
     */
    public void addPoints(int points) {
        this.points += points;
    }
}
