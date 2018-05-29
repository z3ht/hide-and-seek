package me.zinno.hideandseek.updaters;

import me.zinno.hideandseek.App;

import javax.swing.*;

public class AppRunner implements Runnable {
	
	private final JFrame game;
	private final int threadSpeed;
	
	public AppRunner(Integer threadSpeed, App game) {
		this.game = game;
		this.threadSpeed = threadSpeed;
	}
	
	public final void run() {
		onEnable();
		while(true) {
			try {
				Thread.sleep(threadSpeed);
				onRun();
			} catch (Exception e) {
				onException(e);
				break;
			}
		}
		onDisable();
	}
	
	public synchronized void onEnable() {}
	
	public synchronized void onRun() {game.repaint();}
	
	public synchronized void onException(Exception e) {
	
	}
	
	public synchronized void onDisable() {
	
	}
	
}
