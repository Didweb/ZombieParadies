package actores;



import java.awt.image.BufferedImage;

import zombieParadies.Juego;

public class Player  extends Actores{

	
	
	private int vidas = 3;
	
	private int playerX = Juego.ANCHO_PANTALLA/2;
	private int playerY = Juego.ALTO_PANTALLA/2;
	
	

	
	public Player(){
		
	
		
		cargarImagen("recursos/player.gif");
		
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
