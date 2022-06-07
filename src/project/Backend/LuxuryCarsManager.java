package project.Backend;

import project.Exceptions.MissingDataException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


/**
 * This class is the main backend class that holds all the data and methods that display different scenarios.
 */
public class LuxuryCarsManager implements DisplayData, DisplayData.Buildable {

    String logoPath;
    InputStream imgStream;
    BufferedImage img;
    ImageIcon carLogo;

    Car reqCar;
    Motorcycle reqMoto;

    public DataAccessObject carData = new DataAccessObject();


    /**
     This method builds a specific requested car with tailored attributes.
     */
    @Override
    public void buildRequested(String brand, String color, String engine, String gearbox, String features) {

        switch (brand) {
            case "Porsche 991 GT3 RS *":
                reqCar = new Car(true, color, 312, 3.2f, 3996,
                        gearbox, "105 000€", 1430, brand, 2, "B+", features);
                break;
            case "Aston Martin Vantage *":
                reqCar = new Car(true, color, 314, 3.6f, 4058,
                        gearbox, "775 000€", 1530, brand, 2, "B+", features);
                break;
            case "Audi R8 2020 5.2 *":
                reqCar = new Car(true, color, 317, 3.1f, 5204,
                        gearbox, "170 000€", 1545, brand, 2, "B+", features);
                break;
            case "Ferrari 488 *":
                reqCar = new Car(true, color, 330, 3.0f, 3918,
                        gearbox, "145 000€", 1470, brand, 2, "A-", features);
                break;
            case "Lamborghini Huracan *":
                reqCar = new Car(true, color, 341, 2.5f, 5204,
                        gearbox, "270 000€", 1422, brand, 2, "B+", features);
                break;
            case "Mercedes AMG GT *":
                reqCar = new Car(true, color, 303, 3.77f, 4008,
                        gearbox, "140 000€", 1464, brand, 2, "B+", features);
                break;
            case "Ducati Diavel *":
                reqMoto = new Motorcycle(true, color, 288, 1.9f, 1198,
                        gearbox, "30 000€", 238, brand);
                carData.motoList.add(reqMoto);
                return;
            default:
                return;
        }

        carData.carList.add(reqCar);
    }



    /**
    All the following methods display data appropriate for the user-selected car.
     */
    public void displayCarData(String carType) throws IOException, MissingDataException {
        switch (carType) {
            case "Alpine A110":
                logoPath = "\\Img\\alpineLogo.png";
                imgStream = getClass().getResourceAsStream(logoPath);
                img = ImageIO.read(imgStream);
                carLogo = new ImageIcon(new ImageIcon(img).getImage().
                        getScaledInstance(184, 148, Image.SCALE_DEFAULT));
                break;
            case "Aston Martin Vantage":
            case "Aston Martin Vantage *":
                logoPath = "\\Img\\astonLogo.png";
                imgStream = getClass().getResourceAsStream(logoPath);
                img = ImageIO.read(imgStream);
                carLogo = new ImageIcon(new ImageIcon(img).getImage().
                        getScaledInstance(200, 118, Image.SCALE_DEFAULT));
                break;
            case "Audi R8 2020 5.2":
            case "Audi R8 2020 5.2 *":
                logoPath = "\\Img\\audiLogo.png";
                imgStream = getClass().getResourceAsStream(logoPath);
                img = ImageIO.read(imgStream);
                carLogo = new ImageIcon(new ImageIcon(img).getImage().
                        getScaledInstance(168, 168, Image.SCALE_DEFAULT));
                break;
            case "Bentley Continental GT":
                logoPath = "\\Img\\bentleyLogo.png";
                imgStream = getClass().getResourceAsStream(logoPath);
                img = ImageIO.read(imgStream);
                carLogo = new ImageIcon(new ImageIcon(img).getImage().
                        getScaledInstance(200, 118, Image.SCALE_DEFAULT));
                break;
            case "Ferrari 488":
            case "Ferrari 488 *":
                logoPath = "\\Img\\ferrariLogo.png";
                imgStream = getClass().getResourceAsStream(logoPath);
                img = ImageIO.read(imgStream);
                carLogo = new ImageIcon(new ImageIcon(img).getImage().
                        getScaledInstance(200, 118, Image.SCALE_DEFAULT));
                break;
            case "Lamborghini Huracan":
            case "Lamborghini Huracan *":
                logoPath = "\\Img\\lamborghiniLogo.png";
                imgStream = getClass().getResourceAsStream(logoPath);
                img = ImageIO.read(imgStream);
                carLogo = new ImageIcon(new ImageIcon(img).getImage().
                        getScaledInstance(168, 184, Image.SCALE_DEFAULT));
                break;
            case "McLaren 650S":
                logoPath = "\\Img\\mcLarenLogo.png";
                imgStream = getClass().getResourceAsStream(logoPath);
                img = ImageIO.read(imgStream);
                carLogo = new ImageIcon(new ImageIcon(img).getImage().
                        getScaledInstance(168, 180, Image.SCALE_DEFAULT));
                break;
            case "Mercedes AMG GT":
            case "Mercedes AMG GT *":
                logoPath = "\\Img\\mercedesLogo.png";
                imgStream = getClass().getResourceAsStream(logoPath);
                img = ImageIO.read(imgStream);
                carLogo = new ImageIcon(new ImageIcon(img).getImage().
                        getScaledInstance(168, 168, Image.SCALE_DEFAULT));
                break;
            case "Porsche 991 GT3 RS":
            case "Porsche 991 GT3 RS *":
                logoPath = "\\Img\\porscheLogo.png";
                imgStream = getClass().getResourceAsStream(logoPath);
                img = ImageIO.read(imgStream);
                carLogo = new ImageIcon(new ImageIcon(img).getImage().
                        getScaledInstance(200, 118, Image.SCALE_DEFAULT));
                break;
            case "Ducati Diavel":
            case "Ducati Diavel *":
                logoPath = "\\Img\\ducatiLogo.png";
                imgStream = getClass().getResourceAsStream(logoPath);
                img = ImageIO.read(imgStream);
                carLogo = new ImageIcon(new ImageIcon(img).getImage().
                        getScaledInstance(168, 168, Image.SCALE_DEFAULT));
                break;
            default:
                throw new MissingDataException("No such car in our database");
        }
            try {
                Car car = carData.findCarIndex(carType);
                JOptionPane.showMessageDialog(null, "\n\n\n" +
                        "Car type:                     " + car.getVehicleType() + "\n" +
                        "Brand new:                " + car.getIsNew() + "\n" +
                        "Vehicle color:            " + car.getVehicleColor() + "\n" +
                        "Top speed:                 " + car.getTopSpeed() + " km/h\n" +
                        "Acceleration:             " + car.getAcceleration() + " s\n" +
                        "Engine size:               " + car.getEngineSize() + " cm3\n" +
                        "Gearbox type:            " + car.getGearboxType() + "\n" +
                        "Weight:                       " + car.getWeight() + " kg\n" +
                        "No. seats:                   " + car.getNoOfSeats() + "\n" +
                        "Safety rating:             " + car.getSafetyRating() + "\n" +
                        "Features:                    " + car.getFeatures() + "\n" +
                        "\nPrice:                           " + car.getPrice() + "\n", car.getVehicleType(), JOptionPane.INFORMATION_MESSAGE, carLogo);


            }
            catch (NullPointerException ignored) {};
            try {
                Motorcycle moto = carData.findMotoIndex(carType);
                JOptionPane.showMessageDialog(null, "\n\n\n" +
                        "Car type:                     " + moto.getVehicleType() + "\n" +
                        "Brand new:                " + moto.getIsNew() + "\n" +
                        "Vehicle color:            " + moto.getVehicleColor() + "\n" +
                        "Top speed:                 " + moto.getTopSpeed() + " km/h\n" +
                        "Acceleration:             " + moto.getAcceleration() + " s\n" +
                        "Engine size:               " + moto.getEngineSize() + " cm3\n" +
                        "Gearbox type:            " + moto.getGearboxType() + "\n" +
                        "Weight:                       " + moto.getWeight() + " kg\n" +
                        "\nPrice:                           " + moto.getPrice() + "\n", moto.getVehicleType(), JOptionPane.INFORMATION_MESSAGE, carLogo);
            } catch (NullPointerException ignored) {};

    }

}
