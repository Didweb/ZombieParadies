package factoryTile;



import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import javax.imageio.ImageIO;





public class RecMapa {
/**
 * We take care to read the maps of each map to be 
 * able to mount the maps.
 * 
 */
	
	private static BufferedImage imagen;

	private static BufferedImage recorte;
	
	
	public static Image[][] floor;
	
	public static int[] MapTile; // The codes of Tiles 
	private static  int[] planeInit;
	
	public static int WidthMap;
	public static int HightMap;
	public static int MapTileN;
	
	public final static int WIDTH_TILE = 64;
	
	public static int WidthScreenMap;
	public static int HeightScreenMap;
	
	public static int LevelLoad = 0;
	public static String mapLoaded;
	
	
	
	
	public static void DataPlane(int level){
		
		
		loadImg("resources/plano_"+level+".gif");
		
		
		MapTile = new int[MapTileN];
		
		for(int i=0; i<MapTileN; i++){
			
			switch(planeInit[i]){
					
					// Clear Grass 
					case 0xffffffff:
						MapTile[i] = 0;
						continue;
					
					// Dark Grass 
					case 0xff000000:
						MapTile[i] = 1;
						continue;
					
						
					// Vertical cut right
					case 0xff4e504f:
						MapTile[i] = 2;
						continue;
							
					// Vertical cut left
					case 0xff757976:
						MapTile[i] = 3;
						continue;
							
					// Horizontal cut up
					case 0xffacb5ae:
						MapTile[i] = 4;
						continue;
							
							
					// Horizontal cut down
					case 0xff9cbfa3:
						MapTile[i] = 5;
						continue;

					// Corner clear Grass up left
					case 0xff699d74:
						MapTile[i] = 6;
						continue;
							
					// Corner clear Grass up right
					case 0xff307c40:
						MapTile[i] = 7;
						continue;
							
					// Corner clear Grass up left
					case 0xff325a3b:
						MapTile[i] = 8;
						continue;
							
					// Corner clear Grass down right
					case 0xff374b3b:
						MapTile[i] = 9;
						continue;


						
						// Corner dark grass up left
						case 0xfffffff1:
							MapTile[i] = 10;
							continue;
								
						// Corner dark Grass up right
						case 0xffffff2:
							MapTile[i] = 11;
							continue;
								
						// Corner dark Grass down left
						case 0xffffff3:
							MapTile[i] = 12;
							continue;
								
						// Corner dark Grass down right
						case 0xffffff4:
							MapTile[i] = 13;
							continue;
						
						
						
						// Corner dark Grass up left
						case 0xff257025:
							MapTile[i] = 14;
							continue;
								
						// Corner dark Grass up right
						case 0xff468346:
							MapTile[i] = 15;
							continue;
								
						// Corner dark Grass down left
						case 0xff6dac6d:
							MapTile[i] = 16;
							continue;
								
						// Corner dark Grass down right
						case 0xff93c493:
							MapTile[i] = 17;
							continue;
						
					default:
						MapTile[i] = 0;
					}
			
		}
		
		drawFloor(level);

		
		LevelLoad = level;
		
		
		
	}
	
	
	private static void drawFloor(int nivel){
		
		floor = new Image [MapTileN][MapTileN];
		
		 File f = new File("resources/Tiles_Suelo_"+nivel+".gif");
		    try {
		    	imagen = ImageIO.read(f);
				} catch (IOException e) {
				    e.printStackTrace();
				}
	    

	    		int lax=0;
	    		int lay=0;
	    		int posX;
	    		int posY;
	    		
				for(int x=0;x<MapTileN;x++){
					
					if( lax == WidthMap ){
						lax = 0;
						lay += 1;
						} else {
							}
					
					posX = MapTile[x]*WIDTH_TILE;
					posY = ((int)(Math.random() * 5)+1)*WIDTH_TILE;

					recorte = (imagen.getSubimage(posX, posY, WIDTH_TILE, WIDTH_TILE));
				            
					floor[lax][lay] = recorte; 
					lax += 1; 
				}
		
		
	}
	
	
	private static void loadImg(String imagePath){
		
		try {
			BufferedImage imagen = ImageIO.read(new FileInputStream(imagePath));
			
			mapLoaded = imagePath;
			WidthMap = imagen.getWidth();
			HightMap = imagen.getHeight();
			MapTileN = WidthMap * HightMap;
			WidthScreenMap = WidthMap * WIDTH_TILE;
			HeightScreenMap = HightMap * WIDTH_TILE;
			
			planeInit = new int[MapTileN];
			imagen.getRGB(0, 0, WidthMap, HightMap, planeInit, 0, WidthMap);
			
			} catch (IOException e) {
				System.out.println(" Image Not Found  ");
				e.printStackTrace();
				planeInit = new int[MapTileN];
			}
		
		
		
	}
	

	
}
