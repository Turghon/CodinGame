import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Solution of Supercomputer Planning exercise of Coding Challenge
 * Resolved in 120 minutes (of 90 allowed)
 */
class Solution {
	static class Entry {
		public int start;
		public int minEnd = Integer.MAX_VALUE;
		public Entry(int start, int end) {
			this.start = start;
			this.minEnd = end;
		}
		public void updateEnd(int end) {
            this.minEnd = Math.min(minEnd, end);
        }
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		// Parameters
		int count = in.nextInt(); in.nextLine();
		Entry[] entries = readAllObject(in, count);
		
		// Compute
		int maxWorks = fillMaxTasks(entries);
		
		// Display
		System.out.println(maxWorks);
	}
	
	public static int fillMaxTasks(Entry[] entries) {
		int maxTasks = 0;
		int size = entries.length;
		Entry entry;
		
		// Quick save of optimal possible task
		//  maximums[<number of possible tasks>] = <last possible start>
		int[] maximums = new int[size + 1];
		maximums[0] = Integer.MAX_VALUE;
		
        for (int i = size - 1 ; i >= 0 ; i--) {
            entry = entries[i];
            
            FindMaxPossibleLoop:
            for (int j = maxTasks ; j >= 0 ; j--) {
                if (maximums[j] > entry.minEnd) {
                    // Update entry
                    maxTasks = Math.max(maxTasks, j+1);
                    maximums[j+1] = Math.max(maximums[j+1], entry.start);
                    break FindMaxPossibleLoop;
                }
            }
        }
		
		return maxTasks;
	}
	
	public static Entry[] readAllObject(Scanner in, int count) {
		TreeMap<Integer, Entry> entries = new TreeMap<Integer, Entry>();
		int start, end;
		
		for (int i = 0 ; i < count ; i++) {
			start = in.nextInt();
			end = start + in.nextInt() - 1;
			in.nextLine();
			
			if (entries.containsKey(start)) {
                entries.get(start).updateEnd(end);
            } else {
                entries.put(start, new Entry(start, end));
			}
		}
		
        return entries.values().toArray(new Entry[0]);
	}
}