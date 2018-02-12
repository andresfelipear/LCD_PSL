package PSL.Mundo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class ImpresorLCD {

    // Puntos fijos
	/**
	 * Constante de tipo entero que hace referencia la esquina superior izquierda del 
	 * display 7 segmentos es decir al punto (0,0).
	 */
    private final int[] pf1;
    
	/**
	 * Constante de tipo entero que hace referencia a la mitad del borde izquierdo del
	 * display 7 segmentos, es decir al punto (0, y/2).
	 * donde y = 2*size+3 
	 */
    private final int[] pf2;
    
	/**
	 * Constante de tipo entero que hace referencia la esquina inferior izquierda del 
	 * display 7 segmentos es decir al punto (0,y).
	 * donde y = 2*size+3 
	 */
    private final int[] pf3;
    
	/**
	 * Constante de tipo entero que hace referencia a la mitad del borde derecho del 
	 * display 7 segmentos es decir al punto (x,y/2).
	 * donde y = 2*size+3
	 * x = size + 2
	 */
    private final int[] pf4;
    
	/**
	 * Constante de tipo entero que hace referencia a la esquina superior derecha del 
	 * display 7 segmentos es decir al punto (x,0).
	 * donde x = size + 2 
	 */
    private final int[] pf5;
    
    /**
     * Matriz de tipo String donde se van a almacenar los segmentos de los numeros deseados
     * para su posterior impresion. 
     */
    private String[][] matrizImpresion;

    /**
     * Constante de tipo String que hace referencia al caracter "|" 
     * el cual sirve para dibujar los segmentos horizontales
     */
    static final String CARACTER_VERTICAL = "|";
    
    /**
     * Constante de tipo String que hace referencia al caracter "-" 
     * el cual sirve para dibujar los segmentos verticales
     */
    static final String CARACTER_HORIZONTAL = "-";
    
    /**
     * Constante de tipo String que indica que se debe dibujar de forma horizontal
     */
    static final String POSICION_X = "X";
    
    /**
     * Constante de tipo String que indica que se debe dibujar de forma vertical
     */
    static final String POSICION_Y = "Y";

    
    /**
     * Tamaño de la impresion (entre 1 y 10)
     */
    private int size;

    /**
     * entero que hace referencia a la cantidad de filas que ocupa un digito en la matriz de impresion
     * se calcula con 2*size+3	
     */
    private int filasDigito;
    
    /**
     * entero que hace referencia a la cantidad de columnas que ocupa un digito en la matriz de impresion
     * se calcula con size+2	
     */
    private int columnasDigito;
    
    /**
     * entero que hace referencia a el total de filas de la matriz de impresion del lcd
     */
    private int totalFilas;
    
    /**
     * entero que hace referencia a el total de columnas de la matriz de impresion del lcd
     */
    private int totalColum;
    
    /**
     * entero que indica el espacio entre cada digito
     * es dado por el usuario
     */
    private int disDigitos;
    
    /**
     * String que almacena los caracteres que el usuario desea ver en el lcd
     */
    private String caracteres;
    
    /**
     * Entrada ingresada por el usuario
     */
    private String entrada;
    
    /**
     * String que indica el espacio entre digitos, es dado por el usuario
     */
    private String espacio;
    
    /**
     * Metodo constructor de la clase ImpresorLCD
     * @param entrada
     * @param espacio
     */
    public ImpresorLCD(String entrada, String espacio )
    {
        // Inicializa variables
        this.pf1 = new int[2];
        this.pf2 = new int[2];
        this.pf3 = new int[2];
        this.pf4 = new int[2];
        this.pf5 = new int[2];
        this.entrada = entrada;
        this.espacio = espacio;
    }

    /**
     *
     * Metodo encargado de añadir una linea a la matriz de Impresion
     *
     * @param matriz Matriz Impresion. 
     * @param posInicial Punto Pivote
     * @param direccionXY string que indica si se debe dibujar en x o y
     * @param size Tamaño Segmento
     * @param caracter Caracter Segmento ("-" o "|")
     */    
    public void adicionarLinea(String[][] matriz, int[] posInicial, String direccionXY,
            int size, String caracter) {

        if (direccionXY.equalsIgnoreCase(POSICION_X)) 
        {
            for (int y = 1; y <= size; y++) 
            { 
                int columna = posInicial[1] + y;
                int fila = posInicial[0];
                matriz[fila][columna] = caracter;
            }
        } 
        else 
        {
            for (int i = 1; i <= size; i++) 
            {
                int fila = posInicial[0] + i;
                int columna = posInicial[1];
                matriz[fila][columna] = caracter;
            }
        }
    }

    /**
     *
     * Metodo encargado de adicionar un segmento a la matriz de Impresion
     * Un display 7 segmentos esta conformado por 7 segmentos
     *
     * @param segmento Segmento a adicionar
     */  
    public void adicionarSegmento(int segmento) {

        switch (segmento) {
            case 1:
                adicionarLinea(this.matrizImpresion, this.pf1, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 2:
                adicionarLinea(this.matrizImpresion, this.pf2, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 3:
                adicionarLinea(this.matrizImpresion, this.pf5, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 4:
                adicionarLinea(this.matrizImpresion, this.pf4, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 5:
                adicionarLinea(this.matrizImpresion, this.pf1, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            case 6:
                adicionarLinea(this.matrizImpresion, this.pf2, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            case 7: 
                adicionarLinea(this.matrizImpresion, this.pf3, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            default:
                break;
        }
    }

    
    
    
    /**
     * Metodo encargado de definir los segmentos que componen cada numero
     * @param numero Digito
     * @return segList Retorna una lista de tipo Integer con los segmentos necesarios para formar el numero
     */
    public List<Integer> segDigito(int numero) {

        List<Integer> segList = new ArrayList<>();

        switch (numero) {
            case 1:
                segList.add(3);
                segList.add(4);
                break;
            case 2:
                segList.add(5);
                segList.add(3);
                segList.add(6);
                segList.add(2);
                segList.add(7);
                break;
            case 3:
                segList.add(5);
                segList.add(3);
                segList.add(6);
                segList.add(4);
                segList.add(7);
                break;
            case 4:
                segList.add(1);
                segList.add(6);
                segList.add(3);
                segList.add(4);
                break;
            case 5:
                segList.add(5);
                segList.add(1);
                segList.add(6);
                segList.add(4);
                segList.add(7);
                break;
            case 6:
                segList.add(5);
                segList.add(1);
                segList.add(6);
                segList.add(2);
                segList.add(7);
                segList.add(4);
                break;
            case 7:
                segList.add(5);
                segList.add(3);
                segList.add(4);
                break;
            case 8:
                segList.add(1);
                segList.add(2);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(6);
                segList.add(7);
                break;
            case 9:
                segList.add(1);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(6);
                segList.add(7);
                break;
            case 0:
                segList.add(1);
                segList.add(2);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(7);
                break;
            default:
                break;
        }
        
        return segList;

    	
    }
    
    
    /**
     *
     * Metodo encargado de  crear el digito mediante la adicion de cada uno de sus segmentos a la matriz
     *
     * @param numero Digito
     */
    public void adicionarDigito(int numero) {
    	
    	List<Integer> listSegm = segDigito(numero);
    	
        Iterator<Integer> iterator = listSegm.iterator();

        while (iterator.hasNext()) {
            adicionarSegmento(iterator.next());
        }
    }
    
    /**
     * Metodo que llena la matriz con los numeros que el usuario desea imprimir en el LCD
     * <b> post: </b>asigna los valores de los pivotes pf1, pf2, pf3
     * pf4 y pf5
     */
    public void llenarMatriz() {
    	
        int pivotX = 0;
        char[] digitos;

   	 	// crea el arreglo de digitos
        digitos = this.caracteres.toCharArray();
        
        //crea los pivotes y posteriormente añade el digito a la matriz
        for (char digito : digitos) {
            
            int numero = Integer.parseInt(String.valueOf(digito));

            //Calcula puntos fijos
            this.pf1[0] = 0;
            this.pf1[1] = 0 + pivotX;

            this.pf2[0] = (this.filasDigito / 2);
            this.pf2[1] = 0 + pivotX;

            this.pf3[0] = (this.filasDigito - 1);
            this.pf3[1] = 0 + pivotX;

            this.pf4[0] = (this.columnasDigito - 1);
            this.pf4[1] = (this.filasDigito / 2) + pivotX;

            this.pf5[0] = 0;
            this.pf5[1] = (this.columnasDigito - 1) + pivotX;

            pivotX = pivotX + this.columnasDigito + this.disDigitos;

            adicionarDigito(numero);
        }        
    	
    }
    
    /**
     * Metodo que crea la matriz de impresion
     * <b>post: </b> establece los valores de filasDigito, columnasDigito,
     * totalFilas, totalColum y el tamano de la matriz de impresion
     * @param numeroImp Numero a Imprimir
     */
    public void crearMatriz(){

        // Calcula el numero de filas cada digito
        this.filasDigito = (2 * this.size) + 3;

        // Calcula el numero de columna de cada digito
        this.columnasDigito = this.size + 2;

        // Calcula el total de filas de la matriz en la que se almacenaran los digitos
        this.totalFilas = this.filasDigito;

        // Calcula el total de columnas de la matriz en la que se almacenaran los digitos
        this.totalColum = (columnasDigito * caracteres.length())
        		+ (disDigitos * caracteres.length());

        // crea la matriz para almacenar los digitos 
        this.matrizImpresion = new String[this.totalFilas][this.totalColum];

        
        // Inicializa matriz
        for (int i = 0; i < this.totalFilas; i++) {
            for (int j = 0; j < this.totalColum; j++) {
                this.matrizImpresion[i][j] = " ";
            }
        }
        
       
    }

    /**
     *
     * Metodo encargado de imprimir los numero almacenados en la matriz
     */    
    public void imprimirMatriz() 
    {
        for (int i = 0; i < this.totalFilas; i++) {
            for (int j = 0; j < this.totalColum; j++) {
                System.out.print(this.matrizImpresion[i][j]);
            }
            System.out.println();
        }
    }

     /**
     *
     * Metodo encargado de procesar la entrada que contiene: el size del segmento
     * y los digitos
     * <b> post: </b> asigna los valores de las variables size y caracteres
     */  
    public void procesar() {
        
        String[] parametros;
        
        int tam;

        //Valida que la cadena ingresada por el usuario contenga el simbolo ","
        if (!this.entrada.contains(",")) {
            throw new IllegalArgumentException("Cadena " + this.entrada
                    + " no contiene caracter ,");
        }
        
        //Se hace el split de la cadena
        parametros = this.entrada.split(",");
          
        //Valida la cantidad de parametros
        if(parametros.length!=2)
        {
           throw new IllegalArgumentException("Cadena " + this.entrada
                    + " no contiene los parametros requeridos"); 
        }
        
        //Valida que el parametro size sea un numerico
        if(isNumeric(parametros[0]))
        {
            tam = Integer.parseInt(parametros[0]);
            
            // se valida que el size este entre 1 y 10
            if(tam <1 || tam >10)
            {
                throw new IllegalArgumentException("El parametro size ["+tam
                        + "] debe estar entre 1 y 10");
            }
        }
        else
        {
            throw new IllegalArgumentException("Parametro Size [" + parametros[0]
                    + "] no es un numero");
        }
        
   	 	// crea e inicializa el arreglo de digitos
        char[] digitos = parametros[1].toCharArray();
        
    	//Valida que los caracteres que el usuario desea imprimir sean numeros
        for (char digito : digitos) {
	        if( ! Character.isDigit(digito))
	        {
	            throw new IllegalArgumentException("El 2do Caracter (" + digito
	                + ") no es un numero");
	        }
        }
        
        //asigna el valor de las variables caracteres y size de acuerdo al procesamiento realizado sobre los datos
        //dados por el usuario
        this.caracteres = parametros[1];     
        this.size = tam;

    }

    /**
     *
     * Metodo encargado de validar si una cadena es numerica
     *
     * @param cadena Cadena
     */  
    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } 
        catch (NumberFormatException ex) {
            return false;
        }
    }
    
    /**
     * Metodo encargado de actualizar el valor de la variable espacio
     * @param dis distancia entre cada digito dada por el usuario.
     */
    public void actualizarEspacio() {
        // Valida si el espacio entre digitos es numerico
        if (ImpresorLCD.isNumeric(this.espacio)) 
        {
            int distancia = Integer.parseInt(this.espacio);
            
            // se valida que el espaciado este entre 0 y 5
            if(distancia >0 && distancia <5)
            {
            	disDigitos = distancia;
            }    
            else
            {
                throw new IllegalArgumentException("El espacio entre "
                        + "digitos debe estar entre 0 y 5");
            }
        } 
        else 
        {
            throw new IllegalArgumentException("La Cadena (" + this.espacio
                    + ") no es un numero");
        }
    }
    
    /**
     * Metodo que da el size del lcd
     * @return size
     */
    public int darSize(){
    	return size;
    }
    
    /**
     * Metodo que da los caracteres que el usuario desea ver en el lcd
     * @return caracteres 
     */
    public String darCaracteres() {
    	return caracteres;
    }
    
    /**
     * Metodo que da el espacio entre digitos
     * @return disDigitos
     */
    public int darDisDigitos() {
    	return disDigitos;
    }
    
    /**
     * Metodo que da las filas de cada digito
     * @return filasDigito
     */
    public int darFilasDigito() {
    	return filasDigito;
    	
    }
    
    /**
     * Metodo que da las columnas de cada digito
     * @return columnasDigito
     */
    public int darColumnasDigito(){
    	return columnasDigito;
    }
    
    /**
     * Metodo que da el total de filas de la matriz de impresion
     * @return totalFilas
     */
    public int darTotalFilas(){
    	return totalFilas;
    }
    
    /**
     * Metodo que da el total de columnas de la matriz de impresion
     * @return totalColum
     */
    public int darTotalColum(){
    	return totalColum;
    }
    
    /**
     * Metodo que da el pivote 1
     * @return
     */
    public int[] darPf1() {
    	return pf1;
    }
    
    /**
     * Metodo que da el pivote 2
     * @return
     */
    public int[] darPf2() {
    	return pf2;
    }
    
    /**
     * Metodo que da el pivote 3
     * @return
     */
    public int[] darPf3() {
    	return pf3;
    }
    
    /**
     * Metodo que da el pivote 4
     * @return
     */
    public int[] darPf4() {
    	return pf4;
    }
    
    /**
     * Metodo que da el pivote 5
     * @return
     */
    public int[] darPf5() {
    	return pf5;
    }

}