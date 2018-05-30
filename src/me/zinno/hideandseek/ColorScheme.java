package me.zinno.hideandseek;

import java.awt.*;

public class ColorScheme {
	
	private Color primary;
	private Color secondary;
	private Color tertiary;
	
	public ColorScheme(Color primary, Color secondary, Color tertiary) {
		this.primary = primary;
		this.secondary = secondary;
		this.tertiary = tertiary;
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
	
}
