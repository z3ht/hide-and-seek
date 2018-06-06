package me.zinno.hideandseek.boards;

import me.zinno.hideandseek.App;
import me.zinno.hideandseek.boards.items.Treasure;
import me.zinno.hideandseek.boards.items.player.Player;

import java.awt.*;

public class HideAndSeekBoard extends AppBoard {
	
	
	public HideAndSeekBoard(App app) {
		super(app, startPos -> new Player(app, startPos));
		for(int c = 0; c < 10; c++) {
			addBoardItem(
					new Treasure(
							app,
							new Point(
									(int)  (Math.random()*super.getBorder().getBorder().width),
									(int) (Math.random()*super.getBorder().getBorder().height)
							),
							new Dimension(
									(int) (Math.random()*250),
									(int) (Math.random()*250)
							)
					)
			);
		}
	}
}
