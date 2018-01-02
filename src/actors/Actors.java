package actors;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Actors {

	protected BufferedImage image = null;
	
	protected int timeAps = 0;
	protected int positionSprit = 0;

	
	
	
	
	public int getTimeAps() {
		return timeAps;
	}


	public int getPositionSprit() {
		return positionSprit;
	}


	public void velocityFrames(boolean Moving){
		
		if(Moving){
			if(timeAps == 12){
				
				if(positionSprit == 3){
					
					positionSprit=0;
					
					} else {positionSprit +=1 ;}
					
					timeAps = 0;
					
			} else { timeAps +=1; }
		}
		
	}
	
	
	protected void loadImage(String pathImage){
		
		
		 File f = new File(pathImage);
	   	    try {
	   	    	image = ImageIO.read(f);
	   			} catch (IOException e) {
	   				System.out.println(" Imagen no:  "+pathImage);
	   			    e.printStackTrace();
	   			}
		
		
	}


}
