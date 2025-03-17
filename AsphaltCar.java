package main;

/**
 * AsphaltCar represents a rally car designed for asphalt surfaces.
 * It extends RallyCar and includes an additional attribute for downforce.
 */
class AsphaltCar extends RallyCar {
    private double downforce;

    /**
     * Constructor for AsphaltCar.
     * @param make The car manufacturer.
     * @param model The car model.
     * @param horsepower The car's horsepower.
     * @param downforce The aerodynamic downforce affecting handling on asphalt.
     */
    public AsphaltCar(String make, String model, int horsepower, double downforce) {
        super(make, model, horsepower);
        this.downforce = downforce;
    }

    /**
     * Gets the downforce value.
     * @return The downforce value.
     */
    public double getDownforce() {
        return downforce;
    }

    /**
     * Calculates the car's performance rating on asphalt.
     * @return The calculated performance rating.
     */
    @Override
    public double calculatePerformance() {
        return horsepower * 0.9 + downforce * 5;
    }
}
