package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	//page factory - OR
	@FindBy(xpath = "/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement userName;
	
	@FindBy(xpath = "/html/body/table[1]/tbody/tr[3]/td[1]/div/div/ul/li[4]/a")
	WebElement contactLink;
	
	@FindBy(linkText = "New Contact")
	WebElement addContactLink;
	
	@FindBy(xpath = "/html/body/table[1]/tbody/tr[3]/td[1]/div/div/ul/li[5]/a")
	WebElement dealsLink;
	
	@FindBy(xpath = "/html/body/table[1]/tbody/tr[3]/td[1]/div/div/ul/li[6]/a")
	WebElement taskLink;
	
	@FindBy(linkText = "New Task")
	WebElement addTaskLink;
	
	//initilization webelements OR
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//action
	public String validateHomePageTittle(){
		return driver.getTitle();
	}
	
	public boolean validateUser(){
		return userName.isDisplayed();
	}
	
	public ContactsPage clickOnContactLink(){
		contactLink.click();
		return new ContactsPage();
	}
	
	public void clickOnAddContactLik(){
		Actions action = new Actions(driver);
		action.moveToElement(contactLink).build().perform();
		addContactLink.click();
	}
	
	public TaskPage clickOnTaskLink(){
		taskLink.click();
		return new TaskPage();
	}
	
	public void clickOnAddTaskLik(){
		Actions action = new Actions(driver);
		action.moveToElement(taskLink).build().perform();
		addTaskLink.click();
	}
}
