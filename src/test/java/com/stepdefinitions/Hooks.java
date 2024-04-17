package com.stepdefinitions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.utlis.base.ConfigReader;
import com.utlis.base.DriverManager;
import com.utlis.base.SeleniumUtils;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import  com.utlis.base.FileUtils;

public class Hooks {
	
	static int totalScearios = 0;
	static int passed = 0;
	static int failed = 0;
	static int skipped = 0;
	public static Properties prop = null;
	public static Map<String, String> result = new LinkedHashMap<String, String>();
	
	SeleniumUtils seleniumUtils = new SeleniumUtils();

	
	 @BeforeAll
	 public static void before_all() throws IOException {
		 
		 ConfigReader.readProperties();
		FileUtils.deleteFiles(new File(System.getProperty("user.dir")),"ExtentReports");
	    
	 }
	
	
	@Before
	public void setup(Scenario scenario) throws FileNotFoundException, IOException {
		System.out.println("Scenario started :: " +scenario.getName());
		DriverManager.setDriver();
	}
	 @After
	    public static void tearDown(Scenario scenario) {
	    	
	    	
	    	result.put(scenario.getName(), scenario.getStatus().toString());
	    	totalScearios=totalScearios+1;
	         
	    	io.cucumber.java.Status status =scenario.getStatus();
	    	
	    	if(status.name().equalsIgnoreCase("passed")){
	    		passed=passed+1;
	    	}
	    	if(status.name().equalsIgnoreCase("skipped")){
	    		skipped=skipped+1;
	    	}
	    	
	        //validate if scenario has failed
	        if(scenario.isFailed()) {
	        	failed=failed+1;
	            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", scenario.getName()); 
	        }   
	     
	        DriverManager.close();
	    }
	    
	    @AfterAll
	    public static void email() throws FileNotFoundException, IOException {
	    	
	    	ConfigReader.setProperty("totalScenarios", Integer.toString(totalScearios));
	    	ConfigReader.setProperty("passed", Integer.toString(passed));
	    	ConfigReader.setProperty("failed", Integer.toString(failed));
	    	ConfigReader.setProperty("skipped", Integer.toString(skipped));
	    	
	    }
	     
	
}
