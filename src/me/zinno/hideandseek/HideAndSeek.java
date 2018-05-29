package me.zinno.hideandseek;

import me.zinno.hideandseek.panels.HideAndSeekPanel;
import me.zinno.hideandseek.updaters.AppRunner;

public class HideAndSeek extends App {
	
	public HideAndSeek(int refreshRate) {
		super(
				app -> new AppRunner(10, app),
				app -> new HideAndSeekPanel(app),
				refreshRate
		);
	}
	
	@Override
	void createDefaultSettings() {
		super.createDefaultSettings();
		setTitle("Hide and Seek");
		setIconImage(this.getToolkit().getImage(this.getClass().getResource("treasure.png")));
		setUndecorated(true);
	}
	
	public static void main(String[] args) {
		App game = new HideAndSeek(10);
		game.start();
	}
}