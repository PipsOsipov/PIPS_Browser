module PIPS_Browser {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.web;
	requires junit;
	
	opens application to javafx.graphics, javafx.fxml;
}
