import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserStore {
    private List<UserData> ListUserData = new ArrayList<>();
    private static final String fileUserData = "fileUserData.bin";
    private UserData newUserData;

    public void fillArrayAllUsers(String userName, String userPassword){

        new UserData("João", "OlaOla");
        new UserData("Ana", "ByeBye");
        new UserData("qwert", "123123");

        newUserData = new UserData(userName, userPassword);
        ListUserData.add(newUserData);
        saveArrayUserFile(ListUserData);
    }


    public static boolean saveArrayUserFile(List<UserData> ListUserData) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileUserData));
            try {
                out.writeObject(ListUserData);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static UserStore listUserArrivalRead(){
        UserStore readListUserArrival;

        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileUserData));
            try{
                readListUserArrival = (UserStore) in.readObject();
            }finally {
                in.close();
            }
            return readListUserArrival;
        }catch (IOException | ClassNotFoundException e){
            return new UserStore();
        }
    }
}
