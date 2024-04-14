package com.test.basic;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LearnThread {
	
	public static long start;
	public static long end;

	
	@BeforeTest
	public void setup() {
		
		start = System.currentTimeMillis();
	}
	
	
	@AfterTest
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
		end = System.currentTimeMillis();
		System.out.println("Total time taken");
		System.out.println(end-start);
	}
	
    
	@Test
	public  void Test1() {
		
		Table t1 = new Table();
		
		t1.table1();
		
	}
	
}
	
class Table	{
	
	public void table1() {
		for (int i=1;i<2000;i++)	{
			 
			 System.out.println( i*2 + " "+System.currentTimeMillis());
		 }
	}
		
}


	

