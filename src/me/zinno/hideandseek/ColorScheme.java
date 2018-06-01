package me.zinno.hideandseek;

import java.awt.*;

public class ColorScheme {
	
	private Color primary;
	private Color secondary;
	private Color tertiary;
	
	private Color background;
	
	public ColorScheme(Color primary, Color secondary, Color tertiary, Color background) {
		this.primary = primary;
		this.secondary = secondary;
		this.tertiary = tertiary;
		this.background = background;
	}
	
	public Color getPrimary() {
		return primary;
	}
	
	public void setPrimary(Color primary) {
		this.primary = primary;
	}
	
	public Color getSecondary() {
		return secondary;
	}
	
	public void setSecondary(Color secondary) {
		this.secondary = secondary;
	}
	
	public Color getTertiary() {
		return tertiary;
	}
	
	public void setTertiary(Color tertiary) {
		this.tertiary = tertiary;
	}
	
	public void setBackground(Color background) {
		this.background = background;
	}
	
	public Color getBackground() {
		return background;
	}
}
