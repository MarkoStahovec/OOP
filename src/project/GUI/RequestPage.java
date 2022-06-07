package project.GUI;

import javax.swing.*;
import java.awt.*;

/**
 *  This class represents request page, when users pushes the request button, which prompts the user with
 *  multiple comboxes
 */
public class RequestPage {
    JDialog reqFrame; // the frame itself
    JComboBox<String> brand; // few comboxes that specify the car
    JComboBox<String> color;
    JComboBox<String> gearbox;
    JComboBox<String> engineSize;
    JComboBox<String> features;

    JLabel brandLabel; // Labels are used as description tags for comboboxes
    JLabel colorLabel;
    JLabel gearboxLabel;
    JLabel engineLabel;
    JLabel featuresLabel;
    JLabel submission;

    JPanel logoPanel; // Panels hold together multiple components
    JPanel brandPanel;
    JPanel colorPanel;
    JPanel gearboxPanel;
    JPanel enginePanel;
    JPanel featuresPanel;

    JLabel picLabel; // Label for dynamic picture on top of the frame


    RequestPage() { // constructor for request frame

        reqFrame = new JDialog();

        brandLabel = new JLabel("Brand: ");
        colorLabel = new JLabel("Color: ");
        gearboxLabel = new JLabel("Gearbox: ");
        engineLabel = new JLabel("Engine: ");
        featuresLabel = new JLabel("Features: ");
        submission = new JLabel("Submission button is in the main window");
        submission.setFont(new Font("Dialog", Font.BOLD, 12));


        logoPanel = new JPanel();


        brandPanel = new JPanel();
        colorPanel = new JPanel();
        gearboxPanel = new JPanel();
        enginePanel = new JPanel();
        featuresPanel = new JPanel();

        /*
            Following arrays hold all the available choices for the user
         */
        String[] brands = {"Aston Martin Vantage", "Audi R8 2020 5.2", "Ducati Diavel",
                "Ferrari 488", "Lamborghini Huracan", "Mercedes AMG GT", "Porsche 991 GT3 RS"};

        String[] colors = {"Deep Black", "Metallic Silver", "Bright White", "Maranello Red",
                "Light Gold", "Light Turquiouse", "Dark Orchid", "Royal Blue", "Crimson Red"};

        String[] gearboxTypes = {"6-speed automatic", "7-speed dual-clutch", "7-speed automatic"};

        String[] engineSizes = {"Conservative", "Standard", "Maximum"};

        String[] featuresTypes = {"S+", "S", "S-", "A+", "A", "A-", "B+", "B", "B-"};

        picLabel = new JLabel(new ImageIcon(new ImageIcon(".\\src\\project\\GUI\\GUIIcons\\astonLogo.png").
                getImage().getScaledInstance(200, 118, Image.SCALE_DEFAULT))); // default image

        logoPanel.add(picLabel);


        brand = new JComboBox<>(brands);
        color = new JComboBox<>(colors);
        gearbox = new JComboBox<>(gearboxTypes);
        engineSize = new JComboBox<>(engineSizes);
        features = new JComboBox<>(featuresTypes);

        // adding components to theirs respective panels
        brandPanel.add(brandLabel);
        brandPanel.add(brand);

        colorPanel.add(colorLabel);
        colorPanel.add(color);

        gearboxPanel.add(gearboxLabel);
        gearboxPanel.add(gearbox);

        enginePanel.add(engineLabel);
        enginePanel.add(engineSize);

        featuresPanel.add(featuresLabel);
        featuresPanel.add(features);

        // item listener for brand combobox to ensure dynamic branding logos on top of the frame
        brand.addItemListener(e -> {
            if (brand.getSelectedItem() == "Aston Martin Vantage") {
                logoPanel.remove(picLabel); // remove old one
                picLabel = new JLabel(new ImageIcon(new ImageIcon(".\\src\\project\\GUI\\GUIIcons\\astonLogo.png").
                        getImage().getScaledInstance(200, 118, Image.SCALE_DEFAULT)));
                logoPanel.add(picLabel);
                reqFrame.repaint(); // repaint the frame
                reqFrame.revalidate();
            }

            if (brand.getSelectedItem() == "Audi R8 2020 5.2") {
                logoPanel.remove(picLabel); // remove old one
                picLabel = new JLabel(new ImageIcon(new ImageIcon(".\\src\\project\\GUI\\GUIIcons\\audiLogo.png").
                        getImage().getScaledInstance(118, 118, Image.SCALE_DEFAULT)));
                logoPanel.add(picLabel);
                reqFrame.repaint(); // repaint the frame
                reqFrame.revalidate();
            }

            if (brand.getSelectedItem() == "Bentley Continental GT") {
                logoPanel.remove(picLabel); // remove old one
                picLabel = new JLabel(new ImageIcon(new ImageIcon(".\\src\\project\\GUI\\GUIIcons\\bentleyLogo.png").
                        getImage().getScaledInstance(200, 118, Image.SCALE_DEFAULT)));
                logoPanel.add(picLabel);
                reqFrame.repaint(); // repaint the frame
                reqFrame.revalidate();
            }

            if (brand.getSelectedItem() == "Ferrari 488") {
                logoPanel.remove(picLabel); // remove old one
                picLabel = new JLabel(new ImageIcon(new ImageIcon(".\\src\\project\\GUI\\GUIIcons\\ferrariLogo.png").
                        getImage().getScaledInstance(200, 118, Image.SCALE_DEFAULT)));
                logoPanel.add(picLabel);
                reqFrame.repaint(); // repaint the frame
                reqFrame.revalidate();
            }

            if (brand.getSelectedItem() == "Lamborghini Huracan") {
                logoPanel.remove(picLabel); // remove old one
                picLabel = new JLabel(new ImageIcon(new ImageIcon(".\\src\\project\\GUI\\GUIIcons\\lamborghiniLogo.png").
                        getImage().getScaledInstance(110, 118, Image.SCALE_DEFAULT)));
                logoPanel.add(picLabel);
                reqFrame.repaint(); // repaint the frame
                reqFrame.revalidate();
            }

            if (brand.getSelectedItem() == "Mercedes AMG GT") {
                logoPanel.remove(picLabel); // remove old one
                picLabel = new JLabel(new ImageIcon(new ImageIcon(".\\src\\project\\GUI\\GUIIcons\\mercedesLogo.png").
                        getImage().getScaledInstance(118, 118, Image.SCALE_DEFAULT)));
                logoPanel.add(picLabel);
                reqFrame.repaint(); // repaint the frame
                reqFrame.revalidate();
            }

            if (brand.getSelectedItem() == "Porsche 991 GT3 RS") {
                logoPanel.remove(picLabel); // remove old one
                picLabel = new JLabel(new ImageIcon(new ImageIcon(".\\src\\project\\GUI\\GUIIcons\\porscheLogo.png").
                        getImage().getScaledInstance(200, 118, Image.SCALE_DEFAULT)));
                logoPanel.add(picLabel);
                reqFrame.repaint(); // repaint the frame
                reqFrame.revalidate();
            }

            if (brand.getSelectedItem() == "Ducati Diavel") {
                logoPanel.remove(picLabel); // remove old one
                picLabel = new JLabel(new ImageIcon(new ImageIcon(".\\src\\project\\GUI\\GUIIcons\\ducatiLogo.png").
                        getImage().getScaledInstance(118, 118, Image.SCALE_DEFAULT)));
                logoPanel.add(picLabel);
                reqFrame.repaint(); // repaint the frame
                reqFrame.revalidate();
            }
        });

        // add panels with components to the request frame
        reqFrame.add(logoPanel);
        reqFrame.add(brandPanel);
        reqFrame.add(colorPanel);
        reqFrame.add(gearboxPanel);
        reqFrame.add(enginePanel);
        reqFrame.add(featuresPanel);
        reqFrame.add(submission);

        ImageIcon image = new ImageIcon(".\\src\\project\\Img\\car.png"); // set an icon for the frame

        /*
            Set basic properties for the request frame such as size, layout, title...
         */
        reqFrame.setIconImage(image.getImage());
        reqFrame.setResizable(false);
        reqFrame.setTitle("Request a car from manufacturer");

        reqFrame.setSize(350, 375);
        reqFrame.setLayout(new FlowLayout());
        reqFrame.setVisible(true);

    }

}
