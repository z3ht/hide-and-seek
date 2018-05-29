package me.zinno.hideandseek.panels;

import me.zinno.hideandseek.App;
import me.zinno.hideandseek.boards.HideAndSeekBoard;

public class HideAndSeekPanel extends AppPanel {
	
	public HideAndSeekPanel(App app) {
		super(app, new HideAndSeekBoard(app));
	}

}
