package zombieParadies;




import javax.swing.JFrame;

import zombieParadies.Pantalla;
import zombieParadies.Niveles;
import controls.Controles;
import factoryTile.RecMapa;





public class Juego  extends JFrame implements Runnable{
 
	/**
	* Centro del Juego creación de loop del juego.
    */
    private static final long serialVersionUID = 2997131868080903015L;
    
	private static boolean juegoActivo = false;
	private static int juegoNivel = 0;
	private static boolean juegoNivelSuperado = false;
	
	public static final int ANCHO_PANTALLA = 1400;
	public static final int ALTO_PANTALLA = 1250;



	private static Thread thread;

	private static String  CONTADOR_APS = "";
	private static String  CONTADOR_FPS = "";
	
	private static int aps=0;
	private static int fps = 0;
	

	private static Pantalla pantalla;
	private static Controles controles;

	private static boolean verDev = true;
	
	private Juego() {
		
		
		
		pantalla = new Pantalla();
		controles = new Controles();
		
		addKeyListener(controles);
		setSize(1400,1250);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setFocusable(true);
		
		add(pantalla);
		setVisible(true);
		
		
	}
	

	
	private synchronized void iniciar(){
		
		juegoActivo = true;
		Niveles.servidorDeNiveles();

		thread = new Thread(this, "Graficos");
		thread.start();
	}
	




	private void actualizar(){	
		
		controles.actualizar();
		pantalla.actualizar(controles.getScrollX(), controles.getScrollY());
		
		if(controles.dev){
			if(isVerDev()) { setVerDev(false); } else { setVerDev(true); }
			}
		
		if(juegoNivelSuperado){
			Niveles.servidorDeNiveles(juegoNivel);
		}
		
		aps ++;
	}
	
	private void mostrar(){
		
		repaint();
		
		fps ++;
	}
	
	
	
	@Override
	public void run() {
		final int NS_POR_SEGUNDO = 1000000000;
		final byte APS_OBJETIVO = 60;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
		
		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime(); 
		
		double  timepoTranscurrido;
		double delta = 0;
		
		
		
		while(juegoActivo){
			final long inicioBucle = System.nanoTime();
			
			timepoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion =  inicioBucle;
			
			delta += timepoTranscurrido / NS_POR_ACTUALIZACION;
			
			while (delta >= 1) {
				actualizar();
				delta--;
				
			}
			mostrar();
			
			if (System.nanoTime()-referenciaContador > NS_POR_SEGUNDO){
				setTitle("Zombie Paradies 0.1"+" |  "+CONTADOR_APS+" | "+CONTADOR_FPS);
				CONTADOR_APS = "APS: " + aps;
				CONTADOR_FPS = "FPS: " + fps;
				aps = 0;
				fps = 0;
				referenciaContador = System.nanoTime();
			}
			
			
		}
		
	}

	
	
	
	public static boolean isJuegoNivelSuperado() {
		return juegoNivelSuperado;
	}



	public static void setJuegoNivelSuperado(boolean juegoNivelSuperado) {
		Juego.juegoNivelSuperado = juegoNivelSuperado;
	}	
	

	
	
	public static int getJuegoNivel() {
		return juegoNivel;
	}



	public static void setJuegoNivel(int juegoNivel) {
		Juego.juegoNivel = juegoNivel;
	}	
	
	public static void main(String[] args)  {
		
	    
	    
		Juego juego = new Juego();
		juego.iniciar();

	}



	public static boolean isVerDev() {
		return verDev;
	}



	public void setVerDev(boolean verDev) {
		this.verDev = verDev;
	}

}