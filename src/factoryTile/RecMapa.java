package factoryTile;



import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import javax.imageio.ImageIO;





public class RecMapa {
/**
 * Esta clase ha de poder ller un archivo de imagen
 * donde estra el plano para poder traducirlo en un 
 * array donde indique el tile necesario para cada cuadro.
 * 
 * Ha de ser flexible para poder adaptarse a cualquier tipo de plano.
 * 
 * 
 * 
 */
	
	private static BufferedImage imagen;

	private static BufferedImage recorte;
	
	
	public static Image[][] suelo;
	
	public static int[] MapTile; // Resultado en un array los codigos de los tiles.
	private static  int[] planoBruto;
	
	public static int WidthMap;
	public static int HightMap;
	public static int MapTileN;
	
	public final static int ANCHO_TILE = 64;
	
	public static int AnchoPantallaMap;
	public static int AltoPantallaMap;
	
	public static int NivelCargado = 0;
	public static String mapaCargado;
	
	
	
	
	public static void DataPlanos(int nivel){
		
		
		cargarImg("recursos/plano_"+nivel+".gif");
		
		
		MapTile = new int[MapTileN];
		
		for(int i=0; i<MapTileN; i++){
			
			switch(planoBruto[i]){
					
					// Cesped claro
					case 0xffffffff:
						MapTile[i] = 0;
						continue;
					
					// Cesped Oscuro
					case 0xff000000:
						MapTile[i] = 1;
						continue;
					
						
					// Corte vertical derecha
					case 0xff4e504f:
						MapTile[i] = 2;
						continue;
							
					// Corte Vertical izquierda
					case 0xff757976:
						MapTile[i] = 3;
						continue;
							
					// Corte Horizontal arriba
					case 0xffacb5ae:
						MapTile[i] = 4;
						continue;
							
							
					// Corte Horizontal abajo
					case 0xff9cbfa3:
						MapTile[i] = 5;
						continue;

					// Esquina Verde Claro Arriba izquierda
					case 0xff699d74:
						MapTile[i] = 6;
						continue;
							
					// Esquina Verde Claro Arriba derecha
					case 0xff307c40:
						MapTile[i] = 7;
						continue;
							
					// Esquina Verde Claro Abajo izquierda
					case 0xff325a3b:
						MapTile[i] = 8;
						continue;
							
					// Esquina Verde Claro Abajo derecha
					case 0xff374b3b:
						MapTile[i] = 9;
						continue;


						
						// Esquina Verde Oscuro Arriba izquierda
						case 0xfffffff1:
							MapTile[i] = 10;
							continue;
								
						// Esquina Verde Oscuro Arriba derecha
						case 0xffffff2:
							MapTile[i] = 11;
							continue;
								
						// Esquina Verde Oscuro Abajo izquierda
						case 0xffffff3:
							MapTile[i] = 12;
							continue;
								
						// Esquina Verde Oscuro Abajo derecha
						case 0xffffff4:
							MapTile[i] = 13;
							continue;
						
						
						
						// Esquina Verde Oscuro Arriba izquierda
						case 0xff257025:
							MapTile[i] = 14;
							continue;
								
						// Esquina Verde Oscuro Arriba derecha
						case 0xff468346:
							MapTile[i] = 15;
							continue;
								
						// Esquina Verde Oscuro Abajo izquierda
						case 0xff6dac6d:
							MapTile[i] = 16;
							continue;
								
						// Esquina Verde Oscuro Abajo derecha
						case 0xff93c493:
							MapTile[i] = 17;
							continue;
						
					default:
						MapTile[i] = 0;
					}
			
		}
		
		pintarSuelo(nivel);

		
		NivelCargado = nivel;
		
		
		
	}
	
	
	private static void pintarSuelo(int nivel){
		
		suelo = new Image [MapTileN][MapTileN];
		
		 File f = new File("recursos/Tiles_Suelo_"+nivel+".gif");
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
					
					posX = MapTile[x]*ANCHO_TILE;
					posY = ((int)(Math.random() * 5)+1)*ANCHO_TILE;

					recorte = (imagen.getSubimage(posX, posY, ANCHO_TILE, ANCHO_TILE));
				            
					suelo[lax][lay] = recorte; 
					lax += 1; 
				}
		
		
	}
	
	
	private static void cargarImg(String imagePath){
		
		try {
			BufferedImage imagen = ImageIO.read(new FileInputStream(imagePath));
			
			mapaCargado = imagePath;
			WidthMap = imagen.getWidth();
			HightMap = imagen.getHeight();
			MapTileN = WidthMap * HightMap;
			AnchoPantallaMap = WidthMap * ANCHO_TILE;
			AltoPantallaMap = HightMap * ANCHO_TILE;
			
			planoBruto = new int[MapTileN];
			imagen.getRGB(0, 0, WidthMap, HightMap, planoBruto, 0, WidthMap);
			
			} catch (IOException e) {
				System.out.println(" Imagen no encontrada ");
				e.printStackTrace();
				planoBruto = new int[MapTileN];
			}
		
		
		
	}
	

	
}
