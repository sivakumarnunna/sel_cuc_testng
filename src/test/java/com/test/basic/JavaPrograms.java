package com.test.basic;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class JavaPrograms {
	public static void main(String[] args) {
		reverseString("I love india");
		reverseStringPreserveSpaces("I love india");
		getSecondHighest(new int[] { 23, 44, 555, 4444, 55, 55534543, 4446 });
		getLastnonrepeatedCharacter("I love india");
		getCharCount("I love india");
		reverseNumber(534535);
		bubbleSort(new int[] { 23, 44, 555, 4444, 55, 55534543, 4446 });

	}

	/*
	 * // Java program to Reverse a String using swapping
	 */
	public static String reverseString(String input) {
		char[] chars = input.toCharArray();
		int start = 0;
		int end = input.length() - 1;
		String reverse = "";
		while (start < end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
		reverse = String.valueOf(chars);
		System.out.println(reverse);
		return reverse;
	}

	/*
	 * Reverse a string preserving spaces
	 */
	public static String reverseStringPreserveSpaces(String input) {
		char[] chars = input.toCharArray();
		int start = 0;
		int end = input.length() - 1;
		String reverse = "";
		while (start < end) {
			if (chars[start] == ' ') {
				start++;
				continue;
			} else if (chars[end] == ' ') {
				end--;
				continue;
			} else {
				char temp = chars[start];
				chars[start] = chars[end];
				chars[end] = temp;
				start++;
				end--;
			}
		}
		reverse = String.valueOf(chars);
		System.out.println(reverse);
		return reverse;
	}

	/*
	 * Get Second highest Number from given Array of integers
	 */
	public static int getSecondHighest(int[] numbers) {
		int highest = Integer.MIN_VALUE;
		int secondhighest = Integer.MIN_VALUE;
		for (int i : numbers) {
			if (i > highest) {
				secondhighest = highest;
				highest = i;
			} else if (i > secondhighest && i < highest) {
				secondhighest = i;
			}
		}
		System.out.println("Second highest number in the given array is :: " + secondhighest);
		return secondhighest;
	}

	/*
	 * Find the last non repeated character from a given string.
	 */
	public static String getLastnonrepeatedCharacter(String input) {
		int lenght = input.length();
		int[] chars = new int[255];

		for (int i = 0; i < lenght; i++) {
			char ch = input.charAt(i);
			chars[ch]++;
		}
		for (int i = lenght - 1; i >= 0; i--) {
			char ch = input.charAt(i);
			if (chars[ch] == 1) {
				System.out.println(ch + " ::  is the last non repeated character");
				return String.valueOf(ch);
			}
		}
		System.out.println("All the charaters are repeated in the given string");
		return "All the charaters are repeated in the given string";
	}

	/*
	 * Reverse a given number.
	 */
	public static int reverseNumber(int number) {
		int reverse = 0;
		while (number > 0) {
			reverse = reverse * 10;
			reverse = reverse + number % 10;
			number = number / 10;
		}
		System.out.println(reverse);
		return reverse;
	}

	// Count of each character in a given string
	public static Map<Character, Integer> getCharCount(String input) {
		Map<Character, Integer> result = new HashMap<Character, Integer>();
		int length = input.length();
		for (int i = 0; i < length; i++) {
			char ch = input.charAt(i);
			if (result.containsKey(ch)) {
				result.put(ch, result.get(ch) + 1);
			} else {
				result.put(ch, 1);
			}

		}

		for (char ch : result.keySet()) {
			System.out.println(ch + " got repeated" + result.get(ch) + " times");
		}
		return result;
	}
	
	// bubble sort any array
	
	public static int[] bubbleSort(int[] numbers) {
		
		int totalnumbers = numbers.length;
		for(int i=0;i<totalnumbers;i++) {
			for(int j=0;j<totalnumbers-i-1;j++) {
				if(numbers[j]>numbers[j+1]) {
					int temp = numbers[j];
					numbers[j]=numbers[j+1];
					numbers[j+1]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(numbers));
		return numbers;
		
		
	}

}