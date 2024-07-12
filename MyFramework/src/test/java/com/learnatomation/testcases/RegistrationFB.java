package com.learnatomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.FacebookRegiPage;

public class RegistrationFB extends BaseClass {
  @Test
  public void RegisterToFB() {
	  
	  FacebookRegiPage fr = PageFactory.initElements(driver, FacebookRegiPage.class);
	  
	  fr.RegistrationFaceBook("snehal@gmail.com", "snehal123", "snehal", "kokate");
  }
}