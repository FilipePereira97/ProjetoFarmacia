package store;

import utils.UserData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class UserStore {
    private static List<UserData> ListUserData = new ArrayList<>();
    private static final String fileUserData = "fileUserData.bin";
    private UserData newUserData;

    public void fillArrayAllUsers(String userName, String userPassword){

        ListUserData.add(new UserData("João", "OlaOla"));
        ListUserData.add(new UserData("Ana", "ByeBye"));
        ListUserData.add(new UserData("21", "filipe"));

        newUserData = new UserData(userName, userPassword);
        ListUserData.add(newUserData);
        //saveArrayUserFile(ListUserData);
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

    public static List<UserData> getListUserData() {
        return ListUserData;
    }

    public static boolean checkIfUserExists(UserData user){
        return UserStore.getListUserData().contains(user);
    }
}
