package me.zinno.hideandseek.boards.items.player;

import me.zinno.hideandseek.App;
import me.zinno.hideandseek.boards.border.AppBorder;
import me.zinno.hideandseek.boards.items.BoardItem;
import me.zinno.hideandseek.boards.items.player.keys.TriggerKeys;
import me.zinno.hideandseek.boards.items.player.movement.Movement;
import me.zinno.hideandseek.updaters.Updatable;
import me.zinno.hideandseek.util.Pair;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class Player implements BoardItem, KeyListener, Updatable {
	
	private App app;
	private Point location;
	private Dimension playerSize;
	private TriggerKeys[] triggerKeysArray;
	private Set<TriggerKeys.Type> triggeredKeysTypeSet;
	
	private Movement movement;
	
	public Player(App app, Point startPos) {
		this.app = app;
		this.location = startPos;
		this.playerSize = new Dimension(100, 100);
		this.triggeredKeysTypeSet = new HashSet<>();
		this.triggerKeysArray = new TriggerKeys[] {
				new TriggerKeys(TriggerKeys.Type.UP, KeyEvent.VK_W, KeyEvent.VK_UP),
				new TriggerKeys(TriggerKeys.Type.DOWN, KeyEvent.VK_S, KeyEvent.VK_DOWN),
				new TriggerKeys(TriggerKeys.Type.LEFT, KeyEvent.VK_A, KeyEvent.VK_LEFT),
				new TriggerKeys(TriggerKeys.Type.RIGHT, KeyEvent.VK_D, KeyEvent.VK_RIGHT)
		};
		
		this.movement = new Movement();
		
		app.getAppRunner().addUpdatable(this);
		
	}
	
	@Override
	public boolean isVisible(Point playerLoct, Dimension viewBox) {
		return true;
	}
	
	@Override
	public void paint(Graphics2D g2d) { // Only called after board determines the item is visible
		int borderSize = 10;
		g2d.setColor(app.getColorScheme().getPrimary());
		g2d.fillOval(
				(int) (app.getWidth() - playerSize.getWidth()) / 2,
				(int) (app.getHeight() - playerSize.getHeight()) / 2,
				playerSize.width,
				playerSize.height
		);
		g2d.setColor(app.getColorScheme().getSecondary());
		g2d.fillOval(
				(int) (app.getSize().getWidth() - playerSize.getWidth() + borderSize) / 2,
				(int) (app.getSize().getHeight() - playerSize.getHeight() + borderSize) / 2,
				playerSize.width - borderSize,
				playerSize.height - borderSize
		);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		for(TriggerKeys triggerKeys : triggerKeysArray)
			for(int triggerKey : triggerKeys.getKeys())
				if(e.getKeyCode() == triggerKey)
					triggeredKeysTypeSet.add(triggerKeys.getKeyType());
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		for(TriggerKeys triggerKeys : triggerKeysArray)
			for(int triggerKey : triggerKeys.getKeys())
				if(e.getKeyCode() == triggerKey)
					triggeredKeysTypeSet.remove(triggerKeys.getKeyType());
	}
	
	public void update() {
		Pair<Integer, Integer> velChange = movement.calculateVelChange(triggeredKeysTypeSet);
		Point desiredLocation = new Point(
				location.x - velChange.getLeft(),
				location.y + velChange.getRight()
		);
		AppBorder border = app.getAppPanel().getBoard().getBorder();
		this.location = (border.exists()) ? border.checkLocation(desiredLocation) : desiredLocation;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {} // We don't like to talk about this one...
	
	public Point getLocation() {
		return location;
	}
	
	public Dimension getSize() {
		return playerSize;
	}
}
