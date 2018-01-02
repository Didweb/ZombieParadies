package controls;



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import zombieParadies.Screen;



public final class Controls   implements KeyListener{




	private final static int numberKeys = 120;
	private final boolean[] keys = new boolean[numberKeys];
	
	public boolean exit;
	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	public boolean center;
	public boolean acelerate;
	
	public boolean dev;
	public boolean devCoor;
	
	public boolean centered = false;
	
	private int speed = 2;
	
	private int direction = 0;
	
	private int currentMouseX;
	private int currentMouseY;
	
	private int scrollX=0;
	private int scrollY=0;


	private int previousMouseX;
	private int previousMouseY;
	
	private boolean inMoving = false;

	private boolean activatedDevCoor = true;
	private boolean activatedDev = true;




	public boolean isMoving() {
		return inMoving;
	}


	public void update(){

		
		exit = keys[KeyEvent.VK_ESCAPE];
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		center = keys[KeyEvent.VK_C];
		acelerate = keys[KeyEvent.VK_A];
		
		dev = keys[KeyEvent.VK_D];
		devCoor = keys[KeyEvent.VK_X];
		actionMovings();
		

	
	}

	



	private void actionMovings(){
		
		
		int currentSpeed = getSpeed();
		if(acelerate){
			currentSpeed += currentSpeed;
		}
		
		
		if(down ){
			scrollY -= currentSpeed;
			direction = 0;
			 
		}
		
		
		if(up ){
			scrollY +=currentSpeed;
			direction = 1;
			
		}
		
		
		
		if(right ){
			scrollX -=currentSpeed;
			direction = 2;
			
		}
		
		
		
		if(left ){
			scrollX +=currentSpeed;
			direction = 3;
			
		}
		
		if(right && up){
			direction = 4;
		}

		
		if(left && up){
			direction = 5;
		}
		
		if(left && down){
			direction = 6;
		}
		
		if(right && down){
			direction = 7;
		}
		
		if(up || down || left || right){
			inMoving = true;
		}  else { inMoving = false; }
		
		if(dev){
			if(isVerDev()) { setVerDev(false); } else { setVerDev(true); }
		}
		
		if(devCoor){
			if(isDevCoor()) { setDevCoor(false); } else { setDevCoor(true); }
		}
		
	}


	public int getDirection() {
		return direction;
	}


	public void positionMouse(Screen screen){
		
		
		currentMouseX = previousMouseX;
		currentMouseY = previousMouseY;
		
	}
	



	public int getSpeed() {
		return speed;
	}
	
	public int getCurrentMouseX() {
	        return currentMouseX;
	 }
	 

	  public int getCurrentMouseY() {
	        return currentMouseY;
	    }

	
	
	@Override
	public void keyTyped(KeyEvent e) {	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

	public boolean isCentrado() {
		return centered;
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
		return activatedDev;
	}



	public void setVerDev(boolean verDev) {
		this.activatedDev = verDev;
	}

	
	public boolean isDevCoor() {
		return activatedDevCoor;
	}


	public void setDevCoor(boolean devCoor) {
		this.activatedDevCoor = devCoor;
	}

	

}
