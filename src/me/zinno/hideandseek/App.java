package me.zinno.hideandseek;

import me.zinno.hideandseek.panels.AppPanel;
import me.zinno.hideandseek.updaters.AppRunner;

import javax.swing.*;
import java.util.function.Function;

public class App extends JFrame {
	
	private final AppPanel appPanel;
	private final AppRunner appRunner;
	private final ColorScheme colorScheme;
	
	public App(Function<App, AppRunner> runnerCreator, Function<App, AppPanel> panelCreator, ColorScheme colorScheme, int refreshRate) {
		createDefaultSettings();
		this.colorScheme = colorScheme;
		this.appRunner = runnerCreator.apply(this);
		this.appPanel = panelCreator.apply(this);
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
	
	public ColorScheme getColorScheme() {
		return colorScheme;
	}
	
	public AppPanel getAppPanel() {
		return appPanel;
	}
	
	public AppRunner getAppRunner() {
		return appRunner;
	}
}
