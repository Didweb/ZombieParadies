package zombieParadies;

import zombieParadies.play;
import factoryTile.RecMapa;

public class Levels {
	
	
	public static void serverOfLevels(){
		
		
		if (play.getPlayLevel()==0){
			
			play.setPlayLevel(play.getPlayLevel()+1);
			RecMapa.DataPlane(play.getPlayLevel());
			
		}
		
	}
	
	public static void serverOfLevels(int nivel){
		
			play.setPlayLevel(nivel+1);
			RecMapa.DataPlane(play.getPlayLevel());
			
		
		
	}
	
}
