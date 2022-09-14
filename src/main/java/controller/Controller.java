package controller;

import javafx.scene.control.TextField;
import utils.Calculos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class Controller {

    @FXML
    private static TextField multiBanco;
    @FXML
    private static TextField cash;
    @FXML
    private static TextField others;
    @FXML
    private static TextField totalObt;
    @FXML
    private static TextField totalPrev;
    @FXML
    private static TextField desv;




    public static double mbValor(){
        double mbVal;
        mbVal = Double.valueOf(multiBanco.getText());
        return mbVal;
    }

    public static double cashValor(){
        double cashVal;
        cashVal = Double.valueOf(cash.getText());
        return cashVal;
    }

    public static double otherValor(){
        double otherVal;
        otherVal = Double.valueOf(others.getText());
        return otherVal;
    }

    public static double totalPrev(){
        double totPrev;
        totPrev = Double.valueOf(totalPrev.getText());
        return totPrev;
    }

    public static void fillTotalObt(){
        double valObt;
        valObt = Calculos.totalObtido();
        totalObt.setText(String.valueOf(valObt));
    }

    public static void fillDesv(){
        desv.setText(String.valueOf(Calculos.desvio()));
    }


    public void openCalc(ActionEvent actionEvent) throws IOException, InterruptedException {
        Process openCalc = Runtime.getRuntime().exec("calc.exe");
        openCalc.waitFor();
    }
}
