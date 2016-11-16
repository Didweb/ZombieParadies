package controls;



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	public boolean acelera;
	
	public boolean dev;
	public boolean devCoor;
	
	public boolean centrado = false;
	
	private int velocidad=2;
	
	private int direccion = 0;
	
	private int actualRatonX;
	private int actualRatonY;
	
	private int scrollX=0;
	private int scrollY=0;


	private int anteriorRatonX;
	private int anteriorRatonY;
	
	private boolean enMovimiento = false;

	private boolean activarDevCoor = true;
	private boolean activarDev = true;




	public boolean isEnMovimiento() {
		return enMovimiento;
	}


	public void actualizar(){

		
		salir = teclas[KeyEvent.VK_ESCAPE];
		arriba = teclas[KeyEvent.VK_UP];
		abajo = teclas[KeyEvent.VK_DOWN];
		izquierda = teclas[KeyEvent.VK_LEFT];
		derecha = teclas[KeyEvent.VK_RIGHT];
		centrar = teclas[KeyEvent.VK_C];
		acelera = teclas[KeyEvent.VK_A];
		
		dev = teclas[KeyEvent.VK_D];
		devCoor = teclas[KeyEvent.VK_X];
		accionMovimientos();
		

	
	}

	



	private void accionMovimientos(){
		
		
		int velocidadActual = getVelocidad();
		if(acelera){
			velocidadActual +=velocidadActual;
		}
		
		
		if(abajo ){
			scrollY -=velocidadActual;
			direccion = 0;
			 
		}
		
		
		if(arriba ){
			scrollY +=velocidadActual;
			direccion = 1;
			
		}
		
		
		
		if(derecha ){
			scrollX -=velocidadActual;
			direccion = 2;
			
		}
		
		
		
		if(izquierda ){
			scrollX +=velocidadActual;
			direccion = 3;
			
		}
		
		if(derecha && arriba){
			direccion = 4;
		}

		
		if(izquierda && arriba){
			direccion = 5;
		}
		
		if(izquierda && abajo){
			direccion = 6;
		}
		
		if(derecha && abajo){
			direccion = 7;
		}
		
		if(arriba || abajo || izquierda || derecha){
			enMovimiento = true;
		}  else { enMovimiento = false; }
		
		if(dev){
			if(isVerDev()) { setVerDev(false); } else { setVerDev(true); }
		}
		
		if(devCoor){
			if(isDevCoor()) { setDevCoor(false); } else { setDevCoor(true); }
		}
		
	}


	public int getDireccion() {
		return direccion;
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







	public int getRx() {
	    return scrollX;
	}

	public int getRy() {
	    return scrollY;
	}

	
	public int getScrollY() {
		return scrollY;
	}


	public void setScrollY(int scrollY) {
		this.scrollY = scrollY;
	}


	public int getScrollX() {
		return scrollX;
	}


	public void setScrollX(int scrollX) {
		this.scrollX = scrollX;
	}


	public  boolean isVerDev() {
		return activarDev;
	}



	public void setVerDev(boolean verDev) {
		this.activarDev = verDev;
	}

	
	public boolean isDevCoor() {
		return activarDevCoor;
	}


	public void setDevCoor(boolean devCoor) {
		this.activarDevCoor = devCoor;
	}

	

}
