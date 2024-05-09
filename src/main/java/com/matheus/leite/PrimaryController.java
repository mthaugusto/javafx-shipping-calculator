package com.matheus.leite;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PrimaryController {

    @FXML
    private TextField pesoTextField1;

    @FXML
    private TextField pesoTextField2;

    @FXML
    private TextField valorNfTextField;

    @FXML
    private TextField taxaSeguroTextField;

    @FXML
    private Button calcularButton;

    @FXML
    private Text valorFreteText;

    @FXML
    private RadioButton normalRadioButton;

    @FXML
    private RadioButton umEVinteRadioButton;

    @FXML
    private RadioButton ambosRadioButton;

    private static final double TX_MATERIAL_120X120 = 0.22;
    private static final double TX_SEGURO = 0.5 / 100;

    @FXML
    void initialize() {
        taxaSeguroTextField.setEditable(false);
        taxaSeguroTextField.setText("0.5");
        pesoTextField2.setDisable(true);

    }

    public void pisoNormalSelected() {
        if (normalRadioButton.isSelected()) {
            pesoTextField2.setDisable(true);
            pesoTextField1.setPromptText("");
            pesoTextField2.setPromptText("");
        }
    }

    public void pisoUmEVinteSelected() {
        if (umEVinteRadioButton.isSelected()) {
            pesoTextField2.setDisable(true);
            pesoTextField1.setPromptText("");
            pesoTextField2.setPromptText("");
        }
    }

    public void ambosSelected() {
        if (ambosRadioButton.isSelected()) {
            pesoTextField2.setDisable(false);
            pesoTextField1.setPromptText("Normal");
            pesoTextField2.setPromptText("120x120");
        }
    }

    public void calcularFrete() {

        int tipoMaterial; // 0 = normal, 1 = 120x120, 2 = ambos
        double valorFrete = 0;
        double valorFrete2 = 0;
        double peso = Double.parseDouble(pesoTextField1.getText());

        if (normalRadioButton.isSelected()) {
            if (peso <= 500) {
                valorFrete = 465.68;
            } else if (peso <= 1000) {
                valorFrete = 696.11;
            } else if (peso <= 2000) {
                valorFrete = 1173.01;
            } else if (peso <= 3000) {
                valorFrete = 1392.15;
            } else if (peso <= 4000) {
                valorFrete = 1960.22;
            } else if (peso <= 6000) {
                valorFrete = 451.47 * peso / 1000;
            } else if (peso <= 8000) {
                valorFrete = 425.25 * peso / 1000;
            } else if (peso <= 11000) {
                valorFrete = 417.50 * peso / 1000;
            } else {
                valorFrete = 403.98 * peso / 1000;
            }
            double valorNF = Double.parseDouble(valorNfTextField.getText());
            double valorSeguro = valorNF * TX_SEGURO;
            double valorTotal = valorFrete + valorSeguro;
            valorFreteText.setText(String.valueOf(valorTotal));
        }

        if (umEVinteRadioButton.isSelected()) {
            if (peso <= 500) {
                valorFrete = 465.68;
            } else if (peso <= 1000) {
                valorFrete = 696.11;
            } else if (peso <= 2000) {
                valorFrete = 1173.01;
            } else if (peso <= 3000) {
                valorFrete = 1392.15;
            } else if (peso <= 4000) {
                valorFrete = 1960.22;
            } else if (peso <= 6000) {
                valorFrete = 451.47 * peso / 1000;
            } else if (peso <= 8000) {
                valorFrete = 425.25 * peso / 1000;
            } else if (peso <= 11000) {
                valorFrete = 417.50 * peso / 1000;
            } else {
                valorFrete = 403.98 * peso / 1000;
            }

            valorFrete = valorFrete + (valorFrete * TX_MATERIAL_120X120);
            double valorNF = Double.parseDouble(valorNfTextField.getText());
            double valorSeguro = valorNF * TX_SEGURO;
            double valorTotal = valorFrete + valorSeguro;
            valorFreteText.setText(String.valueOf(valorTotal));
        }

        if (ambosRadioButton.isSelected()) {

            double peso2 = Double.parseDouble(pesoTextField2.getText());

            if (peso <= 500) {
                valorFrete = 465.68;
            } else if (peso <= 1000) {
                valorFrete = 696.11;
            } else if (peso <= 2000) {
                valorFrete = 1173.01;
            } else if (peso <= 3000) {
                valorFrete = 1392.15;
            } else if (peso <= 4000) {
                valorFrete = 1960.22;
            } else if (peso <= 6000) {
                valorFrete = 451.47 * peso / 1000;
            } else if (peso <= 8000) {
                valorFrete = 425.25 * peso / 1000;
            } else if (peso <= 11000) {
                valorFrete = 417.50 * peso / 1000;
            } else {
                valorFrete = 403.98 * peso / 1000;
            }


            if (peso2 > 1 && peso2 <= 500) {
                valorFrete2 = 465.68;
            } else if (peso2 <= 1000) {
                valorFrete2 = 696.11;
            } else if (peso2 <= 2000) {
                valorFrete2 = 1173.01;
            } else if (peso2 <= 3000) {
                valorFrete2 = 1392.15;
            } else if (peso2 <= 4000) {
                valorFrete2 = 1960.22;
            } else if (peso2 <= 6000) {
                valorFrete2 = 451.47 * peso2 / 1000;
            } else if (peso2 <= 8000) {
                valorFrete2 = 425.25 * peso2 / 1000;
            } else if (peso2 <= 11000) {
                valorFrete2 = 417.50 * peso2 / 1000;
            } else {
                valorFrete2 = 403.98 * peso2 / 1000;
            }

            valorFrete2 = valorFrete2 + (valorFrete2 * TX_MATERIAL_120X120);
            valorFrete = valorFrete + valorFrete2;
            double valorNF = Double.parseDouble(valorNfTextField.getText());
            double valorSeguro = valorNF * TX_SEGURO;
            double valorTotal = valorFrete + valorSeguro;
            valorFreteText.setText(String.valueOf(valorTotal));
        }

    }
}
