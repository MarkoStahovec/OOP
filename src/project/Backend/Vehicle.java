package project.Backend;

import javax.swing.*;

/**
 * The type Vehicle.
 */
abstract public class Vehicle {
    // attributes that all vehicles have altogether
    private boolean isNew;
    private String vehicleColor;
    private int topSpeed;
    private float acceleration;
    private int engineSize;
    private String gearboxType;
    private String price;
    private int weight;
    private String vehicleType;

    /**
     * Instantiates a new Vehicle.
     *
     * @param isNew        the is new
     * @param vehicleColor the vehicle color
     * @param topSpeed     the top speed
     * @param acceleration the acceleration
     * @param engineSize   the engine size
     * @param gearboxType  the gearbox type
     * @param price        the price
     * @param weight       the weight
     * @param vehicleType  the vehicle type
     */
// default constructor with all the attributes
    Vehicle(boolean isNew, String vehicleColor, int topSpeed, float acceleration,
            int engineSize, String gearboxType, String price, int weight, String vehicleType) {
        this.isNew = isNew;
        this.vehicleColor = vehicleColor;
        this.topSpeed = topSpeed;
        this.acceleration = acceleration;
        this.engineSize = engineSize;
        this.gearboxType = gearboxType;
        this.price = price;
        this.weight = weight;
        this.vehicleType = vehicleType;
    }

    /* getters and setters for all new attributes
    * they're used when we need to change or retrieve an attribute from a particular object
    */

    /**
     * Getter function whether the car is new.
     *
     * @return Returns state of specific vehicle, whether it is used or brand new.
     */
    public boolean getIsNew() {
        return isNew;
    }

    /**
     * Setter function for state.
     *
     * @param isnew Sets new state for a specific vehicle according to this parameter.
     */
    public void setIsNew(boolean isnew) {
        this.isNew = isnew;
    }

    /**
     * Getter function for vehicle color.
     *
     * @return Returns color for a specific vehicle.
     */
    public String getVehicleColor() {
        return vehicleColor;
    }

    /**
     * Setter function for vehicle color.
     *
     * @param vehiclecolor Sets new vehicle color according to this parameter.
     */
    public void setVehicleColor(String vehiclecolor) {
        this.vehicleColor = vehiclecolor;
    }

    /**
     * Getter function for top speed.
     *
     * @return Returns top speed of a specific vehicle.
     */
    public int getTopSpeed() {
        return topSpeed;
    }

    /**
     * Setter function for top speed.
     *
     * @param topspeed Sets new top speed for a specific vehicle according to this parameter.
     */
    public void setTopSpeed(int topspeed) {
        this.topSpeed = topspeed;
    }

    /**
     * Getter function for acceleration.
     *
     * @return Returns acceleration of a specific vehicle.
     */
    public float getAcceleration() {
        return acceleration;
    }

    /**
     * Setter function for acceleration.
     *
     * @param acceleration Sets new acceleration for a specific vehicle according to this parameter.
     */
    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    /**
     * Getter function for acceleration.
     *
     * @return Returns acceleration of a specific vehicle.
     */
    public int getEngineSize() {
        return engineSize;
    }

    /**
     * Setter function for engine size.
     *
     * @param engineSize Sets new engine size for a specific vehicle according to this parameter.
     */
    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    /**
     * Getter function for gearbox type.
     *
     * @return Returns gearbox type of a specific vehicle.
     */
    public String getGearboxType() {
        return gearboxType;
    }

    /**
     * Setter function for gearbox type.
     *
     * @param gearboxType Sets new gearbox type for a specific vehicle according to this parameter.
     */
    public void setGearboxType(String gearboxType) {
        this.gearboxType = gearboxType;
    }

    /**
     * Getter function for price of a vehicle.
     *
     * @return Returns the price of a specific vehicle.
     */
    public String getPrice() {
        return price;
    }

    /**
     * Setter function for price of a vehicle.
     *
     * @param price Sets new price for a specific vehicle according to this parameter.
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Getter function for weight.
     *
     * @return Returns weight of a specific vehicle.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Setter function for weight.
     *
     * @param weight Sets new weight for a specific vehicle according to this parameter.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Getter function for the vehicle type.
     *
     * @return Returns the vehicle type of a specific vehicle.
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * Setter function for the vehicle type.
     *
     * @param carType Sets new vehicle type for a specific vehicle according to this parameter.
     */
    public void setVehicleType(String carType) {
        this.vehicleType = carType;
    }
}
