package actores;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Actores {

	protected BufferedImage imagen = null;
	

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
