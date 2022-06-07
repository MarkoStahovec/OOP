package project.Backend;

/**
 * This class extends its super class Vehicle and adds few attributes characteristic for cars only.
 */
public class Car extends Vehicle {
    // a few additive attributes for vehicles, that are cars
    private int noOfSeats;
    private String safetyRating;
    private String features;

    /**
     * There is only one constructor needed that possesses all attributes
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
     * @param noOfSeats    the no of seats
     * @param safetyRating the safety rating
     * @param features     the features
     */
    public Car(boolean isNew, String vehicleColor, int topSpeed, float acceleration,
               int engineSize, String gearboxType, String price, int weight, String vehicleType,
               int noOfSeats, String safetyRating, String features) {

        // using a keyword super to inherit attributes from the superclass
        super(isNew, vehicleColor, topSpeed, acceleration, engineSize, gearboxType, price, weight, vehicleType);
        this.noOfSeats = noOfSeats;
        this.safetyRating = safetyRating;
        this.features = features;
    }

    /**
     * Getter function for number of seats.
     *
     * @return Returns number of seats for a specific car.
     */
    public int getNoOfSeats() {
        return noOfSeats;
    }

    /**
     * Setter function for number of seats.
     *
     * @param noOfSeats Sets new number of seats for a specific car according to this parameter.
     */
    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    /**
     * Getter function for safety rating.
     *
     * @return Returns safety rating for a specific car.
     */
    public String getSafetyRating() {
        return safetyRating;
    }

    /**
     * Setter function for safety rating.
     *
     * @param safetyRating Sets new safety rating for a specific car according to this parameter.
     */
    public void setSafetyRating(String safetyRating) {
        this.safetyRating = safetyRating;
    }

    /**
     * Getter function for features.
     *
     * @return Returns features for a specific car.
     */
    public String getFeatures() {
        return features;
    }

    /**
     * Setter function for features.
     *
     * @param features Sets new features for a specific car according to this parameter.
     */
    public void setFeatures(String features) {
        this.features = features;
    }
}
