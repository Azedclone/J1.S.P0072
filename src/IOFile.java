
import java.util.ArrayList;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Azedclone
 */
public class IOFile {

    void loadDataToList(ArrayList<User> listUser) {
        File file = new File("src\\data.txt");
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            //Check if file have existed
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);

                //Add object to list until end
                while (true) {
                    //Check if there is any data in stream to read
                    if (fileInputStream.available() != 0) {
                        listUser.add((User) objectInputStream.readObject());
                    } else {
                        break;
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error in loadDataToList");
        } finally {
            try {
                //Close stream after use
                if (fileInputStream != null) {
                    fileInputStream.close();
                }

                //Close stream after use
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Can't close stream");
            }
        }
    }

    void saveDataToFile(ArrayList<User> listUser) {
        File file = new File("src\\data.txt");
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            //Write data of all user to file
            for (User user : listUser) {
                objectOutputStream.writeObject(user);
            }
        } catch (IOException e) {
            System.out.println("Error in saveDataToFile");
        } finally {
            try {
                //Close stream after use
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }

                //Close stream after use
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Cann't close stream");
            }
        }
    }
}
