package PSL.Interfaz;

import javax.swing.JOptionPane;

import PSL.Mundo.ImpresorLCD;

public class Interfaz {
	
	//Crea un objeto de tipo ImpresorLCD
	ImpresorLCD lcd;
	
	/**
	 * Entrada que contiene el size y los numeros que desea 
	 * ver el usuario
	 */
	private String entrada;
	
	/**
	 * Distancia entre cada digito del lcd
	 * es indicada por el usuario
	 */
	private String cadenaDis;
	
	/**
	 * Variable de tipo boolean que permite terminar el programa
	 */
	private boolean salir;
	
	
	public Interfaz()
	{
		salir=true;
		while(salir)
		{
			try
			{
			
				entrada = JOptionPane.showInputDialog(null,"Digite la entrada la cual contiene 2 numeros separados por coma: \n"+
						"1re#. representa el tamano de la impresion (1-10)\n"+
						"2do#. es el numero a mostrar en pantalla\n"+
						"Nota: para terminar se debe digitar 0,0 ", "Pantalla LCD", JOptionPane.INFORMATION_MESSAGE);
				
				//Valida si el usuario desea finalizar la ejecucion del programa
				if(entrada.equals("0,0"))
					salir = false;
				else
				{
					try
					{
						cadenaDis =JOptionPane.showInputDialog("Digite la distancia entre cada digito\n(debe estar entre 1 y 5)");
						
						//Crea un objeto de tipo lcd con los parametros dados por el usuario
						lcd = new ImpresorLCD(entrada, cadenaDis);
						
						//valida que la entrada cumpla con los requisitos del programa
						lcd.procesar();
						
				        //valida si es numero y actualiza el valor de la variable espacio
				        lcd.actualizarEspacio();
				        
				        //crea la matriz 
				        lcd.crearMatriz();
				        
				        //llena la matriz de impresion 
				        lcd.llenarMatriz();
				        
				        // Realiza la impresion del numero o los numeros que indico el usuario
				        lcd.imprimirMatriz();
					}
					catch(Exception ex)
					{
						System.out.println("Error: Recuerde que la distancia entre cada digito debe ser "
								+ "un valor numerico entre 1 y 5\n"+ex.getMessage());
					}
				}
				
			}
			 catch (Exception ex) 
	        {
	            System.out.println("Error: Para terminar digite 0,0 "+ex.getMessage());
	        }
		}
	}

	public static void main(String[] args) {
		
		Interfaz interfaz = new Interfaz();

	}

}
