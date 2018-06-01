package me.zinno.hideandseek.boards;

import me.zinno.hideandseek.App;
import me.zinno.hideandseek.boards.items.player.Player;

public class HideAndSeekBoard extends AppBoard {
	
	
	public HideAndSeekBoard(App app) {
		super(app, startPos -> new Player(app, startPos));
	}
}
