package com.stepdefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;

import com.utlis.base.ConfigReader;
import com.utlis.base.DriverManager;
import com.utlis.base.SeleniumUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;


public class Hooks {
	
	SeleniumUtils seleniumUtils = new SeleniumUtils();

	@Before
	public void setup(Scenario scenario) throws FileNotFoundException, IOException {
		System.out.println("Scenario started :: " +scenario.getName());
		
		DriverManager.setDriver();
	}
	@After
	public void tearDown(Scenario scenario) throws IOException {
		
            Status status = scenario.getStatus();
    		System.out.println("Result :: " +status);

            if(status.equals(Status.FAILED)) {
                scenario.attach(seleniumUtils.takeScreenShotasBites(DriverManager.getDriver()), "image/png", scenario.getName()); 
            }
		DriverManager.close();
		
	}
	
}
