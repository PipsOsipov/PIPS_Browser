package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

public class SampleController implements Initializable{

	private String home;
	
	private double Zoom;
	
	private WebEngine engine;
	
    @FXML
    private TextField enterURL;
    
    private WebHistory history;

    @FXML
    private WebView pageView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		engine = pageView.getEngine();
		home = "google.com";
		enterURL.setText(home);
		Zoom = 1;
		searchpage();
	}
	
	@FXML
    public void searchpage() {
    	engine.load("http://www."+ enterURL.getText());
    }
	
    @FXML
    public void refreshpage() {
    	
    	engine.reload();
    }

    @FXML
    public void zoomin() {
    	Zoom += 0.2;
    	pageView.setZoom(Zoom);
    }
    
    @FXML
    public void zoomout(){
    	Zoom -= 0.2;
    	pageView.setZoom(Zoom);
    	
    }
    
    @FXML
    public void ShowHistory() {
	     history = engine.getHistory();
	     ObservableList<WebHistory.Entry>  entries = history.getEntries(); 
	     
	     for (WebHistory.Entry entry : entries) {
	    	 System.out.println(entry.getUrl()+""+entry.getLastVisitedDate()); 
	     }
    }
    
    @FXML
    public void nextPage() {
    	history = engine.getHistory();
	    ObservableList<WebHistory.Entry>  entries = history.getEntries(); 
	    history.go(1);
	    enterURL.setText(entries.get(history.getCurrentIndex()).getUrl());
	}
    
    @FXML
    public void previousPage() {
    	history = engine.getHistory();
	    ObservableList<WebHistory.Entry>  entries = history.getEntries(); 
	    history.go(-1);
	    enterURL.setText(entries.get(history.getCurrentIndex()).getUrl());
    }
}