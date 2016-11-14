package factoryTile;



import java.awt.image.BufferedImage;
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
		planoBruto = new int[MapTileN];
		
		for(int i=0; i<MapTileN; i++){
			
			switch(planoBruto[i]){
					
					// Negro
					case 0xff000000:
						MapTile[i] = 0;
						continue;
					
					// Blanco
					case 0xffffffff:
						MapTile[i] = 1;
						continue;
					
					
					default:
						MapTile[i] = 0;
					}
			
		}
		

		
		NivelCargado = nivel;
		
		
		
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
			
			
			imagen.getRGB(0, 0, WidthMap, HightMap, planoBruto, 0, WidthMap);
			
			} catch (IOException e) {
				System.out.println(" Imagen no encontrada ");
				e.printStackTrace();
			}
		
	}
	
	
}
