package com.timeAndSpaceComplexity.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionTimeAndSpace {

	/** Calculate the MemoryUsage
	 * declare static getMemoryUsage method
	 * Runtime class we can getRuntime memory
	 * @return
	 * totalMemory - freeMemory
	 */
	private static long getMemoryUsage() {
		Runtime runtime = Runtime.getRuntime();
		return runtime.totalMemory() - runtime.freeMemory();
	}

	public static void main(String[] args) {

		List<Integer> arrayList = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<>();

		Map<String, Integer> treeMap = new TreeMap<>();
		Map<String, Integer> hashMap = new HashMap<>();

		Set<Integer> hashset = new HashSet<>();
		Set<Integer> treeSet = new TreeSet<>();

		// declare properties
		long startTime;
		long endTime;

		long memoryBefore;
		long memoryAfter;
		
		//ArrayList Time and Space complexity
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();
		
		
		for (int i = 0; i < 100000; i++) {
			arrayList.add(i);
		}

		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		
		System.out.println(">>>>ArrayList Time and Space<<<<<<");
		System.out.println("====================================");
		System.out.println("ArrayList Insertion Time: " + (endTime - startTime) + " ns");
		System.out.println("ArrayList Memory Usage: " + (memoryAfter - memoryBefore) + "bytes");
		System.out.println("=====================================");

		
		// LinkedList Time and Space complexity
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();

		
		for (int i = 0; i < 100000; i++) {
			linkedList.add(i);
		}

		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		
		System.out.println(">>>>LinkedList Time and Space<<<<<<");
		System.out.println("=====================================");
		System.out.println("LinkedList Insertion Time: " + (endTime - startTime) + "ns");
		System.out.println("LinkedList Memory Usage: " + (memoryAfter - memoryBefore) + "bytes");
		System.out.println("=====================================");

		
		// HashSet Time and Space complexity
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();

		
		for (int i = 0; i < 100000; i++) {
			hashset.add(i);
		}

		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		
		System.out.println(">>>>HashSet Time and Space<<<<<<");
		System.out.println("====================================");
		System.out.println("HashSet Insertion Time: " + (endTime - startTime) + "ns");
		System.out.println("HashSet Memory Usage: " + (memoryAfter - memoryBefore) + "bytes");
		System.out.println("====================================");

		// HashSet Time and Space complexity
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();

		
		for (int i = 0; i < 100000; i++) {
			treeSet.add(i);
		}

		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		
		System.out.println(">>>>TreeSet Time and Space<<<<<<");
		System.out.println("====================================");
		System.out.println("TreeSet Insertion Time: " + (endTime - startTime) + "ns");
		System.out.println("TreeSet Memory Usage: " + (memoryAfter - memoryBefore) + "bytes");
		System.out.println("====================================");

		// HashMap Time and Space complexity
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();

		for (int i = 0; i < 100000; i++) {
			hashMap.put("i", i);
		}

		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		
		System.out.println(">>>>HashMap Time and Space<<<<<<");
		System.out.println("====================================");
		System.out.println("HashMap Insertion Time: " + (endTime - startTime) + "ns");
		System.out.println("HashMap Memory Usage: " + (memoryAfter - memoryBefore) + "bytes");
		System.out.println("====================================");

		// TreeSet Time and Space complexity
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();

		for (int i = 0; i < 100000; i++) {
			treeMap.put("i", i);
		}

		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		
		System.out.println(">>>>TreeMap Time and Space<<<<<<");
		System.out.println("====================================");
		System.out.println("TreeMap Insertion Time: " + (endTime - startTime) + "ns");
		System.out.println("TreeMap Memory Usage: " + (memoryAfter - memoryBefore) + "bytes");
		System.out.println("====================================");
	}

}
