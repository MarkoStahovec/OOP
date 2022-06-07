package project.Backend;

/**
 * This interface represents DataAccessObject design pattern to access data from different objects
 */
public interface DataAccessObjectInterface {
    /**
     * This function cycles through car list to find a specific car.
     *
     * @param carType Name of a car.
     * @return Returns a specific Car object.
     */
    public Car findCarIndex(String carType);

    /**
     * This function cycles through motoList to find a specific motorcycle.
     *
     * @param motoType Name of a motorcycle.
     * @return Returns a specific Motorcycle object.
     */
    public Motorcycle findMotoIndex(String motoType);

    /**
     * This function deletes a specific car.
     *
     * @param deletion Car to be deleted.
     */
    public void deleteCar(Car deletion);

    /**
     * This function deletes a specific motorcycle.
     *
     * @param deletion Motorcycle to be deleted.
     */
    public void deleteMoto(Motorcycle deletion);

    /**
     * This method initializes all the data and stores it into the arraylist called carlist
     */
    public void createData();

}
