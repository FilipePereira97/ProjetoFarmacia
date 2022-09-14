package controller;

import ui.MainUI;
import ui.NewUserUI;
import utils.UserData;
import store.UserStore;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.Calendar;


public class LoginController {

    static String name = ""; //ir buscar à store
    static String pass = ""; //ir buscar à store
    @FXML
    private PasswordField pwdField;
    @FXML
    private TextField txtUser;
    @FXML
    private Button btnLogin;

    private static int maxAttempts = 3;
    @FXML
    private Button btnNewUser;

    public void initialize() {
        UserStore.getListUserData().add(new UserData("21", "filipe"));
    }
    @FXML
    public void doLogin(ActionEvent actionEvent) {
        if(doLogin(txtUser.getText(),pwdField.getText())){
            maxAttempts = 3;
            new MainUI().run();
            txtUser.clear();
            pwdField.clear();
        }
    }

    public static int dayOfLogin(){
            int day = Calendar.DAY_OF_MONTH;
            return day;
    }

    public boolean doLogin(String id, String pwd) {
        maxAttempts--;
        boolean success = UserStore.checkIfUserExists(new UserData(id, pwd));
        if (!success && maxAttempts > 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Utilizador e/ou Password inválido(s). \nTem mais " + maxAttempts + " tentativa(s).");
            alert.showAndWait();
            txtUser.clear();
            pwdField.clear();
        }
        if(maxAttempts <= 0){
            Platform.exit();
        }
        return success;
    }


    @FXML
    public void openNewUserUI(ActionEvent actionEvent) {
        new NewUserUI().run();
    }
}
