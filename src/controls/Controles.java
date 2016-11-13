package controls;


import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import zombieParadies.Pantalla;



public final class Controles   implements KeyListener{




	private final static int numeroTeclas = 120;
	private final boolean[] teclas = new boolean[numeroTeclas];
	
	public boolean salir;
	public boolean arriba;
	public boolean abajo;
	public boolean izquierda;
	public boolean derecha;
	public boolean centrar;
	
	public boolean centrado = false;
	
	private int velocidad=8;
	
	private int actualRatonX;
	private int actualRatonY;
	
	private int scrollX=0;
	private int scrollY=0;


	private int anteriorRatonX;
	private int anteriorRatonY;

	




	public void actualizar(int Rx, int Ry){

		
		salir = teclas[KeyEvent.VK_ESCAPE];
		arriba = teclas[KeyEvent.VK_UP];
		abajo = teclas[KeyEvent.VK_DOWN];
		izquierda = teclas[KeyEvent.VK_LEFT];
		derecha = teclas[KeyEvent.VK_RIGHT];
		centrar = teclas[KeyEvent.VK_C];
		

		
		this.scrollX = Rx;
		this.scrollY = Ry;

		
		

	
		
	}



	public void posicionRaton(Pantalla pantalla){
		
		
		actualRatonX=anteriorRatonX;
		actualRatonY=anteriorRatonY;
		
	}
	



	public int getVelocidad() {
		return velocidad;
	}
	
	public int getActualRatonX() {
	        return actualRatonX;
	 }
	 

	  public int getActualRatonY() {
	        return actualRatonY;
	    }

	
	
	@Override
	public void keyTyped(KeyEvent e) {	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		teclas[e.getKeyCode()] = true;
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		teclas[e.getKeyCode()] = false;
		
	}

	public boolean isCentrado() {
		return centrado;
	}



	
	public void mouseMoved(MouseEvent e) {
	
		
		
	}




	public int getRx() {
	    return scrollX;
	}

	public int getRy() {
	    return scrollY;
	}




	

	

}
