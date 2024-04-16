package com.utlis.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

	private static DriverManager drivermanager = null;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	String browsername=System.getProperty("browsername");
	private DriverManager() {
		
		   System.out.println("Browser is .... "+ browsername);

		if (browsername.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeoptions = new ChromeOptions();
			driver.set(new ChromeDriver(chromeoptions));
		} else if (browsername.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			driver.set(new FirefoxDriver(options));
		} else if (browsername.equalsIgnoreCase("edge")) {
			EdgeOptions edgeOptions = new EdgeOptions();
			driver.set(new EdgeDriver(edgeOptions));
		}
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Thread is " + Thread.currentThread());
	}

	public static WebDriver getDriver() {
		return DriverManager.driver.get();
	}

	public static void openURL(String url) {
		driver.get().get(url);
	}

	public static void setDriver() {
		if (drivermanager == null) {
			new DriverManager();
		} else {
			System.out.println("Already driver is referring to" + getDriver().getClass());
		}
	}

	public static void close() {
		if (driver != null) {
			System.out.println("Closing the browser");
			driver.get().close();
		}
		drivermanager = null;
	}

}
