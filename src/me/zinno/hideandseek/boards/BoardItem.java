package me.zinno.hideandseek.boards;

import java.awt.*;

public interface BoardItem {
	
	boolean isVisible(Dimension viewBox);
	void paint(Graphics g);
	
}