import javafx.fxml.FXML;

import java.awt.*;
import java.util.Calendar;

public class LoginController {

    @FXML
    private static TextField userName;
    @FXML
    private static TextField password;
    static String name = ; //ir buscar à store
    static String pass = ; //ir buscar à store

    public static boolean checkLogin(){
        if (userName.getText() != name || password.getText() != pass){
            return false;
        }else{

            return true;
        }
    }

    public static int dayOfLogin(){
        if(checkLogin()) {
            int day = Calendar.DAY_OF_MONTH;
            return day;
        }
        else return 32;
    }
}
