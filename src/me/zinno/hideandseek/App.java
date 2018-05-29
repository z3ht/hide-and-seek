package me.zinno.hideandseek;

import me.zinno.hideandseek.panels.AppPanel;
import me.zinno.hideandseek.updaters.AppRunner;

import javax.swing.*;
import java.util.function.Function;

public class App extends JFrame {
	
	private final AppPanel appPanel;
	private final AppRunner appRunner;
	
	public App(Function<App, AppRunner> runnerCreator, Function<App, AppPanel> panelCreator, int refreshRate) {
		createDefaultSettings();
		this.appPanel = panelCreator.apply(this);
		this.appRunner = runnerCreator.apply(this);
		add(appPanel);
	}
	
	
	void createDefaultSettings() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void start() {
		setVisible(true);
		new Thread(appRunner).run();
	}
	
	public AppPanel getAppPanel() {
		return appPanel;
	}
	
}
