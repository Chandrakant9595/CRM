package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICITWAIT = 20;
	
	public void switchFrame(){
		driver.switchTo().frame("mainpanel");
	}
}
