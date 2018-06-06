package me.zinno.hideandseek.boards.items;

import me.zinno.hideandseek.App;
import me.zinno.hideandseek.boards.AppBoard;
import me.zinno.hideandseek.boards.items.BoardItem;
import me.zinno.hideandseek.updaters.Updatable;

import java.awt.*;

public class Treasure implements BoardItem, Updatable {
	
	private App app;
	private Point location; // center of piece
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
		app.getAppRunner().addUpdatable(this);
	}
	
	@Override
	public void paint(Graphics2D g2d) { // Called after board determines item is visible
		int borderSize = 10;
		AppBoard board = app.getAppPanel().getBoard();
		Point relLoc = BoardItem.locationRelativeToAnchor(
				new Point(
						board.getPlayer().getLocation().x + app.getWidth()/2,
						board.getPlayer().getLocation().y + app.getHeight()/2
				),
				location
		);
		g2d.setColor(app.getColorScheme().getPrimary());
		g2d.fillRect(
				relLoc.x - size.width/2,
				relLoc.y - size.height/2,
				size.width,
				size.height
		);
		g2d.setColor(app.getColorScheme().getTertiary());
		g2d.fillRect(
				relLoc.x - size.width/2 + borderSize/2,
				relLoc.y - size.height/2 + borderSize/2,
				size.width - borderSize,
				size.height - borderSize
		);
	}
	
	@Override
	public boolean isVisible(Point playerLoc, Dimension viewBox) {
		Point relativeLocation = BoardItem.locationRelativeToAnchor(location, playerLoc);
		return Math.abs(relativeLocation.x) < (viewBox.width + size.width)/2 &&
				Math.abs(relativeLocation.y) < (viewBox.height + size.height)/2;
	}
	
	@Override
	public void update() {
		AppBoard board = app.getAppPanel().getBoard();
		Point relLoc = BoardItem.locationRelativeToAnchor(
				location,
				board.getPlayer().getLocation()
		);
		boolean isCollided =
				Math.abs(relLoc.x) < (board.getPlayer().getSize().width/2 + size.width)/2 &&
				Math.abs(relLoc.y) < (board.getPlayer().getSize().height/2 + size.height)/2;
		if(!isCollided)
			return;
		board.delBoardItem(this);
		app.getAppRunner().delUpdatable(this);
	}
}