package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.util.TestUtil;

public class TaskPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage; 
	TestUtil testUtil;
	TaskPage taskPage;
	
	String sheetName = "Task";
	
	public TaskPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initilization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchFrame();
		taskPage = new TaskPage();
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
	public void addContactTest(String title, String completion){
		homePage.clickOnAddTaskLik();
		taskPage.createContact(title, completion );
	}

}
