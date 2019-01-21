package com.mayaliu.aoc2018;

import java.util.HashSet;

public class Day1b {
	public static void main(String args[]) throws Exception {
		if (args.length <= 0) {
			throw new Exception("No input detected!");
		}
		
		int currentFrequency = 0;
		int firstRepeatedFrequency = 0;
		boolean firstRepeat = false;
		
		HashSet<Integer> previousFrequencies = new HashSet<Integer>();
		
		while (!firstRepeat) {
			for(String value : args) {
				int intValue = Integer.parseInt(value);
				currentFrequency += intValue;
	
				if (previousFrequencies.contains(currentFrequency)) {
					System.out.println("The first repeated frequency is " + currentFrequency);
					firstRepeat = true;
					break;
				} else {
					previousFrequencies.add(currentFrequency);
				}
			}
		}
		
	}
}