package actores;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Actores {

	protected BufferedImage imagen = null;
	
	protected int tiempoAps = 0;
	protected int posicionSprit = 0;

	
	
	
	
	public int getTiempoAps() {
		return tiempoAps;
	}


	public int getPosicionSprit() {
		return posicionSprit;
	}


	public void velocidadFrames(boolean enMovimiento){
		
		if(enMovimiento){
			if(tiempoAps == 12){
				
				if(posicionSprit == 3){
					
					posicionSprit=0;
					
					} else {posicionSprit +=1 ;}
					
					tiempoAps = 0;
					
			} else { tiempoAps +=1; }
		}
		
	}
	
	
	protected void cargarImagen(String rutaImagen){
		
		
		 File f = new File(rutaImagen);
	   	    try {
	   	    	imagen = ImageIO.read(f);
	   			} catch (IOException e) {
	   				System.out.println(" Imagen no:  "+rutaImagen);
	   			    e.printStackTrace();
	   			}
		
		
	}


}
