package zombieParadies;


import java.awt.Graphics;
import javax.swing.JPanel;

import developer.developer;
import factoryTile.RecMapa;


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
					"Nivel: " + Juego.getJuegoNivel(),
					"Superado: " + Juego.isJuegoNivelSuperado(),
					"Nivel Cargado: " +  RecMapa.NivelCargado,
					"Mapa: " + RecMapa.mapaCargado,
					"ANCHO_TILE : " + RecMapa.ANCHO_TILE,
					"Mapa Total Tiles : " + RecMapa.MapTileN,
					"WidthMap (Tiles): " + RecMapa.WidthMap,
					"HightMap (Tiles): " + RecMapa.HightMap,
					"AnchoPantallaMap (px): " + RecMapa.AnchoPantallaMap,
					"AltoPantallaMap (px): " + RecMapa.AltoPantallaMap,
					};
		developer.sacaDato(g,arg);
	}
	
	
	
	
	
	
	
	
}