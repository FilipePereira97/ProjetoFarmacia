package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import store.UserStore;
import utils.UserData;

public class NewUserController {
    @javafx.fxml.FXML
    private TextField txtPass;
    @javafx.fxml.FXML
    private Button btnRegistar;
    @javafx.fxml.FXML
    private TextField txtUser;

    @javafx.fxml.FXML
    public void doRegistar(ActionEvent actionEvent) {
        UserData user = new UserData(txtUser.getText(),txtPass.getText());
        if(!UserStore.checkIfUserExists(user)){
            UserStore.getListUserData().add(user);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText(String.format("Utilizador %s adicionado com sucesso!", txtUser.getText()));
            alert.showAndWait();
            Stage stage = (Stage) btnRegistar.getScene().getWindow();
            stage.close();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(String.format("Utilizador %s já existe", txtUser.getText()));
            alert.showAndWait();
            txtUser.clear();
            txtPass.clear();
        }

    }
}
