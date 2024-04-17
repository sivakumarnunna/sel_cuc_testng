package com.test.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map.Entry;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

import com.utlis.base.ConfigReader;
import com.utlis.base.FileUtils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import com.stepdefinitions.Hooks;
import com.utlis.base.EmailSender;

@CucumberOptions(features = "src/test/resources/features/sample.feature", glue = "com.stepdefinitions", plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
	@AfterTest
	public void publish_email() throws FileNotFoundException, IOException {

		System.out.println(Hooks.result);

		String total = "";
		for (Entry<String, String> entry : Hooks.result.entrySet()) {
			String data = "<tr>"+ "<td>" + entry.getKey() + "</td>" + "<td>" + entry.getValue() + "</td>" + "</tr>";
			total = total + data;
		}

		String htmlContent = "<html><body>  <h3>Execution Summary</h3>\n" + "<table border='1'><tr>"
				+ "<th>Total Testcases</th>" + "<th>passed</th>" + "<th>Failed</th>" + "<th>skipped</th>" + "<tr>"
				+ "<td>" + ConfigReader.getProperty("totalScenarios") + "</td>" + "<td>"
				+ ConfigReader.getProperty("passed") + "</td>" + "<td>" + ConfigReader.getProperty("failed") + "</td>"
				+ "<td>" + ConfigReader.getProperty("skipped") + "</td>" + "</tr>" + "</table>"
				+ "<table border='1'>" + total+ "</table>"
				+ "	  <h4>Please find attached test report for more details</h4>\n" + "</body></html>";

		String attachment = FileUtils.getFile(new File(System.getProperty("user.dir")),
				ConfigReader.getProperty("report-path"));
		EmailSender.sendEmail(ConfigReader.getProperty("email-receivers"), "Automation status", htmlContent,
				attachment + ConfigReader.getProperty("report-file"));

	}

}
