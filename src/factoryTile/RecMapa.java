package factoryTile;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

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
	
	public static int AnchoPantalla;
	public static int AltoPantalla;
	
	
	
	
	public static void DataPlanos(){
		
		cargarImg("recursos/plano_1.gif");
		
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
		

		
		
		
		
		
	}
	
	
	private static void cargarImg(String imagePath){
		
		try {
			BufferedImage imagen = ImageIO.read(new FileInputStream(imagePath));
			System.out.println("Ruta cargada:"+imagePath);
			WidthMap = imagen.getWidth();
			HightMap = imagen.getHeight();
			MapTileN = WidthMap * HightMap;
			AnchoPantalla = WidthMap * ANCHO_TILE;
			AltoPantalla = HightMap * ANCHO_TILE;
			
			System.out.println("Ancho: "+WidthMap +" t. | Alto: "+HightMap+" t. | Total cuadros array mapa: "+MapTileN+" t. | "+imagePath);
			System.out.println("AnchoPantalla: "+AnchoPantalla +" px | AltoPantalla: "+AltoPantalla+" px ");

			//imagen.getRGB(0, 0);
			imagen.getRGB(0, 0, WidthMap, HightMap, planoBruto, 0, WidthMap);
			
			} catch (IOException e) {
				System.out.println(" Imagen no encontrada ");
				e.printStackTrace();
			}
		
	}
	
	
}
