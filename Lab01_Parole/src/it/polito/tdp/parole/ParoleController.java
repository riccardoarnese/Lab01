package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco ;
	double ti ;
	double tf;
	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader
    
    @FXML
    private TextArea txtTime;
    
    @FXML
    private Button btncancella;

    @FXML
    void doCancel(ActionEvent event) {
    	ti= System.nanoTime();
    	String temp= txtResult.getSelectedText().trim();
    	
    	if(temp.length()!=0)
    		elenco.rimuoviParola(temp);
    	
    	txtParola.clear();
    	txtResult.clear();
    	txtTime.clear();
    	
    	for (String st : elenco.getElenco())
    		txtResult.appendText(st+"\n");
    	
    	tf=System.nanoTime();
    	txtTime.appendText("Tempo di esecuzione: "+String.valueOf((tf-ti)*1000000000)+" secondi");
    }

    @FXML
    void doInsert(ActionEvent event) {
    	
    	ti= System.nanoTime();
    	
    	String temp = txtParola.getText().trim();
    	
    	if(temp.length()!=0)
    	{
    		elenco.addParola(temp);
    		
    	}
    	txtParola.clear();
    	txtResult.clear();
    	txtTime.clear();
    	
   
    
	for (String st : elenco.getElenco())
		txtResult.appendText(st+"\n");
	tf= System.nanoTime();
	txtTime.appendText("Tempo di esecuzione: "+String.valueOf((tf-ti)*1000000000)+" secondi");
    	
    	
    	// TODO
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	ti= System.nanoTime();
    	
    	// TODO
    	elenco.reset();
    	txtParola.clear();
    	txtResult.clear();
    	txtTime.clear();
    	tf= System.nanoTime();
    	txtTime.appendText("Tempo di esecuzione: "+String.valueOf((tf-ti)*1000000000)+" secondi");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";

        elenco = new Parole() ;
        
    }
}
