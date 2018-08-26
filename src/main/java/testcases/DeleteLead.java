package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdMethods.SeMethods;

public class DeleteLead extends SeMethods {
	@Test(dependsOnMethods="testcases.EditLead.start")
	
	public void log()
	{	
		/*startApp("chrome", "http://leaftaps.com/opentaps");
	WebElement eleUserName = locateElement("id", "username");
	type(eleUserName, "DemoSalesManager");
	WebElement elePassword = locateElement("id","password");
	type(elePassword, "crmsfa");
	WebElement eleLogin = locateElement("class","decorativeSubmit");
	click(eleLogin);
	WebElement ele1 = locateElement("Linktext","CRM/SFA");
	click(ele1);*/
		WebElement ele4 = locateElement("Linktext","Delete");
		click(ele4);
		
	
	
}
}