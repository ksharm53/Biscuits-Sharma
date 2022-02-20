package com.biscuit.utility;

import java.util.Arrays;
import java.util.List;

public final class Utility {

	/**
	 * Snippet to validate input User story point added. It should be in fibbonacci series and must be from defined list.
	 * @param line
	 */
	public static void validateInput(String line) {

		List<String> values = Arrays.asList("0", "1", "2", "3", "5", "8", "13", "21");
		if(! values.contains(line)) {
			throw new IllegalArgumentException();	
		}

	}
}
