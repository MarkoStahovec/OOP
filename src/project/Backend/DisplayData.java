package project.Backend;

import project.Exceptions.MissingDataException;

import javax.swing.*;
import java.io.IOException;

/**
 * This interface holds declarations for all the methods that are used in order to display backend data for vehicles.
 */
public interface DisplayData {
    /**
     * All the following methods display data appropriate for the user-selected car.
     *
     * @param carType the car type
     * @throws IOException          the io exception
     * @throws MissingDataException the missing data exception
     */
    void displayCarData(String carType) throws IOException, MissingDataException;


    /**
     * Method that displays an error message, when there is incorrect name for a car in the databse.
     */
    default void displayMissingData() {
        JOptionPane.showMessageDialog(null, "No such vehicle in our database" ,"Error", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This interface is a single-method interface, whomst method builds a requested car and adds it into the carlist or motolist accordingly.
     */
    interface Buildable {
        /**
         * Build requested.
         *
         * @param brand    the brand
         * @param color    the color
         * @param engine   the engine
         * @param gearbox  the gearbox
         * @param features the features
         */
        void buildRequested(String brand, String color, String engine, String gearbox, String features);
    }

}
