package me.zinno.hideandseek.boards.border;

import me.zinno.hideandseek.App;

import java.awt.*;

public class SquareBorder implements AppBorder {
	
	private Dimension boardSize;
	private App app;
	
	public SquareBorder(App app) {
		this.app = app;
		this.boardSize = new Dimension(3000, 2000);
	}
	
	@Override
	public Point getPlayerStartPos() {
		return new Point(boardSize.width/2, boardSize.height/2);
	}
	
	@Override
	public Dimension getBorder() {
		return boardSize;
	}
	
	@Override
	public void setBoardSize(Dimension boardSize) {
		this.boardSize = boardSize;
	}
	
	@Override
	public Point checkLocation(Point desiredLocation) {
		desiredLocation.setLocation(
				Math.max(0, desiredLocation.x),
				Math.max(0, desiredLocation.y)
		);
		desiredLocation.setLocation(
				Math.min(desiredLocation.x, boardSize.width),
				Math.min(desiredLocation.y, boardSize.height)
		);
		return desiredLocation;
	}
	
	@Override
	public void paint(Graphics2D g2D) {
		Point playerLoc = app.getAppPanel().getBoard().getPlayer().getLocation();
		if(isVisible(playerLoc, app.getSize())) {
			Color background = app.getColorScheme().getBackground();
			g2D.setColor(new Color(background.getRed() - 15, background.getGreen() - 15, background.getBlue() - 15));
			g2D.fillRect(0, 0, app.getWidth(), app.getHeight());
			g2D.setColor(background);
			// knawlage
			g2D.fillRect(
					Math.max(0, app.getWidth()/2 - (boardSize.width - playerLoc.x)),
					Math.max(0, app.getHeight()/2 - (boardSize.height - playerLoc.y)),
					Math.min(app.getWidth()/2, playerLoc.x) + Math.min(app.getWidth()/2, boardSize.width - playerLoc.x), //
					Math.min(app.getHeight()/2, boardSize.height - playerLoc.y) + Math.min(app.getHeight()/2, playerLoc.y)
			);
		}
	}
	
	private boolean isVisible(Point location, Dimension viewBox) {
		return location.x + viewBox.width/2 > boardSize.width ||
				location.x - viewBox.width/2 < 0 ||
				location.y + viewBox.height/2 > boardSize.height ||
				location.y - viewBox.height/2 < 0;
	}
	
}
