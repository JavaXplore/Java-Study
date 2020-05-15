/**
 * 
 */
package com.javaxplored;

import java.io.Serializable;

/**
 * @author pranit
 *
 */
public class Employee implements Cloneable,Serializable{

	private String name;

	/**
	 * @param name
	 */
	public Employee(String name) {
		super();
		this.name = name;
	}

	/**
	 * 
	 */
	public Employee() {
		name = "Employee 1";
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
