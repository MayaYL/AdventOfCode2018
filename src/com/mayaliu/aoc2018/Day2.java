package com.mayaliu.aoc2018;

import java.util.HashMap;

/**
 * Day 2 of the 2018 Advent of Code.
 * 
 * @author MayaYL
 */
public class Day2 {
	public static void main(String args[]) {
		int checkSum = partOne(args);
		System.out.println("The checksum is " + checkSum);
		
		String commonLetters = partTwo(args);
		System.out.println("The correct boxes share the letters " + commonLetters);
	}
	
	/**
	 * Find the checksum by multiplying the number of strings with letters that repeat 
	 * exactly twice and the number of strings with letters that repeat exactly three times.
	 * 
	 * @param args The array of argument strings.
	 * 
	 * @return The checksum.
	 */
	private static int partOne(String args[]) {
		int doubleLetter = 0;
		int tripleLetter = 0;
		
		for (String input : args) {
			String trimmedInput = input.trim();
			HashMap<Character, Integer> frequency = new HashMap<Character, Integer>();
			for (char character : trimmedInput.toCharArray()) {
				// If the character is not in the hash, its frequency before inserting
				// right now is 0. Otherwise get its frequency from the hashmap.
				int currentFrequency = frequency.get(character) == null ? 0 : frequency.get(character);
				frequency.put(character, ++currentFrequency);
			}
			
			// If there are any keys that have a value of 2, count it as a string with double letters.
			if(frequency.containsValue(2)) {
				doubleLetter++;
			}
			// If there are any keys that have a value of 3, count it as a string with triple letters.
			if(frequency.containsValue(3)) {
				tripleLetter++;
			}
		}
		
		int checkSum = doubleLetter * tripleLetter;
		return checkSum;
	}
	
	/**
	 * Finds the two strings that differ by only one letter in the same position,
	 * and return the substring with the different letter removed.
	 * 
	 * @param args The array of argument strings.
	 * 
	 * @return The string containing the common letters.
	 */
	private static String partTwo(String args[]) {
		int mismatchedIndex = 0;
		
		for(int outerLoop = 0; outerLoop < args.length; outerLoop++) {		
			String outerString = args[outerLoop].trim();
			// We only need to check strings after where the outer loop value is,
			// because the earlier ones have already been checked in earlier loops.
			for (int innerLoop = outerLoop + 1; innerLoop < args.length; innerLoop++) {
				String innerString = args[innerLoop].trim();
				
				// If the strings are not the same length, skip. Note that is an
				// edge condition that doesn't actually occur for the given input,
				// but it's a quick check just in case input changes in the future.
				if (outerString.length() != innerString.length()) {
					break;
				}
				
				int numCharsDifferent = 0;
				for (int index = 0; index < outerString.length(); index++) {
					if (outerString.charAt(index) != innerString.charAt(index)) {
						numCharsDifferent++;
						mismatchedIndex = index;
					}
					if (numCharsDifferent > 1) {
						// There are too many differences; move on to the next
						// iteration of the inner loop.
						break;
					}
				}

				// We've found our pair of strings; return them and stop
				// searching further. This assumes there is only one pair
				// and it's the first one we can find in the data.
				if (numCharsDifferent == 1) {
					String commonLetters = String.join(
						"",
						outerString.subSequence(0, mismatchedIndex),
						outerString.subSequence(mismatchedIndex + 1, outerString.length())
					);

					return commonLetters.toString();
				}
			}
		}
		// This should never happen, unless there are truly no strings that fit
		// the criteria.
		return "";
	}
}

