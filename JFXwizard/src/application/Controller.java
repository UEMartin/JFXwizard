package application;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Controller {


	@FXML
	private AnchorPane pane1;

	@FXML
	private AnchorPane pane2;

	@FXML
	private AnchorPane pane3;

	@FXML
	private Label lActualSlide;
	


	public void translateAnimation(double duration, Node node, double byX) {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();

	}

	public void initialize() {
		translateAnimation(0.5, pane2, 600);
		translateAnimation(0.5, pane3, 600);
	}

	int actualSlide = 0;

	@FXML
	void siguiente() {

		if (actualSlide == 0) {
			translateAnimation(0.5, pane2, -600);
			actualSlide++; // showSlide=1
			lActualSlide.setText("2/3");
			
		} else if (actualSlide == 1) {
			
			translateAnimation(0.5, pane3, -600);
			actualSlide++; // showSlide=2
			lActualSlide.setText("3/3");
		} 
	}

	@FXML
	void anterior() {

		 if (actualSlide == 1) {
			translateAnimation(0.5, pane2, 600);
			actualSlide--; // showSlide=0
			lActualSlide.setText("1/3");
		} else if (actualSlide == 2) {
			translateAnimation(0.5, pane3, 600);
			actualSlide--; // showSlide=1
			lActualSlide.setText("2/3");
		}
	}
}
