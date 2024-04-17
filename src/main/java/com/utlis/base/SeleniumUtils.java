package com.utlis.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

public class SeleniumUtils {

	public static byte[] takeScreenShotasBytes(WebDriver driver) throws IOException {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public File takeScreenShotasFile(WebDriver driver) throws IOException {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	}

	public static void takeScreenShot(WebDriver driver, String path) throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(path));

	}

	public static void rightClick(WebDriver driver, WebElement we) throws IOException {
		Actions action = new Actions(driver);
		action.contextClick(we).build().perform();
		action.sendKeys(Keys.ENTER).perform();
	}

	public static void click(WebDriver driver, WebElement we) throws IOException {
		Actions action = new Actions(driver);
		action.click(we).build().perform();
		action.sendKeys(Keys.ENTER).perform();
	}

	public void dismissAlert(WebDriver driver) throws IOException {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void frame(WebDriver driver) throws IOException {
		driver.switchTo().defaultContent();

	}

}
