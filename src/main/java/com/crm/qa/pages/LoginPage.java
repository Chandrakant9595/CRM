package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Define page factory - OR
	@FindBy(name = "username")
	WebElement userName;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = ".//*[@id='loginForm']/div/div/input")
	WebElement loginButto;
	
	@FindBy(xpath = "html/body/div[2]/div/div[1]/a/img")
	WebElement crmLogo;
	
	//initilized the webelement / or
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	//action
	public String validateLoginPageTittle(){
		return driver.getTitle();
	}

	public boolean validateCRMLogo(){
		return crmLogo.isDisplayed();
	}
	
	public String validateCRMURL(){
		return driver.getCurrentUrl();
	}
	
	public HomePage validateLogin(String un, String pass){
		userName.sendKeys(un);
		password.sendKeys(pass);
		loginButto.click();
		
		return new HomePage();
	}
}

