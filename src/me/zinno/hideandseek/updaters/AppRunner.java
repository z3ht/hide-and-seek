package me.zinno.hideandseek.updaters;

import me.zinno.hideandseek.App;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class AppRunner implements Runnable {
	
	private final JFrame game;
	private final int threadSpeed;
	private final Set<Updatable> updatableSet;
	
	public AppRunner(Integer threadSpeed, App game) {
		this.game = game;
		this.threadSpeed = threadSpeed;
		this.updatableSet = new HashSet<>();
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
	
	public synchronized void onRun() {
		game.repaint();
		for(Updatable updatable : updatableSet)
			updatable.update();
	}
	
	public synchronized void onException(Exception e) {
		e.printStackTrace();
	}
	
	public synchronized void onDisable() {
	
	}
	
	public void addUpdatable(Updatable updatable) {
		updatableSet.add(updatable);
	}
	
	public void delUpdatable(Updatable updatable) {
		updatableSet.remove(updatable);
	}
	
}
