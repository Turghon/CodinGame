import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Solution of Temperatures exercise of Coding Challenge
 * Resolved in xxx minutes (of 40 allowed)
 */
class Solution {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		// Parameters
		int count = in.nextInt(); in.nextLine();
		
		if (count > 0) {
            // Search and compute
            int temperatures = findTemperatureNearestZero(in, count);
		    
            // Display
            System.out.println(temperatures);
            
		} else {
            // Display
            System.out.println(0);
		}
		
	}
	
	/**
		Get nearest temperature to zero among all given temperatures.
		@param in The input scanner
		@param count The number of lines to read
		@return The nearest temperature to zero
	*/
	public static int findTemperatureNearestZero(Scanner in, int count) {
		int nearest = Integer.MAX_VALUE;
		int t;
		
		for (int i = 0 ; i < count ; i++) {
			t = in.nextInt();
			nearest = (Math.abs(t) < Math.abs(nearest) || t == Math.abs(nearest)) ? t : nearest;
		}
		
		return nearest;
	}
}