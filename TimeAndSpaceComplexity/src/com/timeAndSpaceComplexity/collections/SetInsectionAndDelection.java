package com.timeAndSpaceComplexity.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetInsectionAndDelection {

	public static void main(String[] args) {

		Set<Integer> hashSet = new HashSet<>();
		Set<Integer> treeSet = new TreeSet<>();

		// declare a properties
		long startTime;
		long endTime;

		// Time taken to add hashSet elements
		startTime = System.nanoTime();
		for (int i = 0; i < 101000; i++) {
			hashSet.add(i);
		}
		endTime = System.nanoTime();
		System.out.println("HashSet Insertion Time: " + (endTime - startTime) + " ns");

		// Time taken to add treeSet elements
		startTime = System.nanoTime();
		for (int i = 0; i < 101000; i++) {
			treeSet.add(i);
		}
		endTime = System.nanoTime();
		System.out.println("TreeSet Insertion Time: " + (endTime - startTime) + " ns");

		// Time taken to deletion hashSet elements
		startTime = System.nanoTime();
		hashSet.remove(100000);
		endTime = System.nanoTime();
		System.out.println("HashSet deletion time: " + (endTime - startTime) + " ns");

		// Time taken to deletion treeSet elements
		startTime = System.nanoTime();
		treeSet.remove(100000);
		endTime = System.nanoTime();
		System.out.println("HashSet deletion time: " + (endTime - startTime) + " ns");
	}

}
