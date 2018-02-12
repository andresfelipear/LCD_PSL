package PSL.Test;

import PSL.Mundo.ImpresorLCD;
import junit.framework.TestCase;

/**
 * Esta es la clase usada para verificar que los métodos de la clase ImpresorLCD estén correctamente implementados
 */
public class TestLCD extends TestCase {
	
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se harán las pruebas
     */
    private ImpresorLCD lcd;

    // -----------------------------------------------------------------
    // Métodos
    // --
    
    /**
     * Construye un nuevo LCD donde el usuario puso de entrada 2,125
     * y el espacio entre digitos es 3
     */
    private void setupEscenario1( )
    {
        lcd = new ImpresorLCD("2,125","3");

    }
    
    /**
     * Construye un nuevo LCD donde el usuario puso de entrada 3,256
     * el espacio entre digitos es 4. Ademas se procesaron
     * la entrada y la distancia entre digitos
     */
    private void setupEscenario2( )
    {
        lcd = new ImpresorLCD("3,256","4");
        lcd.procesar();
        lcd.actualizarEspacio();

    }
    
    /**
     * Prueba 1 - Procesar la entrada dada por el usuario
     */
    public void testProcesar( )
    {
        setupEscenario1( );

        lcd.procesar();
        assertTrue( "el size deberia ser igual a 2", lcd.darSize() == 2 );
        assertTrue( "los numeros que desea imprimir el usuario deberian ser 125", lcd.darCaracteres().equals("125") );
    }
    
    /**
     * Prueba 2 - Procesar la distancia entre digitos dada por el usuario
     */
    public void testActualizarEspacio( )
    {
        setupEscenario1( );

        lcd.actualizarEspacio();
        assertTrue( "el espacio entre digitos deberia ser 3", lcd.darDisDigitos() == 3 );
    }
    
    /**
     * Prueba 3 - Inicializar y Crear la matriz de impresion
     */
    public void testCrearMatriz( )
    {
        setupEscenario2();
        lcd.crearMatriz();
        
        assertTrue( "las filas de cada digito deberian ser 9", lcd.darFilasDigito() == 9 );
        assertTrue( "las columnas de cada digito deberian ser 5", lcd.darColumnasDigito() == 5 );
        assertTrue( "el total de filas de la matriz de impresion deberia ser 9", lcd.darTotalFilas() == 9 );
        assertTrue( "el total de columnas de la matriz de impresion deberia ser 27", lcd.darTotalColum() == 27 );
    }
    
    /**
     * Prueba 4 - Llenar la matriz de impresion
     */
    public void testLlenarMatriz( )
    {
        setupEscenario2();
        lcd.crearMatriz();
        lcd.llenarMatriz();
        
        assertTrue( "pf1[1] deberia ser 18", lcd.darPf1()[1] == 18 );
        assertTrue( "pf2[1] deberia ser 18", lcd.darPf2()[1] == 18 );
        assertTrue( "pf3[1] deberia ser 18", lcd.darPf3()[1] == 18 );
        assertTrue( "pf4[1] deberia ser 22", lcd.darPf4()[1] == 22 );
        assertTrue( "pf5[1] deberia ser 22", lcd.darPf5()[1] == 22 );
    }
    

}
