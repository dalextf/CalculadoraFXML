package dad.calculadorafxml.ui;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    private Calculadora calculadora = new Calculadora();

    private StringProperty numeros = new SimpleStringProperty();

    private ReadOnlyStringWrapper tema = new ReadOnlyStringWrapper(this, "tema");

    @FXML
    private GridPane view;

    @FXML
    private TextField pantallaField;

    @FXML
    private Button borrarButton, ceroButton, cincoButton, comaButton, cuatroButton, divisionButton, dosButton, igualButton;

    @FXML
    private Button limpiarButton, multiplyButton, nueveButton, ochoButton, restaButton, seisButton, sieteButton;

    @FXML
    private Button sumaButton, tresButton, unoButton;



    @FXML
    void onClickBorrar(ActionEvent event) {
        calculadora.borrar();
        numeros.set(calculadora.getPantalla());
    }

    @FXML
    void onClickCero(ActionEvent event) {
        calculadora.insertar('0');
        numeros.set(calculadora.getPantalla());
    }

    @FXML
    void onClickCinco(ActionEvent event) {
        calculadora.insertar('5');
        numeros.set(calculadora.getPantalla());
    }

    @FXML
    void onClickComa(ActionEvent event) {
        calculadora.insertarComa();
        numeros.set(calculadora.getPantalla());
    }

    @FXML
    void onClickCuatro(ActionEvent event) {
        calculadora.insertar('4');
        numeros.set(calculadora.getPantalla());
    }

    @FXML
    void onClickDivision(ActionEvent event) {
        calculadora.operar(Calculadora.DIVIDIR);
        numeros.set(calculadora.getPantalla());
    }

    @FXML
    void onClickDos(ActionEvent event) {
        calculadora.insertar('2');
        numeros.set(calculadora.getPantalla());
    }

    @FXML
    void onClickIgual(ActionEvent event) {
        calculadora.operar(Calculadora.IGUAL);
        numeros.set(calculadora.getPantalla());
    }

    @FXML
    void onClickLimpiar(ActionEvent event) {
        calculadora.borrarTodo();
        numeros.set(calculadora.getPantalla());
    }

    @FXML
    void onClickMultiply(ActionEvent event) {
        calculadora.operar(Calculadora.MULTIPLICAR);
        numeros.set(calculadora.getPantalla());
    }

    @FXML
    void onClickNueve(ActionEvent event) {
        calculadora.insertar('9');
        numeros.set(calculadora.getPantalla());
    }

    @FXML
    void onClickOcho(ActionEvent event) {
        calculadora.insertar('8');
        numeros.set(calculadora.getPantalla());
    }

    @FXML
    void onClickResta(ActionEvent event) {
        calculadora.operar(Calculadora.RESTAR);
        numeros.set(calculadora.getPantalla());
    }

    @FXML
    void onClickSeis(ActionEvent event) {
        calculadora.insertar('6');
        numeros.set(calculadora.getPantalla());
    }

    @FXML
    void onClickSiete(ActionEvent event) {
        calculadora.insertar('7');
        numeros.set(calculadora.getPantalla());
    }

    @FXML
    void onClickSumar(ActionEvent event) {
        calculadora.operar(Calculadora.SUMAR);
        numeros.set(calculadora.getPantalla());
    }

    @FXML
    void onClickTres(ActionEvent event) {
        calculadora.insertar('3');
        numeros.set(calculadora.getPantalla());
    }

    @FXML
    void onClickUno(ActionEvent event) {
        calculadora.insertar('1');
        numeros.set(calculadora.getPantalla());
    }

    public Controller() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
        loader.setController(this);
        loader.load();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pantallaField.textProperty().bind(numeros);
        numeros.set(calculadora.getPantalla());

        // prueba menú

        view.getStylesheets().add("/css/clasico.css");

        MenuItem clasicoItem = new MenuItem("Clasico");
        clasicoItem.setOnAction(e -> {
            view.getStylesheets().remove(0);
            view.getStylesheets().add("/css/clasico.css");
        });

        MenuItem modernoItem = new MenuItem("Moderno");
        modernoItem.setOnAction(e -> {
            view.getStylesheets().remove(0);
            view.getStylesheets().add("/css/moderno.css");
        });

        ContextMenu menu = new ContextMenu(clasicoItem, modernoItem);

        view.setOnMouseClicked(e -> {
            menu.show(view, e.getScreenX(), e.getScreenY());
        });

    }


    public GridPane getView() {
        return view;
    }
}
