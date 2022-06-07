package project.Backend;

/**
 * This class extends its super class Vehicle.
 */
public class Motorcycle extends Vehicle {

    /**
     * Instantiates a new Motorcycle.
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
// there is only one constructor needed that possesses all attributes
    public Motorcycle(boolean isNew, String vehicleColor, int topSpeed, float acceleration,
               int engineSize, String gearboxType, String price, int weight, String vehicleType) {

        // using a keyword super to inherit attributes from the superclass
        super(isNew, vehicleColor, topSpeed, acceleration, engineSize, gearboxType, price, weight, vehicleType);
    }
}
