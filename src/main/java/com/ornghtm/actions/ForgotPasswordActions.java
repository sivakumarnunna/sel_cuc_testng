package com.ornghtm.actions;
 
import org.openqa.selenium.support.PageFactory;

import com.ornghrm.locators.ForgotPasswordLocators;
import com.utlis.base.DriverManager;
 
 
public class ForgotPasswordActions {
 
    ForgotPasswordLocators forgotPasswordLocators = null;
        
    public ForgotPasswordActions() {
         
        this.forgotPasswordLocators = new ForgotPasswordLocators();
 
        PageFactory.initElements(DriverManager.getDriver(),forgotPasswordLocators);
    }
  
    // Get the Heading of Forgot Password page
    public String getForgotPasswordPageText() {
        return forgotPasswordLocators.ForgotPasswordHeading.getText();
    }
}