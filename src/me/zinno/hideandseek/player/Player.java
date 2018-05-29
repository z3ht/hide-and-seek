package me.zinno.hideandseek.player;

import me.zinno.hideandseek.App;
import me.zinno.hideandseek.boards.BoardItem;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements BoardItem, KeyListener {
	
	private App app;
	private Point location;
	private Point playerSize;
	private int[] upTriggerKeys;
	private int[] downTriggerKeys;
	private int[] leftTriggerKeys;
	private int[] rightTriggerKeys;
	
	public Player(App app) {
		this.app = app;
		Dimension boardSize = app.getAppPanel().getBoard().getBoardSize();
		this.location = new Point((int) boardSize.getWidth()/2, (int) boardSize.getHeight()/2);
		this.playerSize = new Point(300, 300);
	}
	
	@Override
	public boolean isVisible(Dimension viewBox) {
		return true;
	}
	
	@Override
	public void paint(Graphics g) { // Only called after board determines the item is visible
		g.fillOval(
				(int) (app.getSize().getWidth() - this.playerSize.x)/2,
				(int) (app.getSize().getHeight() + this.playerSize.y)/2,
				this.playerSize.x,
				this.playerSize.y
		);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	
	}
	
	@Override
	public void keyTyped(KeyEvent e) {} // We don't like to talk about this one...
	
	public Point getLocation() {
		return location;
	}
}
