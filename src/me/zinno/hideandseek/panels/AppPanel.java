package me.zinno.hideandseek.panels;

import me.zinno.hideandseek.App;
import me.zinno.hideandseek.boards.AppBoard;

import javax.swing.*;
import java.awt.*;

public abstract class AppPanel extends JPanel {
	
	private App app;
	private AppBoard board;
	
	public AppPanel(App app, AppBoard appBoard) {
		this.app = app;
		this.board = appBoard;
		
		createDefaultSettings();
		
		addKeyListener(board.getPlayer());
	}
	
	private void createDefaultSettings() {
		setBackground(new Color(248,248,248));
		setFocusable(true);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		board.paint(g);
	}
	
	public AppBoard getBoard() {
		return board;
	}
}
