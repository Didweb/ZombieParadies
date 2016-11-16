package actores;


import java.awt.image.BufferedImage;

import factoryTile.RecMapa;
import zombieParadies.Juego;

public class Player  extends Actores {

	
	
	private int vidas = 3;
	
	private int playerX = Juego.ANCHO_PANTALLA/2;
	private int playerY = Juego.ALTO_PANTALLA/2;
	
	private int[] valoresImagenPlayer = new int[8];
	

	
	public Player(){
		
		cargarImagen("recursos/player.gif");
		
	}

	
	public int[] animaPlayer(int direccion){
		
		
		valoresImagenPlayer[0] = playerX;
		valoresImagenPlayer[1] = playerY;
		valoresImagenPlayer[2] = playerX+RecMapa.ANCHO_TILE;
        valoresImagenPlayer[3] = playerY+RecMapa.ANCHO_TILE;
        valoresImagenPlayer[4] = direccion*RecMapa.ANCHO_TILE;
        valoresImagenPlayer[5] = (posicionSprit*RecMapa.ANCHO_TILE);
        valoresImagenPlayer[6] = (direccion*RecMapa.ANCHO_TILE)+RecMapa.ANCHO_TILE;
        valoresImagenPlayer[7] = (posicionSprit*RecMapa.ANCHO_TILE)+RecMapa.ANCHO_TILE;
        
        return valoresImagenPlayer;
			
	}
	
	
	public void animarPlayer(){
		
	}
	

	public BufferedImage getImagen() {
		return imagen;
	}

	public int getPlayerX() {
		return playerX;
	}




	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}




	public int getPlayerY() {
		return playerY;
	}




	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}
	

	

}
