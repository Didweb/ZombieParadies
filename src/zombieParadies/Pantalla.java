package zombieParadies;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

import developer.developer;
import factoryTile.RecMapa;


public class Pantalla extends JPanel {

	
    
	private static final long serialVersionUID = 1L;

	private static int scrollX;
	private static int scrollY;
	
	public Pantalla() {
	
	
	}
	
	public void actualizar(int scrollX, int scrollY){
	
		this.scrollX = scrollX;
		this.scrollY = scrollY;
		
	}
	
	public void update(Graphics g){
	    paint(g);        
	    
	}

	public void paint(Graphics g){
		
		int lax=0;
		int lay=0;
		
		int valorPosicionX;
		int valorPosicionY;

		for(int x=0; x < RecMapa.MapTileN; x++){
			
			
			
			
			if( lax == RecMapa.WidthMap ){
				lax = 0;
				lay += 1;
				} 
			
			valorPosicionX = (lax*RecMapa.ANCHO_TILE)+scrollX;
			valorPosicionY = (lay*RecMapa.ANCHO_TILE)+scrollY;
			
			g.drawImage(RecMapa.suelo[lax][lay], valorPosicionX, valorPosicionY, this);
			
			
			if (Juego.isVerDev()){
			developer.miniMapa(g,  lax, lay, valorPosicionX, valorPosicionY, RecMapa.ANCHO_TILE);}
			
			
			if( lax < RecMapa.WidthMap ) {lax += 1;}

		}
		
		
		
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