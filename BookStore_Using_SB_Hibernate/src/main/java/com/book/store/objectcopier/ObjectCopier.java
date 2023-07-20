package com.book.store.objectcopier;

import org.springframework.beans.BeanUtils;

/**
 * The ObjectCopier class provides for copying object properties from a source object to a target object.
 */
public class ObjectCopier {

	/**
     * Copies properties from a source object to a target object.
     *
     * @param source The source object 
     * @param target The target object 
     * @throws IllegalArgumentException If either the source or target object is null.
     */
	public static void copyObject(Object source, Object target) {

		if (source == null) {
			throw new IllegalArgumentException("Source object should not be null");
		}

		if (target == null) {
			throw new IllegalArgumentException("Target object should not be null");
		}

		// Spring's `BeanUtils.copyProperties` for the copying operation.
		BeanUtils.copyProperties(source, target);

	}
}