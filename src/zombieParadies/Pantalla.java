package zombieParadies;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

import actores.Player;
import developer.developer;
import factoryTile.RecMapa;



public class Pantalla extends JPanel {

	
    
	private static final long serialVersionUID = 1L;

	private static int scrollX;
	private static int scrollY;
	
	private static Player player;
	
	public int devTilesPintados = 0;

	private int direccion;
	private int posicionSprit = 0;
	private int tiempoFotograma = 0;
	private boolean enMovimiento;
	
	
	
	
	public Pantalla(Player player) {
	
	 this.player = player;
	}
	
	
	public void actualizar(int scrollX, int scrollY, int direccion, boolean enMovimiento){
	
		this.scrollX = scrollX;
		this.scrollY = scrollY;
		this.direccion = direccion;
		this.enMovimiento = enMovimiento;
	
		// Actualizamos los frames de animacion del player
		player.velocidadFrames(enMovimiento);
		

		
	}
	
	public void update(Graphics g){
	    paint(g);        
	    
	}

	public void paint(Graphics g){
		
		int lax=0;
		int lay=0;
		int[] valoresPlayerAnima = new int[8];
		int valorPosicionX;
		int valorPosicionY;
		devTilesPintados = 0;
		for(int x=0; x < RecMapa.MapTileN; x++){
			
			
			
			
			if( lax == RecMapa.WidthMap ){
				lax = 0;
				lay += 1;
				} 
			
			valorPosicionX = (lax*RecMapa.ANCHO_TILE)+scrollX;
			valorPosicionY = (lay*RecMapa.ANCHO_TILE)+scrollY;
			
			
			// Pintamos el terreno
			if(valorPosicionX>-80 && valorPosicionY>-80 && valorPosicionX<Juego.ANCHO_PANTALLA && valorPosicionY<Juego.ALTO_PANTALLA){
				g.drawImage(RecMapa.suelo[lax][lay], valorPosicionX, valorPosicionY, this);
				devTilesPintados +=1;
			}
			
			
			// Mostramos al Player
			valoresPlayerAnima = player.animaPlayer(direccion);
			g.drawImage(player.getImagen(),  
					valoresPlayerAnima[0], valoresPlayerAnima[1], valoresPlayerAnima[2], valoresPlayerAnima[3],
					valoresPlayerAnima[4], valoresPlayerAnima[5], valoresPlayerAnima[6], valoresPlayerAnima[7], 
					this);
			
			
			if (Juego.isVerDev()){
			developer.coordenadasTiles(g,  lax, lay, valorPosicionX, valorPosicionY, RecMapa.ANCHO_TILE);}
			
			
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
					"Tiles Pintados: " + devTilesPintados,
					"Dirección: " + direccion,
					"posicionSprit: " + player.getPosicionSprit(),
					"tiempoFotograma: " + player.getTiempoAps(),
					"EnMovimineto: " + enMovimiento
					};
		developer.sacaDato(g,arg);
		
	}
	
	
	
	
	
	
	
	
}