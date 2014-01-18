import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Solution of xxx exercise of Coding Challenge
 * Resolved in xxx minutes (of xxx allowed)
 */
class Solution {
	
	static enum SpecialEnum {
		ONE, TWO, THREE;
	}

	static class SpecialObject {
		public int id;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		// Parameters
		int count = in.nextInt(); in.nextLine();
		int count2 = in.nextInt(); in.nextLine();
		List<Object> objectList = readAllObject(in, count, count2);
		
		// Sort
//		Collections.sort();
//		Arrays.sort();
		
		// Compute
		
		// Display
		System.out.println(count);
	}
	
	/**
		Get all objects from a specified number of lines.
		@param in The input scanner
		@param count The number of lines to read
		@return The list of read objects
	*/
	public static List<Object> readAllObject(Scanner in, int count) {
		List<Object> list = new ArrayList<Object>();
		Object obj;
		
		for (int i = 0 ; i < count ; i++) {
			obj = new Object();
			list.add(obj);
		}
		
		return list;
	}
	
	/**
		Find the minimal gap between two-consecutive values in a list.
		@param list The list containing sorted values
		@return The minimum gap of two-consecutive values
	*/
	public static int findMinGap(List<Integer> list) {
		int gap = Integer.MAX_VALUE;
		int size = list.size();
		for (int i = 1 ; i < size ; i++) {
			gap = Math.min(Math.abs(list.get(i) - list.get(i-1)), gap);
		}
		return gap;
	}
	
	/**
		Get an number from a String in French format
		@param source The string to convert
		@return The converted number
		@see Locale
		@see NumberFormat
	*/
	public static Number getFrenchNumber(String source) {
		try {
			return java.text.NumberFormat.getInstance(Locale.FRANCE).parse(source);
		}
		catch (Exception e) {
			return -1;
		}
	}
	
	
	
	public static int readAndFindMaxChronologicalGap(Scanner in, int count) {
		int max = 0;
		int gap = 0;
		int value;
		
		for (int i = 0 ; i < count ; i++) {
			value = in.nextInt();
			
			if (value > max) {
				max = value;
			} else {
				gap = Math.max(gap, (max - value));
			}
		}
		
		return gap * -1;
	}
	
	
	static public long getAverageY(List<Point> list) {
		long sum = 0;
		for (Point p : list)
			sum += p.getY();
		return (sum / list.size());
	}
	
	
	
	public static String join(List<Integer> list, String d) {
		if (list.size() == 0) return "";
		StringBuilder sb = new StringBuilder();
		Boolean isFirst = true;
		for (Integer i : list) {
			if (isFirst)
				isFirst = false;
			else
				sb.append(d);
			sb.append(i);
		}
		return sb.toString();
	}
	public static String join(List<String> list, String d) {
		if (list.size() == 0) return "";
		StringBuilder sb = new StringBuilder();
		Boolean isFirst = true;
		for (String i : list) {
			if (isFirst)
				isFirst = false;
			else
				sb.append(d);
			sb.append(i);
		}
		return sb.toString();
	}
	
	
	
	
	public static char[] copyChars(char[] source) {
		char[] copy = new char[source.length];
		for (int i = 0 ; i < sourcel.length ; i++)
			copy[i] = source[i];
		return list;
	}
	
	public static List<Character> toList(char[] l) {
		List<Character> list = new ArrayList<Character>();
		for (char c : l) {
			list.add(c);
		}
		return list;
	}
	
	public static Boolean removeChar(List<Character> source, char c) {
		for (int i = 0 ; i < source.size() ; i++) {
			if (source.get(i) == c) {
				source.remove(i);
				return true;
			}
		}
		return false;
	}
	
}