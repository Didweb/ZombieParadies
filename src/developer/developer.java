package developer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import zombieParadies.play;

public class developer extends JPanel{

	/**
	 * Control Vaible for the Developer.
	 */
	private static final long serialVersionUID = 1L;

	
	public static void getData(Graphics g,String[] args){
		
		String stringInfo = "";
		int heightPosition = play.HEIGHT_SCREEN/12;
		Font fontDev=new Font("Monospaced", Font.PLAIN, 11);
		g.setFont(fontDev);
		
		
		g.setColor(Color.black);
		g.fillRect(0, 0, play.WIDTH_SCREEN, heightPosition);
		
		g.setColor(Color.gray);

		int jump = 20;
		int column = 10;
		int widthColumn = stringMoreLong(args);
		
		for (int i = 0 ; i < args.length ; i++) {
			stringInfo = args[i];
			g.drawString(stringInfo, column, jump);
			
			if(jump >= heightPosition-24){
				column += widthColumn;
				jump = 20;
			} else {
				jump +=20; }
			
        }
		
		
		
	}
	
	
	
	public static void coordinatesTiles(Graphics g,  int x, int y, int valuePositionX, int valuePositionY, int widthTile){
		
		g.setColor(Color.gray);
		g.drawRect(valuePositionX, valuePositionY, 64, 64);
		g.setColor(Color.white);
		g.drawString("["+x+"]"+"["+y+"]", valuePositionX+10, valuePositionY+30);
		g.drawString("["+valuePositionX+"]"+"["+valuePositionY+"]", valuePositionX+10, valuePositionY+60);
		
		
		
	}
	
	
	private static int stringMoreLong(String[] text){
		
		int valor = 0;
		for (int x = 0; x < text.length; x++){
			if(text[x].length() > valor){
			valor = text[x].length();
			}
		
		}
		return (valor*7)+10;	
		
	}
	
	
}
