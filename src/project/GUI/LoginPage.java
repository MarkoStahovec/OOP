package project.GUI;

import javax.swing.*;

/**
 * This class resembles the first window that asks user for password input.
 */
public class LoginPage {

    protected boolean admin; // this boolean value represents admin rights, as what password was typed as an input

    LoginPage() {

        String text = JOptionPane.showInputDialog("Password: "); // password input window

        String newItem = null;

        if (text != null) {
            newItem = text.trim(); // trimming the password of unnecessary spacing
        }
        else {
            System.exit(0);
        }

        admin = newItem.equals("admin"); // if the password was admin, admin rights are set to true

        if (newItem.isEmpty()) {
            System.exit(0); // terminate the window if nothing was typed
        }
    }

}
