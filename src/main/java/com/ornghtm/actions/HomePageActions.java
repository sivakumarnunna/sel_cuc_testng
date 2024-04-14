package com.ornghtm.actions;
 
import org.openqa.selenium.support.PageFactory;

import com.ornghrm.locators.HomePageLocators;
import com.utlis.base.DriverManager;

 
public class HomePageActions {
 
    HomePageLocators homePageLocators = null;
     
    public HomePageActions() {
           
        this.homePageLocators = new HomePageLocators();
   
        PageFactory.initElements(DriverManager.getDriver(),homePageLocators);
    }
   
    
    // Get the User name from Home Page
    public String getHomePageText() {
        return homePageLocators.homePageUserName.getText();
    }
   
}