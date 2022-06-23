
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Azedclone
 */
public class LoginSystem {

    ArrayList<User> listUser = new ArrayList<>();
    GetData getData = new GetData();

    int findIndex(String username, ArrayList<User> listUser) {
        for (User user : listUser) {
            if (user.getUsername().equals(username)) {
                return listUser.indexOf(user);
            }
        }

        return -1;
    }

    void addUser() {
        try {
            IOFile ioFile = new IOFile();

            if (listUser.isEmpty()) {
                ioFile.loadDataToList(listUser);
            }

            System.out.println("------- Add User -------");

            String username = getData.getString("Username: ", "^.*$", "");
            int index = findIndex(username, listUser);

            if (index == -1) {
                String password = getData.getString("Password: ", "^.*$", "");
                String name = getData.getString("Name: ", "^[a-zA-Z\\s]+$", "Name must contain only letter");
                String phone = getData.getString("Phone: ", "^\\d{10,11}$", "Phone must be 10 or 11 numbers");
                String email = getData.getEmail("Email: ");
                String address = getData.getString("Address: ", "^[a-zA-Z\\s]+$", "Address must contain only letter");
                Date dob = getData.getDate("DOB: ");

                User user = new User(username, password, name, phone, email, address, dob);
                listUser.add(user);
                ioFile.saveDataToFile(listUser);
                System.out.println("Add user to database successfully!");
            } else {
                System.out.println("This username already exist!");
            }
        } catch (Exception e) {
            System.out.println("Error in addUser()");
        }
    }

    void login() {
        try {
            IOFile ioFile = new IOFile();

            if (listUser.isEmpty()) {
                ioFile.loadDataToList(listUser);
            }

            System.out.println("------- Login --------");
            String username = getData.getString("Username: ", "^.*$", "");
            String password = getData.getString("Password: ", "^.*$", "");

            boolean isExist = false;

            for (User user : listUser) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    isExist = true;
                }
            }

            if (isExist) {
                System.out.println("Hello " + username);
            } else {
                System.out.println("Login fail! Wrong password or number");
            }
        } catch (Exception e) {
            System.out.println("Error in login()");
        }
    }
}
