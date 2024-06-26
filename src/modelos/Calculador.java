package modelos;

import exceptiones.DivisionPorCeroException;

public class Calculador{
	
    
    public String evaluar(String cadena) throws DivisionPorCeroException {
        String[] partes = cadena.split("(?<=[-+x/])|(?=[-+x/])");
        double resultado = Double.parseDouble(partes[0]);
        
        
        for (int i = 1; i < partes.length; i += 2) {
        	
        	char operador = partes[i].charAt(0);
            double numero = Double.parseDouble(partes[i + 1]);
            
        	if(operador=='/' && numero==0) {
              new DivisionPorCeroException("no se puede dividir por cero");
        	}else {
            
           if(operador == 'x') {operador ='*';}
            
            switch (operador) {
                case '+':
                    resultado += numero;
                    break;
                case '-':
                    resultado -= numero;
                    break;
                case '*':
                    resultado *= numero;
                    break;
                case '/':
                	if(numero ==0) {
                		resultado=0;
                	}else {
                		resultado /=numero;
        				resultado=((double) Math.round(resultado * 100) / 100);
                    break; 
                	}
            }
        }

        }	
    	return String.valueOf(resultado);
    }
    

}