package actors;


import java.awt.image.BufferedImage;

import factoryTile.RecMapa;
import zombieParadies.play;

public class Player  extends Actors {

	
	
	private int lives = 3;
	
	private int playerX = play.WIDTH_SCREEN/2;
	private int playerY = play.HEIGHT_SCREEN/2;
	
	private int[] valueImagePlayer = new int[8];
	

	
	public Player(){
		
		loadImage("resources/player.gif");
		
	}

	
	public int[] animaPlayer(int direction){
		
		
		valueImagePlayer[0] = playerX;
		valueImagePlayer[1] = playerY;
		valueImagePlayer[2] = playerX+RecMapa.WIDTH_TILE;
        valueImagePlayer[3] = playerY+RecMapa.WIDTH_TILE;
        valueImagePlayer[4] = direction*RecMapa.WIDTH_TILE;
        valueImagePlayer[5] = (positionSprit*RecMapa.WIDTH_TILE);
        valueImagePlayer[6] = (direction*RecMapa.WIDTH_TILE)+RecMapa.WIDTH_TILE;
        valueImagePlayer[7] = (positionSprit*RecMapa.WIDTH_TILE)+RecMapa.WIDTH_TILE;
        
        return valueImagePlayer;
			
	}
	
	
	public void animarPlayer(){
		
	}
	

	public BufferedImage getImage() {
		return image;
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
