package me.zinno.hideandseek.boards.items;

import java.awt.*;

public interface BoardItem {
	
	boolean isVisible(Point playerLoc, Dimension viewBox);
	
	void paint(Graphics2D g2d);
	
	static Point locationRelativeToAnchor(Point point, Point anchor) {
		Point returnVal = new Point(
				point.x - anchor.x,
				point.y - anchor.y
		);
		return returnVal;
	}
	
}
