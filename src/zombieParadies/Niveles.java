package zombieParadies;

import zombieParadies.Juego;
import factoryTile.RecMapa;

public class Niveles {
	
	
	public static void servidorDeNiveles(){
		
		
		if (Juego.getJuegoNivel()==0){
			
			Juego.setJuegoNivel(Juego.getJuegoNivel()+1);
			RecMapa.DataPlanos(Juego.getJuegoNivel());
			
		}
		
	}
	
	public static void servidorDeNiveles(int nivel){
		
			Juego.setJuegoNivel(nivel+1);
			RecMapa.DataPlanos(Juego.getJuegoNivel());
			
		
		
	}
	
}
