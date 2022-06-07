package project.GUI;

import project.Backend.*;
import project.Exceptions.IncorrectInputException;
import project.Exceptions.MissingDataException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

import static javax.swing.GroupLayout.Alignment.CENTER;

/**
 * This interface corrects String representations of newly requested cars
 */
interface StringFix {
    /**
     * This function processes a string in particular way.
     * @param str String to be modified.
     * @return    Returns modified string.
     */
    String process(String str);
}

/**
 * This the main GUI class that initializes all the components and their functionalities.
 */
public class GUI extends JFrame implements Serializable, ListListener {
    RequestPage requestPage; // new window for car request

    String newBrand; // these String values hold information about requested cars
    String newColor;
    String newEngine;
    String newGearbox;
    String newFeatures;

    private DefaultListModel<String> modelList; // list of all cars
    private JList<String> myList;
    private JButton remAllBtn; // button declarations for multiple functionalities
    private JButton addBtn;
    private JButton renBtn;
    private JButton delBtn;
    private JButton reqBtn;
    private JButton subBtn;
    private JButton buyBtn;

    JMenuBar menuBar; // menubar for serialization, licensing etc.

    JScrollPane scrollPane; // scrollpane that displays elements available to user

    JMenu fileMenu;
    JMenu helpMenu;

    JMenuItem loadItem; // items for menu bar
    JMenuItem saveItem;
    JMenuItem exitItem;
    JMenuItem aboutItem;

    ImageIcon loadIcon; // icons for particular items
    ImageIcon saveIcon;
    ImageIcon exitIcon;
    ImageIcon aboutIcon;

    boolean adminRights;
    LuxuryCarsManager cars; // constructor for backend methods
    boolean displayed;

    String logoPath; // variables to ensure correct icon displayment
    InputStream imgStream;
    static BufferedImage mainIcon;


    /**
     * // This is the constructor for GUI class that also checks for password.
     */
    public GUI() {
        LoginPage login = new LoginPage();

        if (login.admin) {
            adminRights = true;
        }
        initUI(); // initializes all user interface elements
    }


    /**
     * This function adds listener to double clicks for the GUI list.
     */
    public void addListListener() {
        myList.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) { // run on 2-click

                    int index = myList.locationToIndex(e.getPoint()); // this function stores an index of our list
                    String item = modelList.getElementAt(index);  // here is the string representation of double-clicked element

                    displayed = false;

                    try { // try-catch clause that tries to display double-clicked element
                        for (int i = 0; i < cars.carData.carList.size(); i++) {

                            if (item.equals(cars.carData.carList.get(i).getVehicleType())) {

                                if (item.charAt(item.length()-1) == '*') {
                                    try {
                                        cars.displayCarData(cars.carData.carList.get(i).getVehicleType());
                                        displayed = true;
                                    }
                                    catch (NullPointerException exc) {
                                        modelList.remove(index);
                                        JOptionPane.showMessageDialog(null,
                                                "The vehicle was requested previously, but was not bought.\n" +
                                                        "Request a new one", "Message", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }

                                else {
                                    cars.displayCarData(cars.carData.carList.get(i).getVehicleType());
                                    displayed = true;
                                }
                            }
                        }

                        for (int i = 0; i < cars.carData.motoList.size(); i++) {
                            if (item.equals(cars.carData.motoList.get(i).getVehicleType()) && !displayed) {

                                if (item.charAt(item.length()-1) == '*') {
                                    try {
                                        cars.displayCarData(cars.carData.motoList.get(i).getVehicleType());
                                        displayed = true;
                                    }
                                    catch (NullPointerException exc) {
                                        modelList.remove(index);
                                        JOptionPane.showMessageDialog(null,
                                                "The vehicle was requested previously, but was not bought.\n" +
                                                        "Request a new one", "Message", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }

                                else {
                                    cars.displayCarData(cars.carData.motoList.get(i).getVehicleType());
                                    displayed = true;
                                }
                            }
                        }

                        if (!displayed) {
                            try {
                                throw new MissingDataException("The vehicle is not in the database"); // custom exception if no match was found
                            } catch (MissingDataException missingDataException) {
                                missingDataException.printStackTrace();
                            }

                            modelList.remove(index);
                            cars.displayMissingData();
                        }

                    } catch (IOException | MissingDataException exc) {
                        exc.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     This method creates list for GUI. It is called when program is executed, so there is some default data to work with.
     */
    private void createList() {

        cars = new LuxuryCarsManager(); // constructor for data
        cars.carData.createData();

        modelList = new DefaultListModel<>();
        for (Car car : cars.carData.carList) {
            modelList.addElement(car.getVehicleType());
        }

        //myList = new JList(carList.toArray());
        myList = new JList<>(modelList);
        myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // selection mode needed so there is some kind of responsiveness

        addListListener(); // adds listener for double-clicks
    }

    /**
     * This method sets correct icon positioning to its respective button.
     * @param icon This parameter represents icon.
     * @param btn  This parameter represents button.
     */
    private void setIconPosition(ImageIcon icon, JButton btn) {
         btn.setIcon(icon);
         btn.setHorizontalTextPosition(AbstractButton.CENTER);
         btn.setVerticalTextPosition(AbstractButton.BOTTOM);
    }

    /**
     * This method creates buttons for all sorts of operations.
     */
    private void createButtons() {

        remAllBtn = new JButton("Remove All");
        addBtn = new JButton("Add");
        renBtn = new JButton("Rename");
        delBtn = new JButton("Delete");
        reqBtn = new JButton("Request a car");
        subBtn = new JButton("Submit a request");
        buyBtn = new JButton("Buy");

        remAllBtn.setFocusable(false); // setFocusable on false makes buttons look better when pushed
        addBtn.setFocusable(false);
        renBtn.setFocusable(false);
        delBtn.setFocusable(false);
        reqBtn.setFocusable(false);
        subBtn.setFocusable(false);
        buyBtn.setFocusable(false);

        ImageIcon addBtnIcon = new ImageIcon(new ImageIcon(".\\src\\project\\Backend\\Img\\plusIcon.png")
                .getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));

        setIconPosition(addBtnIcon, addBtn);

        ImageIcon renBtnIcon = new ImageIcon(new ImageIcon(".\\src\\project\\Backend\\Img\\renameIcon.png")
                .getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));

        setIconPosition(renBtnIcon, renBtn);

        ImageIcon delBtnIcon = new ImageIcon(new ImageIcon(".\\src\\project\\Backend\\Img\\deleteIcon.png")
                .getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));

        setIconPosition(delBtnIcon, delBtn);

        ImageIcon remAllBtnIcon = new ImageIcon(new ImageIcon(".\\src\\project\\Backend\\Img\\removeAllIcon.png")
                .getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));

        setIconPosition(remAllBtnIcon, remAllBtn);

        ImageIcon reqBtnIcon = new ImageIcon(new ImageIcon(".\\src\\project\\Backend\\Img\\requestIcon.png")
                .getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));

        setIconPosition(reqBtnIcon, reqBtn);

        ImageIcon subBtnIcon = new ImageIcon(new ImageIcon(".\\src\\project\\Backend\\Img\\submitIcon.png")
                .getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));

        setIconPosition(subBtnIcon, subBtn);

        ImageIcon buyBtnIcon = new ImageIcon(new ImageIcon(".\\src\\project\\Backend\\Img\\buyIcon.png")
                .getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));

        setIconPosition(buyBtnIcon, buyBtn);


        subBtn.setEnabled(false); // submit button needs to be disabled until request button is pressed

        if (!adminRights) { // if adminrights are not present, few buttons need to be disabled
            remAllBtn.setEnabled(false);
            addBtn.setEnabled(false);
            renBtn.setEnabled(false);
            delBtn.setEnabled(false);
            reqBtn.setEnabled(true);
            buyBtn.setEnabled(true);
        }

        addBtn.addActionListener(e -> { // this button prompts admin to add an item of his liking

            String text = JOptionPane.showInputDialog("Add a new item"); // text holds the input
            String item;

            if (text != null) {
                item = text.trim();
            }
            else {
                return;
            }

            if (!item.isEmpty()) {

                modelList.addElement(item);
            }
        });

        delBtn.addActionListener(event -> { // this button prompts admin to delete an item from list of cars

            ListSelectionModel selModel = myList.getSelectionModel();

            int index = selModel.getMinSelectionIndex(); // index stores an index of the item thats being deleted

            if (index >= 0) {
                modelList.remove(index);
                //cars.carData.deleteCar(cars.carData.carList.get(index));
            }
        });

        renBtn.addActionListener(e -> { // this button enables admin to rename a specific item in the list

            ListSelectionModel selModel = myList.getSelectionModel();
            int index = selModel.getMinSelectionIndex(); // index stores an index of the item thats being renamed

            if (index == -1) { // if nothing is selected
                return;
            }

            String item = modelList.getElementAt(index);
            String text = JOptionPane.showInputDialog("Rename item", item); // textfield for new name
            String newItem;

            if (text != null) {
                newItem = text.trim(); // trim off unnecessary spacing
            }
            else {
                return;
            }

            if (!newItem.isEmpty()) {
                modelList.remove(index);
                modelList.add(index, newItem);
            }
        });

        remAllBtn.addActionListener(e -> modelList.clear()); // this button clears the whole modellist

        reqBtn.addActionListener(e -> { // request button creates new window where user can request his own car

            if (e.getSource() == reqBtn) {

                requestPage = new RequestPage();
                subBtn.setEnabled(true); // enable submit button for submission
                reqBtn.setEnabled(false); // disable request button in order to prevent incongrous behavior


            }
        });

        subBtn.addActionListener(e -> { // submit button retrieves data from request window and adds the item into the list after an interval using a different thread

            if (e.getSource() == subBtn) {

                newBrand = (String) requestPage.brand.getSelectedItem(); // retrieves data
                newColor = (String) requestPage.color.getSelectedItem();
                newEngine = (String) requestPage.engineSize.getSelectedItem();
                newGearbox = (String) requestPage.gearbox.getSelectedItem();
                newFeatures = (String) requestPage.features.getSelectedItem();


                JOptionPane.showMessageDialog(null,
                        "Your vehicle will be ready shortly", "Message", JOptionPane.INFORMATION_MESSAGE); // information message that request was done correctly

                new Thread(() -> { // lambda expression to create a new thread

                    try {
                        Thread.sleep(5000); // delay in order to make request modeling look more believable
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }

                    StringFix stringBrand = (str) -> str + " *"; // usage of lambda expression so the requested car is marked within the list
                    stringBrand.process(newBrand);

                    cars.buildRequested(stringBrand.process(newBrand), newColor, newEngine, newGearbox, newFeatures); // build the specific car

                    modelList.removeElement(stringBrand.process(newBrand));
                    modelList.addElement(stringBrand.process(newBrand));
                    reqBtn.setEnabled(true);
                }).start();


                subBtn.setEnabled(false); // switch back the submit and request button
                requestPage.reqFrame.dispose(); // close the request window

            }
        });

        buyBtn.addActionListener(e -> { // this button lets user to buy the car he wants
            String text = JOptionPane.showInputDialog("IBAN (16-digit number): "); // window to prompt 16-digit number

            ListSelectionModel selModel = myList.getSelectionModel();

            int index = selModel.getMinSelectionIndex(); // buy selected car

            if (text == null) {
                try {
                    throw new IncorrectInputException("Wrong IBAN!");
                } catch (IncorrectInputException exc) {
                    exc.printStackTrace();
                }
            }

            else {
                if (index >= 0 && text.length() == 16 && text.matches("^[0-9]*$")) { // proper IBAN check

                    JOptionPane.showMessageDialog(null, "Enjoy your new vehicle!", "Thank you", JOptionPane.INFORMATION_MESSAGE);
                    modelList.remove(index);
                    //reqBtn.setEnabled(true);
                    if (!adminRights) { // if there are no admin rights, the car may be deleted from backend data aswell
                        try {
                            cars.carData.deleteCar(cars.carData.carList.get(index));
                        } catch (Exception ignored) {};
                        try {
                            cars.carData.deleteMoto(cars.carData.motoList.get(0));
                        } catch (Exception ignored) {};
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Wrong IBAN!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    /**
     * This function creates a menubar for serialization, licensing and exit item.
     */
    private void createMenu() {

        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");

        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");
        aboutItem = new JMenuItem("About");

        loadIcon = new ImageIcon(new ImageIcon(".\\src\\project\\Backend\\Img\\loadIcon.png")
                .getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        saveIcon = new ImageIcon(new ImageIcon(".\\src\\project\\Backend\\Img\\saveIcon.png")
                .getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        exitIcon = new ImageIcon(new ImageIcon(".\\src\\project\\Backend\\Img\\exitIcon.png")
                .getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        aboutIcon = new ImageIcon(new ImageIcon(".\\src\\project\\Backend\\Img\\aboutIcon.png")
                .getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

        loadItem.setIcon(loadIcon);
        saveItem.setIcon(saveIcon);
        exitItem.setIcon(exitIcon);
        aboutItem.setIcon(aboutIcon);

        fileMenu.setMnemonic(KeyEvent.VK_F); // sets keyevents so the GUI is responsive to keys aswell
        helpMenu.setMnemonic(KeyEvent.VK_H);
        loadItem.setMnemonic(KeyEvent.VK_L);
        saveItem.setMnemonic(KeyEvent.VK_S);
        exitItem.setMnemonic(KeyEvent.VK_E);

        fileMenu.add(loadItem); // adds items to its respective menus, to preserve better organisation
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        loadItem.addActionListener(e -> { // load item loads serialized data from the memory
            if (e.getSource() == loadItem) {

                FileInputStream fis;
                ObjectInputStream ois;

                try { // loading needs to be wrapped in try-catch in case there is no data to be loaded

                    fis = new FileInputStream(".\\src\\project\\carData.out");

                    ois = new ObjectInputStream(fis);

                    Object listObject = ois.readObject();
                    modelList = (DefaultListModel) listObject;

                    myList = new JList<>(modelList); // jlist needs to be reinitalited with new data
                    myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                    remove(scrollPane); // delete old scrollpane
                    scrollPane = new JScrollPane(myList);

                    add(scrollPane, BorderLayout.CENTER); // and add a new one with correct data
                    createLayout(scrollPane, addBtn, renBtn, delBtn, remAllBtn, reqBtn, subBtn, buyBtn);

                    setSize(350,450);

                    addListListener(); // list listener needs to updated for newly loaded list

                } catch (IOException | ClassNotFoundException fnfex) {
                    fnfex.printStackTrace();
                }
            }
        });

        saveItem.addActionListener(e -> { // serialization button
            if (e.getSource() == saveItem) {

                FileOutputStream fos;
                ObjectOutputStream oos;

                try { // serialization process needs to be wrapped in try-catch in case IOException occurs
                    fos = new FileOutputStream(".\\src\\project\\carData.out"); // opens output stream

                    oos = new ObjectOutputStream(fos);

                    oos.writeObject(modelList);
                    oos.flush();
                    oos.close(); // closes stream
                } catch (IOException fnfex) {
                    fnfex.printStackTrace();
                }
            }
        });

        exitItem.addActionListener(e -> { // terminates the program
            if (e.getSource() == exitItem) {
                System.exit(0);
            }
        });

        aboutItem.addActionListener(e -> { // displays MIT license in new window
            if (e.getSource() == aboutItem) {
                JOptionPane.showMessageDialog(null, "Copyright 2021 Marko Stahovec\n" +
                        "\n" +
                        "Permission is hereby granted, free of charge, to any person obtaining a copy of this software\n " +
                        "and associated documentation files (the \"Software\"), to deal in the Software without\n " +
                        "restriction, including without limitation the rights to use, copy, modify, merge, publish,\n " +
                        "distribute, sublicense, and/or sell copies of the Software, and to permit persons\n to whom the " +
                        "Software is furnished to do so, subject to the following conditions:\n" +
                        "\n" +
                        "The above copyright notice and this permission notice shall be included in all copies\n or " +
                        "substantial portions of the Software.\n" +
                        "\n" +
                        "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,\n " +
                        "INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR\n " +
                        "PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE\n FOR " +
                        "ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,\n " +
                        "ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS \nIN THE " +
                        "SOFTWARE.", "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    /**
     * This function initalizes the whole user interface.
     */
    private void initUI() {

        createList();
        createButtons();

        scrollPane = new JScrollPane(myList);

        createLayout(scrollPane, addBtn, renBtn, delBtn, remAllBtn, reqBtn, subBtn, buyBtn);
        createMenu();
        createMainIcon();

        setTitle("Luxus Cars");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    /**
     * Creates new group layout for buttons and scrollpane symmetrically.
     */
    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);


        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true); // to ensure small gaps in between components

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[1])
                        .addComponent(arg[2])
                        .addComponent(arg[3])
                        .addComponent(arg[4])
                        .addComponent(arg[5])
                        .addComponent(arg[6])
                        .addComponent(arg[7]))
        );

        gl.setVerticalGroup(gl.createParallelGroup(CENTER)
                .addComponent(arg[0])
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[1])
                        .addComponent(arg[2])
                        .addComponent(arg[3])
                        .addComponent(arg[4])
                        .addComponent(arg[5])
                        .addComponent(arg[6])
                        .addComponent(arg[7]))
        );

        gl.linkSize(addBtn, renBtn, delBtn, remAllBtn, reqBtn, subBtn, buyBtn);

        pack();
    }

    /**
     * Creates icon for the main window using stream to ensure correct pathing.
     */
    private void createMainIcon() {
        logoPath = "GUIIcons\\car.png";
        imgStream = GUI.class.getResourceAsStream(logoPath);
        mainIcon = null;
        try {
            mainIcon = ImageIO.read(imgStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}