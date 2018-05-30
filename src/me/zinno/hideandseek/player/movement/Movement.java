package me.zinno.hideandseek.player.movement;

import me.zinno.hideandseek.player.keys.TriggerKeys;
import me.zinno.hideandseek.util.Pair;

import java.util.Set;

public class Movement {
	
	private double maxAccel;
	private double accelIncrement;
	
	private double maxSpeed;
	private double speedIncrement;
	
	private double maxFric;
	private double fricIncrement;
	
	private double yAccel;
	private double xAccel;
	
	private double yVel;
	private double xVel;
	
	private double xFric;
	private double yFric;
	
	public Movement() {
		this(20,
				300,
				1.5,
				1,
				20,
				2
		);
	}
	
	public Movement(double maxAccel, double maxSpeed, double maxFric, double accelIncrement, double speedIncrement, double fricIncrement) {
		this.maxAccel = maxAccel/100;
		this.maxSpeed = maxSpeed/100;
		this.maxFric = maxFric/100;
		this.accelIncrement = accelIncrement/100;
		this.speedIncrement = speedIncrement/100;
		this.fricIncrement = fricIncrement/100;
	}
	
	public Pair calculateVelChange(Set<TriggerKeys.Type> triggeredKeys) { // Have fun journeying into the depths of satan's asshole
		boolean yMoving = (triggeredKeys.contains(TriggerKeys.Type.UP) || triggeredKeys.contains(TriggerKeys.Type.DOWN)) && // Checks for movement
						!(triggeredKeys.contains(TriggerKeys.Type.UP) && triggeredKeys.contains(TriggerKeys.Type.DOWN)); // Makes sure movement is not being cancelled
		boolean xMoving = (triggeredKeys.contains(TriggerKeys.Type.LEFT) || triggeredKeys.contains(TriggerKeys.Type.RIGHT)) && // Checks for movement
				!(triggeredKeys.contains(TriggerKeys.Type.LEFT) && triggeredKeys.contains(TriggerKeys.Type.RIGHT)); // Makes sure movement is not being cancelled
		
		if(yMoving) {
			int yMoveDir = (triggeredKeys.contains(TriggerKeys.Type.UP)) ? 1 : -1;
			if (yAccel * yMoveDir >= 0)
				yAccel += (Math.abs(yAccel) < maxAccel) ? accelIncrement * yMoveDir : 0;
			else
				yAccel = 0;
			this.yVel += (Math.abs(yVel + yAccel) < maxSpeed) ? yAccel : 0;
		} else {
			yFric += (yFric < maxFric) ? fricIncrement : 0;
			yVel -= (yVel > 0) ? yFric : -yFric;
			if(Math.abs(yVel) - speedIncrement < 0)
				yVel = 0;
			yAccel -= (yAccel > 0) ? yFric : -yFric;
			if(Math.abs(yAccel) - accelIncrement < 0)
				yAccel = 0;
		}
		
		if(xMoving) {
			int xMoveDir = (triggeredKeys.contains(TriggerKeys.Type.RIGHT)) ? 1 : -1;
			if (xAccel * xMoveDir >= 0)
				xAccel += (Math.abs(xAccel) < maxAccel) ? accelIncrement * xMoveDir : 0;
			else
				xAccel = 0;
			this.xVel += (Math.abs(xVel + xAccel) < maxSpeed) ? xAccel : 0;
		} else {
			xFric += (xFric < maxFric) ? fricIncrement : 0;
			xVel -= (xVel > 0) ? xFric : -xFric;
			if(Math.abs(xVel) - speedIncrement < 0)
				xVel = 0;
			xAccel -= (xAccel > 0) ? xFric : -xFric;
			if(Math.abs(xAccel) - accelIncrement < 0)
				xAccel = 0;
		}
		
		return new Pair((int) xVel, (int) yVel);
	}
	
}
