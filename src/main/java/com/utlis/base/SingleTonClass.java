package com.utlis.base;

public class SingleTonClass {
	
	public static void main(String[] args) {
		
	SingleTonClass s1 = SingleTonClass.getInstance();
	SingleTonClass s2 = SingleTonClass.getInstance();

	System.out.println(s1.hashCode());
	System.out.println(s2.hashCode());

	}

	public static SingleTonClass singleTonClass = null;

	private SingleTonClass() {

	}

	public static SingleTonClass getInstance() {

		if (singleTonClass == null) {
			singleTonClass = new SingleTonClass();
		}

		return singleTonClass;
	}

}
