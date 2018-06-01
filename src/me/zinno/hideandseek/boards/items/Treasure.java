package me.zinno.hideandseek.boards.items;

import me.zinno.hideandseek.App;
import me.zinno.hideandseek.boards.items.BoardItem;

import java.awt.*;

public class Treasure implements BoardItem {
	
	private App app;
	private Point location;
	private Dimension size;
	
	public Treasure(App app) {
		this(
				app,
				new Point(
						(int) (app.getAppPanel().getBoard().getBorder().getBorder().getWidth()*Math.random()),
						(int) (app.getAppPanel().getBoard().getBorder().getBorder().getHeight()*Math.random())
				),
				new Dimension(250, 250)
		);
	}
	
	public Treasure(App app, Point location, Dimension size) {
		this.app = app;
		this.location = location;
		this.size = size;
	}
	
	@Override
	public void paint(Graphics2D g2d) { // Called after board determines item is visible
		int borderSize = 20;
		Point playerLoc = app.getAppPanel().getBoard().getPlayer().getLocation();
		g2d.setColor(app.getColorScheme().getPrimary());
		g2d.fillRect(location.x - size.width/2, location.y - size.height/2, size.width, size.height);
		g2d.setColor(app.getColorScheme().getTertiary());
		g2d.fillRect(location.x - size.width/2 + borderSize/2, location.y - size.height/2 + borderSize/2, );
	}
	
	@Override
	public boolean isVisible(Point playerLoc, Dimension viewBox) {
		return playerLoc.x + viewBox.width/2 + size.width/2 > location.x ||
				playerLoc.x - viewBox.width/2 - size.width/2 < location.x ||
				playerLoc.y + viewBox.height/2 + size.height/2 > location.y ||
				playerLoc.y - viewBox.height/2 - size.height/2 < location.y;
	}
	
}
