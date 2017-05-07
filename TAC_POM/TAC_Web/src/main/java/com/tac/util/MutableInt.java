package com.tac.util;

public class MutableInt {

	private int value = 1;
	
	public void increment() {
		++value;
	}
	
	public int get() {
		return value;
	}
}
