package com.test.basic;


import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnThread2 {

    public static long start;
    public static long end;

    

    @Test
    public void test123() {
        Thread t1 = new Thread(new ThreadTable());
        Thread t2 = new Thread(new ThreadTable());
        Thread t3 = new Thread(new ThreadTable());
        Thread t4 = new Thread(new ThreadTable());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class ThreadTable implements Runnable {

	    public void openBrowser() {
		  ThreadLocal<WebDriver> driver =new  ThreadLocal<WebDriver>() ;
		  
		 ChromeOptions options = new ChromeOptions();
		 try {
		driver.set(new ChromeDriver(options));
        driver.get().get("https://www.facebook.com");
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 finally {
			 if (driver.get() != null) {
	                driver.get().quit();
	            }
		 }
		 
		 System.out.println("Helloooooooo");
    }

    public void run() {
        openBrowser();
    }
}
