package com.timeAndSpaceComplexity.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListInsectionAndDelection {

	public static void main(String[] args) {

		List<Integer> arrayList = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<>();

	   // declare the startTime and endTime properties
		long startTime;
		long endTime;

		// Time taken to add arrayList elements
		startTime = System.nanoTime();
		for (int i = 0; i < 101000; i++) {
			arrayList.add(i);
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList Insertion Time: " + (endTime - startTime) + " ns");

		// Time taken to add linkedList elements
		startTime = System.nanoTime();
		for (int i = 0; i < 101000; i++) {
			linkedList.add(i);
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList Insertion Time: " + (endTime - startTime) + " ns");

		// Time taken to access arrayList elements
		startTime = System.nanoTime();
		arrayList.get(100000);
		endTime = System.nanoTime();
		System.out.println("ArrayList access time: " + (endTime - startTime) + " ns");

		// Time taken to access linkedList elements
		startTime = System.nanoTime();
		linkedList.get(100000);
		endTime = System.nanoTime();
		System.out.println("ArrayList access time: " + (endTime - startTime) + " ns");

		// Time taken to deletion arrayList elements
		startTime = System.nanoTime();
		arrayList.remove(100000);
		endTime = System.nanoTime();
		System.out.println("ArrayList deletion time: " + (endTime - startTime) + " ns");

		// Time taken to deletion linkedList elements
		startTime = System.nanoTime();
		linkedList.remove(100000);
		endTime = System.nanoTime();
		System.out.println("ArrayList deletion time: " + (endTime - startTime) + " ns");

	}

}
