package com.test.basic;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.utlis.base.ConfigReader;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/sample.feature", glue = "com.stepdefinitions", plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
	    boolean parallelExecution = Boolean.parseBoolean(System.getenv("parallelExecution"));
	    return parallelExecution ? super.scenarios() : new Object[0][0];
	}

	/*
	 * @BeforeTest
	 * 
	 * @Parameters({ "browser" }) public void defineBrowser(String browser) throws
	 * FileNotFoundException, IOException {
	 * 
	 * ConfigReader.setProperty("browser", browser); }
	 */

}
