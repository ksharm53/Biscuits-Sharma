package com.biscuit.models.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Points {

	_0PT(0), _1PT(1), _2PT(2), _3PT(3), _5PT(5), _8PT(8), _13PT(13), _21PT(21);
	
	private final int value;

	public static List<String> values = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "5", "8", "13", "21"));
	
	private Points(int value) {
		this.value = value;
	}


	public int getValue() {
		return value;
	}
}
