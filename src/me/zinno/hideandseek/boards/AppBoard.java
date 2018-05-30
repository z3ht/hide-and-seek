package me.zinno.hideandseek.boards;

import me.zinno.hideandseek.App;
import me.zinno.hideandseek.player.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class AppBoard {
	
	private App app;
	private Player player;
	private List<BoardItem> boardItemList;
	private Dimension boardSize;
	
	public AppBoard(App app, Function<Dimension, Player> playerCreator) {
		this.app = app;
		this.boardSize = new Dimension(10000, 10000);
		this.player = playerCreator.apply(boardSize);
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
		
		drawBackground(g2d);
		for(BoardItem item : boardItemList)
			if(item.isVisible(app.getToolkit().getScreenSize()))
				item.paint(g2d);
		
		g2d.dispose();
	}
	
	public void drawBackground(Graphics2D g2d) {
		g2d.setColor(new Color(230, 230, 230));
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
}
