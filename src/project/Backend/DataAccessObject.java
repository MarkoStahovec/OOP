package project.Backend;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class performs actions on backend data. This is an implementation of DataAccessObject design pattern.
 */
public class DataAccessObject implements DataAccessObjectInterface {
    /**
     * The Car list.
     */
    public ArrayList<Car> carList;
    /**
     * The Moto list.
     */
    public ArrayList<Motorcycle> motoList;

    /**
     * The Path.
     */
    String path = ".\\src\\project\\database.csv";
    /**
     * The Line.
     */
    String line;
    /**
     * The Values.
     */
    String[] values;

    /**
     * Instantiates a new Data access object.
     */
    public DataAccessObject() {
        createData();
    }

    /**
     * This method initializes all the data and stores it into the arraylist called carList.
     */
    public void createData() {
        carList = new ArrayList<>(); // carlist holds the main data, which is reloaded every time this program opens
        motoList = new ArrayList<>(); // also initalizes motorcycle list for future uses

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                values = line.split(",");

                // this line creates an instance of a car with its parameters from database
                Car car = new Car(Boolean.parseBoolean(values[0].trim()),
                        values[1].trim(),
                        Integer.parseInt(values[2].trim()),
                        Float.parseFloat(values[3].trim()),
                        Integer.parseInt(values[4].trim()),
                        values[5].trim(),
                        values[6].trim(),
                        Integer.parseInt(values[7].trim()),
                        values[8].trim(),
                        Integer.parseInt(values[9].trim()),
                        values[10].trim(),
                        values[11].trim());
                carList.add(car);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This function deletes a specific car.
     * @param deletion  Car to be deleted.
     */
    @Override
    public void deleteCar(Car deletion) {
        carList.removeIf(car -> (car.getVehicleType()).equals(deletion.getVehicleType()));
    }

    /**
     * This function deletes a specific motorcycle.
     * @param deletion  Motorcycle to be deleted.
     */
    @Override
    public void deleteMoto(Motorcycle deletion) {
        carList.removeIf(moto -> (moto.getVehicleType()).equals(deletion.getVehicleType()));
    }

    /**
     * This function cycles through car list to find a specific car.
     * @param carType Name of a car.
     * @return        Returns a specific Car object.
     */
    @Override
    public Car findCarIndex(String carType) {
        for (Car car : carList) {
            if (carType.equals(car.getVehicleType())) {
                return car;
            }
        }

        return null;
    }

    /**
     * This function cycles through motoList to find a specific motorcycle.
     * @param motoType Name of a motorcycle.
     * @return        Returns a specific Motorcycle object.
     */
    @Override
    public Motorcycle findMotoIndex(String motoType) {
        for (Motorcycle moto : motoList) {
            if (motoType.equals(moto.getVehicleType())) {
                return moto;
            }
        }

        return null;
    }
}
