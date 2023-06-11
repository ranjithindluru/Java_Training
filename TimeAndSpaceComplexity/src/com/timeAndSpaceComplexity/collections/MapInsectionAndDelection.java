package com.timeAndSpaceComplexity.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapInsectionAndDelection {

	public static void main(String[] args) {

		Map<Integer, String> hashMap = new HashMap<>();
		Map<Integer, String> treeMap = new TreeMap<>();

		// declare a properties
		long startTime;
		long endTime;

		// Time taken to add hashMap elements
		startTime = System.nanoTime();
		for (int i = 0; i < 101000; i++) {
			hashMap.put(i, "i");
		}
		endTime = System.nanoTime();
		System.out.println("HashMap Insertion Time: " + (endTime - startTime) + " ns");

		// Time taken to add treeMap elements
		startTime = System.nanoTime();
		for (int i = 0; i < 101000; i++) {
			treeMap.put(i, "i");
		}
		endTime = System.nanoTime();
		System.out.println("TreeMap Insertion Time: " + (endTime - startTime) + " ns");

		// Time taken to access hashMap elements
		startTime = System.nanoTime();
		hashMap.get(100000);
		endTime = System.nanoTime();
		System.out.println("HashMap access time: " + (endTime - startTime) + " ns");

		// Time taken to access treeMap elements
		startTime = System.nanoTime();
		treeMap.get(100000);
		endTime = System.nanoTime();
		System.out.println("TreeMap access time: " + (endTime - startTime) + " ns");

		// Time taken to deletion hashMap elements
		startTime = System.nanoTime();
		hashMap.remove(100000);
		endTime = System.nanoTime();
		System.out.println("HashMap deletion time: " + (endTime - startTime) + " ns");

		// Time taken to deletion treeMap elements
		startTime = System.nanoTime();
		treeMap.remove(100000);
		endTime = System.nanoTime();
		System.out.println("HashMap deletion time: " + (endTime - startTime) + " ns");

	}

}
