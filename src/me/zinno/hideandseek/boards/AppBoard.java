package me.zinno.hideandseek.boards;

import me.zinno.hideandseek.App;
import me.zinno.hideandseek.boards.border.AppBorder;
import me.zinno.hideandseek.boards.border.SquareBorder;
import me.zinno.hideandseek.boards.items.BoardItem;
import me.zinno.hideandseek.boards.items.player.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class AppBoard {
	
	private App app;
	private Player player;
	private List<BoardItem> boardItemList;
	private AppBorder border;
	
	public AppBoard(App app, Function<Point, Player> playerCreator) {
		this.app = app;
		this.border = new SquareBorder(app);
		this.player = playerCreator.apply(border.getPlayerStartPos());
		this.boardItemList = new ArrayList<>();
		
		addBoardItem(player);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		
		RenderingHints hints = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON
		);
		
		g2d.setRenderingHints(hints);
		
		border.paint(g2d);
		
		drawBackground(g2d);
		for(BoardItem item : boardItemList)
			if(item.isVisible(player.getLocation(), app.getSize()))
				item.paint(g2d);
		
		g2d.dispose();
	}
	
	public void drawBackground(Graphics2D g2d) {
		Color background = app.getColorScheme().getBackground();
		g2d.setColor(new Color(background.getRed() - 30, background.getGreen() - 30, background.getBlue() - 30));
		int fillSize = 1;
		int separationDist = 25;
		
		// horizontal lines
		for(int y = (int) getPlayer().getLocation().getY() % separationDist; y < app.getSize().height; y += separationDist)
			g2d.fillRect(0, y, app.getSize().width, fillSize);
		
		// vertical lines
		for(int x = (int) getPlayer().getLocation().getX() % separationDist;x < app.getSize().width; x += separationDist)
			g2d.fillRect(x, 0, fillSize, app.getSize().height);
	}
	
	public void addBoardItem(BoardItem item) {
		boardItemList.add(item);
	}
	
	public void delBoardItem(BoardItem item) {
		boardItemList.remove(item);
	}
	
	public List<BoardItem> getBoardItemList() {
		return boardItemList;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public AppBorder getBorder() {
		return border;
	}
}
