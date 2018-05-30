package me.zinno.hideandseek.boards;

import me.zinno.hideandseek.App;
import me.zinno.hideandseek.player.Player;

import java.awt.*;

public class HideAndSeekBoard extends AppBoard {
	
	
	public HideAndSeekBoard(App app) {
		super(app, boardSize -> new Player(app, boardSize));
	}
}
