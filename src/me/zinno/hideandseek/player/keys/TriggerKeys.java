package me.zinno.hideandseek.player.keys;

public class TriggerKeys {
	
	private TriggerKeys.Type keyType;
	private int[] keys;
	
	public TriggerKeys(TriggerKeys.Type keyType, int... keys) {
		this.keyType = keyType;
		this.keys = keys;
	}
	
	public TriggerKeys.Type getKeyType() {
		return keyType;
	}
	
	public int[] getKeys() {
		return keys;
	}
	
	public enum Type {
		UP,
		LEFT,
		RIGHT,
		DOWN
	}
	
}
