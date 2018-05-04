package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	//page factory - OR
	@FindBy(name = "title")
	WebElement titleDropDown;
	
	@FindBy(name = "first_name")
	WebElement fName;
	
	@FindBy(name = "surname")
	WebElement lName;
	
	@FindBy(name = "client_lookup")
	WebElement companyName;
	
	@FindBy(xpath = "/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[1]/td/input[2]")
	WebElement saveButton;
	
	//initilization webelements OR
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
		
	//action
	public void createContact(String title, String ftName, String ltName, String cName){
		Select select = new Select(titleDropDown);
		select.selectByVisibleText(title);
		fName.sendKeys(ftName);
		lName.sendKeys(ltName);
		companyName.sendKeys(cName);
		saveButton.click();  
	}
}
