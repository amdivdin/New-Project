package testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdMethods.SeMethods;

public class TC_002 extends SeMethods {
	@Test
	public void log() throws InterruptedException {

		startApp("chrome", "http://leaftaps.com/opentaps");
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		WebElement elePassword = locateElement("id","password");
		type(elePassword, "crmsfa");
		WebElement eleLogin = locateElement("class","decorativeSubmit");
		click(eleLogin);
		WebElement ele1 = locateElement("Linktext","CRM/SFA");
		click(ele1);
WebElement ele2 = locateElement("Linktext","Create Lead");
         
		
		click(ele2);
		WebElement merge = locateElement("Linktext","Merge Leads");
		click(merge);
		
		WebElement ele3 = locateElement("xpath","(//table//a/img)[1]");
		click(ele3);
		switchToWindow(1);
		
		
		WebElement ele4 = locateElement("name","firstName");
		type(ele4,"Rupa");
		WebElement ele5 = locateElement("xpath", 
				"//button[contains(text(),'Find Leads')]");
		click(ele5);
		Thread.sleep(3000);
		WebElement ele6 = locateElement("Linktext","Rupa");
		clickWithNoSnap(ele6);
	
		
	       switchToWindow(0);
		
		WebElement ele12 = locateElement("name","ComboBox_partyIdTo");
		clickWithNoSnap(ele12);
		WebElement ele11 = locateElement("xpath","(//table//a/img)[2]");
		clickWithNoSnap(ele11);
		 switchToWindow(1);
			WebElement ele7 = locateElement("name","firstName");
			type(ele7,"Divya");
			WebElement ele8 = locateElement("xpath", 
					"//button[contains(text(),'Find Leads')]");
			clickWithNoSnap(ele8);
			Thread.sleep(3000);
			WebElement ele9 = locateElement("Linktext","Divya");
			clickWithNoSnap(ele9);
			 switchToWindow(0);
			WebElement ele10 = locateElement("Linktext","Merge");
			clickWithNoSnap(ele10);
			
			driver.switchTo().alert().accept();
			
		
		
		
}
}