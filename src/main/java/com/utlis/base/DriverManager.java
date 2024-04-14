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

	private DriverManager(String browsername) {
		
		

		if (browsername.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeoptions = new ChromeOptions();
			driver.set(new ChromeDriver(chromeoptions));
			System.out.println("opening the browser session "+browsername);
		} else if (browsername.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			driver.set(new FirefoxDriver(options));
			System.out.println("opening the browser session "+browsername);

		} else if (browsername.equalsIgnoreCase("edge")) {
			EdgeOptions edgeOptions = new EdgeOptions();
			driver.set(new EdgeDriver(edgeOptions));
			System.out.println("opening the browser session "+browsername);

		}
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Browser is " + browsername);

		System.out.println("Thread is " + Thread.currentThread());
	}

	public static WebDriver getDriver() {
		return DriverManager.driver.get();
	}

	public static void openURL(String url) {
		driver.get().get(url);
	}

	public static void setDriver(String browser) {
		if (drivermanager == null) {
			new DriverManager(browser);
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
