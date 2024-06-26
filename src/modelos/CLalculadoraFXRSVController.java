/**
 * Sample Skeleton for 'CalculadoraFXRSV.fxml' Controller Class
 */

package modelos;

import java.net.URL;
import java.util.ResourceBundle;

import exceptiones.DivisionPorCeroException;
import exceptiones.RaizNegativaException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelos.Calculador;



public class CLalculadoraFXRSVController implements Initializable {

    @FXML 
    private TextField display;
    private Calculador evaluar=new Calculador();
 

    
    
    @FXML
    void igual(ActionEvent event) {
    	String result="";
		try {
			result = evaluar.evaluar(display.getText());
		} catch (DivisionPorCeroException e) {
			System.out.println(e);
			e.printStackTrace();
		}
         display.setText(result);
    }

    
    @FXML
    void buttons(ActionEvent event) {
    	String str = ((Button) event.getSource()).getText();
        insertNumero(str);
    }

    
    @FXML
    void porcentaje(ActionEvent event) {
    	float perc = Float.parseFloat(display.getText());
         display.setText(String .valueOf(perc/100));
    }
    
    @FXML
    void borrar(ActionEvent event) {
          display.setText("");
    }
     

    @FXML
    void raiz(ActionEvent event) throws RaizNegativaException {
        float num = (float) Math.sqrt(Float.parseFloat(display.getText())); 
        display.setText(String.valueOf(num));
    }
    
    
    @FXML
    void coma(ActionEvent event) {
    	if(!digito && !punto) {display.setText("0.");  digito=true; }
    	else if(!punto) { String valorActual = display.getText();
		display.setText(valorActual+"."); } digito=true;
    }
      

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	
	/*--------------------------------------------display----------------------------------------------------*/
	 boolean digito=false;	
	 boolean punto=false;   
	 public void insertNumero(String numero) { 
	 if(numero.equals("0") && !digito){ return; }
	 if(!digito) { display.setText(""); punto=false; }	
	 display.setText(display.getText() + numero); digito=true; } 
	 
}
