package me.zinno.hideandseek.items;

import me.zinno.hideandseek.App;
import me.zinno.hideandseek.boards.BoardItem;

import java.awt.*;

public class Treasure implements BoardItem {
	
	private App app;
	
	public Treasure(App app) {
		this.app = app;
	}
	
	@Override
	public boolean isVisible(Dimension viewBox) {
		return false;
	}
	
	@Override
	public void paint(Graphics g) {
	
	}
}
