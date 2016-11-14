package zombieParadies;


import java.awt.Graphics;
import javax.swing.JPanel;

import developer.developer;



public class Pantalla extends JPanel {

	
    
	private static final long serialVersionUID = 1L;

	
	
	public Pantalla() {
	
	
	}
	
	public void actualizar(){
	

		
	}
	
	public void update(Graphics g){
	    paint(g);        
	    
	}

	public void paint(Graphics g){
		
		// Mostrar o no mostrar alertas de dev
		if (Juego.isVerDev()){
			mostrarDev(g); }
		
	}


	
	private void mostrarDev(Graphics g){
		
		
		
		String[] arg={
					"Nivel: "+Juego.getJuegoNivel(),
					"Superado: "+Juego.isJuegoNivelSuperado()
					};
		developer.sacaDato(g,arg);
	}
	
	
	
	
	
	
	
	
}