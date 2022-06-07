package project.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This is the runnable class that invokes the GUI object.
 */
public class GUIMain {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> { // call for new swing utilites

            GUI frame = new GUI(); // constructor for the whole class
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to ensure correct termination when clicked on X top-right
            frame.setTitle("LuxusCars");
            frame.setSize(350,450);

            //ImageIcon image = new ImageIcon("C:\\Users\\A\\IdeaProjects\\school\\src\\project\\Backend\\Img\\car.png");
            ImageIcon image = new ImageIcon(new ImageIcon(GUI.mainIcon).
                    getImage().getScaledInstance(184, 148, Image.SCALE_DEFAULT)); // creates icon and adds it next line


            frame.setIconImage(image.getImage());
            frame.getContentPane().setBackground(new Color(0xD1DBEC)); // adds different color to contentpane


            frame.setVisible(true);
        });
    }
}
