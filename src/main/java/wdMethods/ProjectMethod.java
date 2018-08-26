package wdMethods;


import java.io.IOException;

import javax.annotation.Generated;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ProjectMethod extends SeMethods{
	@DataProvider(name="data")
	public Object[][] getdata() throws IOException
	{
		
	    Object[][] data1 = LearnExcel.getdata(Filename);
		
		return data1;
	}
    @BeforeMethod
    @Parameters({"Browser","appurl","username","password"})
	public void login(String Browser,String appurl,String uName,String pwd) {
	startApp(Browser, appurl);
	WebElement eleUserName = locateElement("id","username");
	type(eleUserName, uName);
	WebElement elePassword = locateElement("id","password");
	type(elePassword, pwd);
	WebElement eleLogin = locateElement("class","decorativeSubmit");
	click(eleLogin);
	WebElement ele1 = locateElement("Linktext","CRM/SFA");
	click(ele1);

}
    
    @AfterMethod
    public void close()
{
    	
    	closeAllBrowsers();
}
}