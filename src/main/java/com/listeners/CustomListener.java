package com.listeners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Execution started for : " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("good news Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("bad news Test Failed: " + result.getName());
    }

    // Other methods like onTestSkipped(), onStart(), onFinish(), etc. can be implemented similarly
}
