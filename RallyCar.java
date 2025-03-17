package main;

abstract class RallyCar {
    protected String make;
    protected String model;
    protected int horsepower;

    public RallyCar(String make, String model, int horsepower) {
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make){
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower){
        this.horsepower = horsepower;
    }

    public abstract double calculatePerformance();
}