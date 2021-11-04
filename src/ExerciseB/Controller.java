package ExerciseB;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
   @FXML
   private TextField setStrokeWidth;
   @FXML
   private ComboBox<String> combo_box;
   @FXML
   private RadioButton btnGreen, btnBlue, btnRed;
   @FXML
   private ToggleGroup ColorChoiceGroup;
   @FXML
   private CheckBox check_box;
   @FXML
   private Circle circle_1;
   @FXML
   private Rectangle rectangle_1;
   @FXML
   private Rectangle rectangle_square;
   @FXML
   private VBox v_box;
   @FXML
   private Color color;

   private final String[] choice_shapes = {"Square", "Circle", "Rectangle"};



   public void getShapeChoice(ActionEvent actionEvent) {
      String choice = combo_box.getValue();
      if(!setStrokeWidth.getText().isEmpty()){
         switch (choice) {
            case "Circle" -> circle_1.setStrokeWidth(Double.parseDouble(setStrokeWidth.getText()));
            case "Rectangle" -> rectangle_1.setStrokeWidth(Double.parseDouble(setStrokeWidth.getText()));
            case "Square" -> rectangle_square.setStrokeWidth(Double.parseDouble(setStrokeWidth.getText()));
         }
      }
      setColor(actionEvent);
   }

   public void setBackGround(){
      if(check_box.isSelected()){
         v_box.setStyle("-fx-background-color: lightyellow; -fx-border-color: black; -fx-border-insets: 2; -fx-border-width: 2; ");
      }
      else {
         v_box.setStyle(" -fx-background-color: rgba(255,255,225,0); -fx-border-color: black; -fx-border-insets: 2; -fx-border-width: 2; ");
      }
   }

   public void mouseClick(){
      circle_1.setFill(Color.BLACK);
      rectangle_1.setFill(Color.BLACK);
      rectangle_square.setFill(Color.BLACK);
   }

   public void setColor(ActionEvent actionEvent){
      if(btnGreen.isSelected()){
         color = Color.GREEN;
      }
      else if(btnBlue.isSelected()){
         color = Color.BLUE;
      }
      else if(btnRed.isSelected()){
         color = Color.RED;
      }
      String choice = combo_box.getValue();
      if(color!=null){
         switch (choice) {
            case "Circle" -> circle_1.setFill(color);
            case "Rectangle" -> rectangle_1.setFill(color);
            case "Square" -> rectangle_square.setFill(color);
         }
      }
   }
   @Override
   public void initialize(URL location, ResourceBundle resources) {
      combo_box.getItems().addAll(choice_shapes);
   }
}
