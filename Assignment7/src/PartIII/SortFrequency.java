package PartIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortFrequency {

	public static void sortByFrequency(ArrayList<Integer> ar) {
		Map<Integer,Integer> hashmap=new HashMap<>();
		
		List<Integer> output=new ArrayList<>();
		for(int number:ar)
			hashmap.put(number,hashmap.getOrDefault(number,0)+1);	
		System.out.println("hashmap:->"+hashmap);
		
		Collections.sort(ar, new Comparator < Integer > () {
            @Override 
            public int compare(Integer num1, Integer num2) {
                int freqCompare = hashmap.get(num1).compareTo(hashmap.get(num2));
                int valueCompare = num1.compareTo(num2);
                if (freqCompare == 0) return valueCompare;
                else return freqCompare;
            }
	    });
        for (Integer o: output) {
            System.out.print(o + " ");
        }
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i=0;i<100;i++) {
			ar.add((int)(Math.random()*10));			
		}
		System.out.println(ar.toString());
		sortByFrequency(ar);
		System.out.println(ar.toString());
	}
}
//Explanation:-
//Make an array of HashMaps that holds the elements of the array and their occurrences.

//Insert the hashmap into a List so that we may use a specialized comparator 
//to order the data based on how frequently it occurs.

//Java's Object Comparison: - Return -1, if Object 1 is less than Object 2, 
//otherwise Return 0, if Object 1 and Object 2 are equal. Return +1,if Object 1 is bigger than Object 2. 
//In our situation, the number with natural precedence should be included in the answer 
//if two numbers have the same frequencies.

