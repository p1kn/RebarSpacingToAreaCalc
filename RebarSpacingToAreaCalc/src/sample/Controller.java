package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import sample.datamodel.AreaCalc;

public class Controller {

    @FXML
    private ComboBox mainRebarDiameter;
    @FXML
    private ComboBox mainRebarSpacing;
    @FXML
    private ComboBox additionalRebarDiameter;
    @FXML
    private ComboBox additionalRebarSpacing;
    @FXML
    private Label rebarArea;
    @FXML
    private CheckBox additionalRebarCheck;
    @FXML
    private Button calculateButton;

    @FXML
    public void initialize() {
        additionalRebarDiameter.setDisable(true);
        additionalRebarSpacing.setDisable(true);
        mainRebarDiameter.getSelectionModel().select(3);
        mainRebarSpacing.getSelectionModel().select(4);
        additionalRebarDiameter.getSelectionModel().select(3);
        additionalRebarSpacing.getSelectionModel().select(4);
    }

    @FXML
    public void calculateArea(ActionEvent e) {
        if (e.getSource().equals(calculateButton)) {
            if (additionalRebarCheck.isSelected()) {
                AreaCalc mainArea = new AreaCalc(Double.parseDouble(mainRebarDiameter.getValue().toString()),
                        Double.parseDouble(mainRebarSpacing.getValue().toString()));
                AreaCalc additionalArea = new AreaCalc(Double.parseDouble(additionalRebarDiameter.getValue().toString()),
                        Double.parseDouble(additionalRebarSpacing.getValue().toString()));
                rebarArea.setText(String.valueOf(mainArea.getArea()+additionalArea.getArea()));
            }else {
                AreaCalc mainArea = new AreaCalc(Double.parseDouble(mainRebarDiameter.getValue().toString()),
                        Double.parseDouble(mainRebarSpacing.getValue().toString()));
                rebarArea.setText(String.valueOf(mainArea.getArea()));
            }
        }
    }
    @FXML
    public void checkBoxEmpty() {
        boolean disableButtons = !additionalRebarCheck.isSelected();
        additionalRebarDiameter.setDisable(disableButtons);
        additionalRebarSpacing.setDisable(disableButtons);
    }
}
