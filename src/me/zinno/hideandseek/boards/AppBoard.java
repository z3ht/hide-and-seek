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
	
	public AppBoard(App app, Player player) {
		this.app = app;
		this.boardSize = new Dimension(10000, 10000);
		this.player = player;
		this.boardItemList = new ArrayList<>();
	}
	
	public void paint(Graphics g) {
		drawBackground(g);
		for(BoardItem item : boardItemList)
			if(item.isVisible(app.getToolkit().getScreenSize()))
				item.paint(g);
	}
	
	public void drawBackground(Graphics g) {
		g.setColor(new Color(220, 220, 220));
		int fillSize = 2;
		int seperationDist = 36;
		// horizontal lines
		for(int y = (int) getPlayer().getLocation().getY() % seperationDist; y < app.getSize().height; y += seperationDist)
			g.fillRect(0, y, app.getSize().width, fillSize);
		
		// vertical lines
		for(int x = (int) getPlayer().getLocation().getX() % seperationDist;x < app.getSize().width; x += seperationDist)
			g.fillRect(x, 0, fillSize, app.getSize().height);
	}
	
	public void addBoardItem(BoardItem item) {
		boardItemList.add(item);
	}
	
	public void delBoardItem(BoardItem item) {
		boardItemList.remove(item);
	}
	
	public Dimension getBoardSize() {
		return boardSize;
	}
	
	public List<BoardItem> getBoardItemList() {
		return boardItemList;
	}
	
	public Player getPlayer() {
		return player;
	}
}
