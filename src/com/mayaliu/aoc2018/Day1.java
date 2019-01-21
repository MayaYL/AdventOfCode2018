package com.mayaliu.aoc2018;

public class Day1 {
	public static void main(String args[]) throws Exception {
		if (args.length <= 0) {
			throw new Exception("No input detected!");
		}
		
		int currentFrequency = 0;
		
		for(String value : args) {
			int intValue = Integer.parseInt(value);
			currentFrequency += intValue;
		}
		
		System.out.println("The new frequency is " + currentFrequency);
	}
}