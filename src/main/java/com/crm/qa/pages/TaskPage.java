package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class TaskPage extends TestBase{
	
	//page factory - OR
	@FindBy(id = "title")
	WebElement taskTitle;

	@FindBy(id = "completion")
	WebElement taskCompletion;
	
	@FindBy(xpath = "/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[1]/td/input")
	WebElement save;
	
	//initilization webelements OR
	public TaskPage(){
		PageFactory.initElements(driver, this);
	}
		
	//action
	public void createContact(String title, String completion){
		taskTitle.sendKeys(title);
		taskCompletion.sendKeys(completion);
		save.click();  
	}
}
