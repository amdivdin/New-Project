package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdMethods.SeMethods;

public  class EditLead extends SeMethods {
	@Test(dependsOnMethods="testcases.TC001_Login.create")
	public void start()
	{	
		startApp("chrome", "http://leaftaps.com/opentaps");
	WebElement eleUserName = locateElement("id", "username");
	type(eleUserName, "DemoSalesManager");
	WebElement elePassword = locateElement("id","password");
	type(elePassword, "crmsfa");
	WebElement eleLogin = locateElement("class","decorativeSubmit");
	click(eleLogin);
	WebElement ele1 = locateElement("Linktext","CRM/SFA");
	click(ele1);
		
	WebElement update=locateElement("Linktext","Edit");
	clickWithNoSnap(update);
	WebElement ele3 = locateElement("name","submitButton");
	clickWithNoSnap(ele3);
	
	}

}
