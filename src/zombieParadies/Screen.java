package zombieParadies;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

import actors.Player;
import controls.Controls;
import developer.developer;
import factoryTile.RecMapa;



public class Screen extends JPanel {

	
    
	private static final long serialVersionUID = 1L;

	private static int scrollX;
	private static int scrollY;
	
	private static Player player;
	
	public int devTilesPinted = 0;

	private int direction;
	private int positionSprit = 0;
	private int timeFotogram = 0;
	private boolean moving;
	
	private Controls controls;

	private boolean activDevCoor;

	private boolean activeDev;
	
	
	
	public Screen(Player player) {
	
	 this.player = player;
	}
	
	
	public void update(Controls controls){
	
		this.controls = controls;
		this.scrollX = controls.getScrollX();
		this.scrollY = controls.getScrollY();
		this.direction = controls.getDirection();
		this.moving = controls.isMoving();
		this.activDevCoor = controls.isDevCoor();
		this.activeDev = controls.isVerDev();
		// Update Frames Animation Player
		player.velocityFrames(moving);
		

		
	}
	
	public void update(Graphics g){
	    paint(g);        
	    
	}

	public void paint(Graphics g){
		
		int lax=0;
		int lay=0;
		int[] valuePlayerAnimation = new int[8];
		int valuePositionX;
		int valuePositionY;
		devTilesPinted = 0;
		for(int x=0; x < RecMapa.MapTileN; x++){
			
			
			
			
			if( lax == RecMapa.WidthMap ){
				lax = 0;
				lay += 1;
				} 
			
			valuePositionX = (lax*RecMapa.WIDTH_TILE)+scrollX;
			valuePositionY = (lay*RecMapa.WIDTH_TILE)+scrollY;
			
			
			// Draw floor
			if(valuePositionX>-80 && valuePositionY>-80 && valuePositionX<play.WIDTH_SCREEN && valuePositionY<play.HEIGHT_SCREEN){
				g.drawImage(RecMapa.floor[lax][lay], valuePositionX, valuePositionY, this);
				devTilesPinted +=1;
			}
			
			
			// Draw Player
			valuePlayerAnimation = player.animaPlayer(direction);
			g.drawImage(player.getImage(),  
					valuePlayerAnimation[0], valuePlayerAnimation[1], valuePlayerAnimation[2], valuePlayerAnimation[3],
					valuePlayerAnimation[4], valuePlayerAnimation[5], valuePlayerAnimation[6], valuePlayerAnimation[7], 
					this);
			
			// Mostrar o no mostrar Dev Coordenadas x y en mapa
			if (activDevCoor){
				developer.coordinatesTiles(g,  lax, lay, valuePositionX, valuePositionY, RecMapa.WIDTH_TILE); }
			
			
			if( lax < RecMapa.WidthMap ) {lax += 1;}

		}
		
		
		
		// Active or desactiv Control Developer
		if (activeDev) { showDev(g); }
		
	}


	
	private void showDev(Graphics g){
		
		
		
		String[] arg={
					"Level: " + play.getPlayLevel(),
					"OverCome: " + play.isPlayLevelOvercome(),
					"Level Loaded: " +  RecMapa.LevelLoad,
					"Map: " + RecMapa.mapLoaded,
					"[D] Activated verDev: " + controls.isVerDev(),
					"[X] Activated DevCoor: "+ controls.isDevCoor(),
					"WIDTH_TILE : " + RecMapa.WIDTH_TILE,
					"Map Total Tiles : " + RecMapa.MapTileN,
					"WidthMap (Tiles): " + RecMapa.WidthMap,
					"HightMap (Tiles): " + RecMapa.HightMap,
					"WidthScreenMap (px): " + RecMapa.WidthScreenMap,
					"HeightScreenMap (px): " + RecMapa.HeightScreenMap,
					"Tiles Draw: " + devTilesPinted,
					"Direction: " + direction,
					"positionSprit: " + player.getPositionSprit(),
					"timeFotogram: " + player.getTimeAps(),
					"InMoving: " + moving
					};
		developer.getData(g,arg);
		
	}
	
	
	
	
	
	
	
	
}