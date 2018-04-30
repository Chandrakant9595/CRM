package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage; 
	TestUtil testUtil;

	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initilization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifyHomepageTittleTest(){
		String tittleOfHomePage = homePage.validateHomePageTittle();
		Assert.assertEquals(tittleOfHomePage, "CRMPRO", "Home page title is not correct");
	}
	
	@Test(priority = 2)
	public void verifyUserTest(){
		testUtil.switchFrame();
		Assert.assertTrue(homePage.validateUser());
	}
}	
