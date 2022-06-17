
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

    File file = new File("src\\data.txt");

    void saveDataToFile(ArrayList<User> listUser) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (User user : listUser) {
                objectOutputStream.writeObject(user);
            }
        } catch (IOException e) {
            System.out.println("Error");
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    System.out.println("Cann't close file");
                }
            }

            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    System.out.print("Cann't close file");
                }
            }
        }
    }
}
