package testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdMethods.SeMethods;

public class Project1 extends SeMethods {
     @Test
	public void zoomCar() throws InterruptedException
	{
		startApp("chrome", "https://www.zoomcar.com/chennai/");
		WebElement ele1 = locateElement("xpath","//a[contains(@class,'search')]");
		ele1.click();
		
		WebElement location = locateElement("xpath","//div[contains(text(),'Thuraipakkam')]");  //locate location
		location.click();
		WebElement nxt = locateElement("xpath","//button[contains(text(),'Next')]");
		nxt.click();		//click next button
		WebElement date = locateElement("xpath","//div[contains(text(),'Mon')]");
		String txt1 = date.getText();		
		
		date.click();
		WebElement day = locateElement("xpath","//button[contains(text(),'Next')]");
		
		day.click();
		WebElement picked = locateElement("xpath","//div[contains(text(),'Mon')]");
	
		//String txt2 = picked.getText();
	
		//boolean a = txt1.equals(txt2);
		//System.out.println(a);
		
		WebElement locateElement6 = locateElement("xpath", "//button[text()='Done']");
		locateElement6.click();
		
		Thread.sleep(3000);
		/*WebElement price = locateElement("xpath","//div[contains(text(),' Price: High to Low ')]");
		price.click();*/
		int parseInt;
	     List<WebElement> li1 = driver.findElementsByTagName("h3");//find search result and store it in a list
	     for (WebElement webElement : li1) {
			System.out.println(webElement.getText());
		}
	int size = li1.size();
	System.out.println("The RESULT count is"+size);
		Thread.sleep(3000);
	
		List<Integer> li3=new ArrayList<Integer>();
		List<WebElement> li2 = driver.findElementsByXPath("//div[@class='price']");//store list of price
		for(WebElement element:li2) {
			String t = element.getText();	
			String replaceAll = t.replaceAll("\\D", "");
			System.out.println(replaceAll);
			parseInt = Integer.parseInt(replaceAll);
		     li3.add(parseInt);
		}
		
	for(Integer inti:li3) {
		System.out.println(inti);
		
	}
	 Collections.sort(li3);//sort
	 
	 Integer first = li3.get(0);
	 
	 System.out.println("first value is"+first);
	 System.out.println(li3.get(li3.size()-1));//get the maximum price
	 
	 Integer integer = li3.get(li3.size()-1);
	 //locateElement("x", "//*[contains(text(),'"+integer.toString()+"')]");
	 WebElement ele4 = locateElement("xpath","//*[contains(text(),'"+integer.toString()+"')]//preceding::div[@class='details'][1]/h3");//build dynamic xpath
		
System.out.println(ele4.getText());

		
	}
	
	
}
