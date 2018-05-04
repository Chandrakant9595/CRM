package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage; 
	public static Logger logLogin = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initilization();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	@Test(priority = 1)
	public void crmPageTittleTest(){
		String tittle = loginPage.validateLoginPageTittle();
		logLogin.info("tittle is "+ tittle);
		Assert.assertEquals(tittle, "Free CRM software in the cloud powers sales and customer service");
	}
	
	@Test(priority = 2)
	public void crmLogoTest(){
		boolean flag = loginPage.validateCRMLogo();
		logLogin.info("logo is present");
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void crmURLTest(){
		String url = loginPage.validateCRMURL();
		logLogin.info("URL is " + url);
		Assert.assertEquals(url, "https://www.freecrm.com/index.html");
	}
	
	@Test(priority = 4)
	public void loginTest(){
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		logLogin.info("Login successful");
	}
}
