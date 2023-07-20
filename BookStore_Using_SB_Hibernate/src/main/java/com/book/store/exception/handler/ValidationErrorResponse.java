package com.book.store.exception.handler;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * A ValidationErrorResponse class to responsible the errors
 *
 */
public class ValidationErrorResponse {

	private List<Violation> violations = new ArrayList<>();

	/**
	 * To handle the fields of Violation
	 * 
	 * @return violations
	 */
	public List<Violation> getViolations() {
		return violations;
	}

	public void setViolations(List<Violation> violations) {
		this.violations = violations;
	}
}
