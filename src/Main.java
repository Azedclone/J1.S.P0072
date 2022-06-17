/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Azedclone
 */
public class Main {

    public static void main(String[] args) {
        //Declare objects
        Display display = new Display();
        GetData getData = new GetData();
        LoginSystem loginSystem = new LoginSystem();

        //Loop until user choose exit program
        while (true) {
            //1. Display menu
            display.displayMenu();

            //2. Get user's choice
            int choice = getData.getChoice("Please choose one option: ", 1, 3);

            //3. Perform function based on user's choice
            switch (choice) {
                case 1: //Add user to database
                    loginSystem.addUser();
                    break;
                case 2: //Login to system
                    loginSystem.login();
                    break;
                case 3: //Exit program
                    System.exit(0);
            }
        }
    }
}
