package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage; 
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "Contact";
	
	public ContactPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initilization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchFrame();
		contactsPage = new ContactsPage();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 1,  dataProvider="getCRMTestData")
	public void addContactTest(String title, String firstName, String lastName, String company){
		homePage.clickOnAddContactLik();
		contactsPage.createContact(title, firstName, lastName, company);
	}
}
