package zombieParadies;




import javax.swing.JFrame;

import actors.Player;
import zombieParadies.Screen;
import zombieParadies.Levels;
import controls.Controls;




public class play  extends JFrame implements Runnable{
 
	/**
	* Centro del Juego creación de loop del juego.
    */
    private static final long serialVersionUID = 2997131868080903015L;
    
	private static boolean playActiv = false;
	private static int playLevel = 0;
	private static boolean playLevelOvercome = false;
	
	public static final int WIDTH_SCREEN = 1400;
	public static final int HEIGHT_SCREEN = 1250;



	private static Thread thread;

	private static String  COUNT_APS = "";
	private static String  COUNT_FPS = "";
	
	private static int aps=0;
	private static int fps = 0;
	

	private static Screen screen;
	private static Controls controls;
	private static Player player;

	private static boolean verDev = true;
	
	private play() {
		
		player = new Player();
		
		screen = new Screen(player);
		controls = new Controls();
		
		
		
		
		addKeyListener(controls);
		setSize(1400,1250);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setFocusable(true);
		
		add(screen);
		setVisible(true);
		
		
	}
	

	
	private synchronized void init(){
		
		playActiv = true;
		Levels.serverOfLevels();

		thread = new Thread(this, "Graficos");
		thread.start();
	}
	




	private void update(){	
		
		controls.update();
		screen.update(controls);
		
	
		
		if(playLevelOvercome){
			Levels.serverOfLevels(playLevel);
		}
		
		aps ++;
	}
	
	private void draw(){
		
		repaint();
		
		fps ++;
	}
	
	
	
	@Override
	public void run() {
		final int NS_PRO_SECONDS = 1000000000;
		final byte APS_OBJETIV = 60;
		final double NS_PRO_UPDATE = NS_PRO_SECONDS / APS_OBJETIV;
		
		long referenceUpdate = System.nanoTime();
		long referenceCount = System.nanoTime(); 
		
		double  timeElapsed;
		double delta = 0;
		
		
		
		while(playActiv){
			final long initLoop = System.nanoTime();
			
			timeElapsed = initLoop - referenceUpdate;
			referenceUpdate =  initLoop;
			
			delta += timeElapsed / NS_PRO_UPDATE;
			
			while (delta >= 1) {
				update();
				delta--;
				
			}
			draw();
			
			if (System.nanoTime()-referenceCount > NS_PRO_SECONDS){
				setTitle("Zombie Paradies 0.1"+" |  "+COUNT_APS+" | "+COUNT_FPS);
				COUNT_APS = "APS: " + aps;
				COUNT_FPS = "FPS: " + fps;
				aps = 0;
				fps = 0;
				referenceCount = System.nanoTime();
			}
			
			
		}
		
	}

	
	
	
	public static boolean isPlayLevelOvercome() {
		return playLevelOvercome;
	}



	public static void setPlayLevelOvercome(boolean playLevelOvercome) {
		play.playLevelOvercome = playLevelOvercome;
	}	
	

	
	
	public static int getPlayLevel() {
		return playLevel;
	}



	public static void setPlayLevel(int playLevel) {
		play.playLevel = playLevel;
	}	
	
	public static void main(String[] args)  {
		
	    
	    
		play play = new play();
		play.init();

	}




}