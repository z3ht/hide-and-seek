package me.zinno.hideandseek.boards.items;

import java.awt.*;

public interface BoardItem {
	
	boolean isVisible(Point playerLoc, Dimension viewBox);
	
	void paint(Graphics2D g2d);
	
	boolean test(Point playerLoc);
	
	
}
