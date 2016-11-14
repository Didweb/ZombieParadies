package developer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import zombieParadies.Juego;

public class developer extends JPanel{

	/**
	 * Control de variable spor pantalla para el 
	 * Desarrollo.
	 */
	private static final long serialVersionUID = 1L;

	
	public static void sacaDato(Graphics g,String[] args){
		
		String Cadena = "";
		int altoCuadro = Juego.ALTO_PANTALLA/12;
		Font fuenteDev=new Font("Monospaced", Font.PLAIN, 11);
		g.setFont(fuenteDev);
		
		
		g.setColor(Color.black);
		g.fillRect(0, 0, Juego.ANCHO_PANTALLA, altoCuadro);
		
		g.setColor(Color.gray);

		int salto = 20;
		int columna = 10;
		int anchoColumna = cadenaMasLarga(args);
		
		for (int i = 0 ; i < args.length ; i++) {
			Cadena = args[i];
			g.drawString(Cadena, columna, salto);
			
			if(salto >= altoCuadro-24){
				columna += anchoColumna;
				salto = 20;
			} else {
				salto +=20; }
			
        }
		
		
		
	}
	
	
	private static int cadenaMasLarga(String[] cadenas){
		
		int valor = 0;
		for (int x = 0; x < cadenas.length; x++){
			if(cadenas[x].length() > valor){
			valor = cadenas[x].length();
			}
		
		}
		return (valor*7)+10;	
		
	}
	
	
}
