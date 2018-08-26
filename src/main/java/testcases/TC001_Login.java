package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wdMethods.ProjectMethod;

public class TC001_Login extends ProjectMethod{
	@BeforeClass

	public void  setdata()
	{
		testCaseName="TC_001";
		testCaseName="case";
		author="Divya";
		category="smoke";
		Filename="Book (1)";
	}




	@Test(groups="sanity",dataProvider="data")
	
	public void create(String cmpny,String fName,String lName) {
		WebElement ele2 = locateElement("Linktext","Create Lead");

		click(ele2);
		WebElement ele3 = locateElement("id","createLeadForm_companyName");
		type(ele3,cmpny);
		WebElement ele4 = locateElement("id","createLeadForm_firstName");
		type(ele4,fName);
		WebElement ele5 = locateElement("id","createLeadForm_lastName"); 
		type(ele5,lName);
		WebElement drop = locateElement("id","createLeadForm_dataSourceId");
		selectDropDownUsingText(drop,"Cold Call");
		WebElement click = locateElement("name","submitButton");
		click(click);

	}

}







