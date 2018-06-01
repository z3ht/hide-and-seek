package me.zinno.hideandseek.boards.border;

import java.awt.*;

public interface AppBorder {
	
	Point getPlayerStartPos();
	
	void setBoardSize(Dimension boardSize);
	
	Dimension getBorder();
	
	Point checkLocation(Point desiredLocation);
	
	void paint(Graphics2D g2d);
	
	default boolean exists() {
		return true;
	}
	
}
