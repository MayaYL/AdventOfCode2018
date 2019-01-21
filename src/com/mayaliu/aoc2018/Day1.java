package com.mayaliu.aoc2018;

import java.util.HashSet;

/**
 * Day 2 of the 2018 Advent of Code.
 * 
 * @author MayaYL
 */
public class Day1 {
	public static void main(String args[]) throws Exception {
		if (args.length <= 0) {
			throw new Exception("No input detected!");
		}
		
		int newFrequency = part1(args);
		System.out.println("The new frequency is " + newFrequency);

		int firstRepeatedFrequency = part2(args);
		System.out.println("The first repeated is " + firstRepeatedFrequency);
	}
	
	/**
	 * Find the new frequency given an array of changes in frequency.
	 * 
	 * @param args The array of strings representing changes in frequency.
	 * @return The new frequency.
	 */
	private static int part1(String args[]) {
		int newFrequency = 0;
		
		for(String value : args) {
			int intValue = Integer.parseInt(value);
			newFrequency += intValue;
		}
		
		return newFrequency;
	}
	
	/**
	 * Finds the first repeated frequency when the array of changes is applied
	 * repeatedly.
	 * 
	 * @param args The array of strings representing changes in frequency.
	 * @return The first repeated frequency.
	 */
	private static int part2(String args[]) {
		int firstRepeatedFrequency = 0;
		int currentFrequency = 0;
		boolean firstRepeat = false;
		HashSet<Integer> previousFrequencies = new HashSet<Integer>();
		
		while (!firstRepeat) {
			for(String value : args) {
				int intValue = Integer.parseInt(value);
				currentFrequency += intValue;
	
				if (previousFrequencies.contains(currentFrequency)) {
					firstRepeatedFrequency = currentFrequency;
					// Break out of the outer while loop.
					firstRepeat = true;
					// Break out of the inner for loop.
					break;
				} else {
					// Keep the running sum of frequency and continue to apply
					// frequency changes.
					previousFrequencies.add(currentFrequency);
				}
			}
		}
		
		return firstRepeatedFrequency;
	}
}