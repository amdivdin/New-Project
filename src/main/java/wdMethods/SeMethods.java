package wdMethods;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.SysexMessage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import testcases.Report;

public  class SeMethods extends Report implements  WdMethods{
	public int i = 1;
	public RemoteWebDriver driver;
	public void startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("The Browser "+browser+" Launched Successfully");
		} catch (WebDriverException e) {
			System.err.println("The Browser "+browser+" not Launched");
		} finally {
			takeSnap();
		}

	}

	
	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator) {
			case "id"	 : return driver.findElementById(locValue);
			case "class" : return driver.findElementByClassName(locValue);
			case "xpath" : return driver.findElementByXPath(locValue);
			case "Linktext":return driver.findElementByLinkText(locValue);
			case "name":return driver.findElementByName(locValue);
			}
		} catch (NoSuchElementException e) {
			System.err.println("The Element is not found");
		} catch (Exception e) {
			System.err.println("Unknow Exception ");
		}
		return null;
	}

	@Override
	/*public WebElement locateElement(String locValue) {
		// TODO Auto-generated method stub
		driver.findElementsByTagName(locValue);
		return null;
	}*/

	
	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
			reportStep("The data  is Entered Successfully","pass");
			//System.out.println("The data "+data+" is Entered Successfully");
		} catch (WebDriverException e) {
			reportStep("The data  is Not Entered","fail");
			//System.out.println("The data "+data+" is Not Entered");
		} finally {
			takeSnap();
		}
	}

	
	public void clickWithNoSnap(WebElement ele) {
		try {
			ele.click();
			System.out.println("The Element "+ele+" Clicked Successfully");
		} catch (Exception e) {
			System.err.println("The Element "+ele+"is not Clicked");
		}
	}
	
	
	@Override
	public void click(WebElement ele) {
		try {
			ele.click();
			reportStep("The Element  Clicked Successfully","Pass");
			//System.out.println("The Element "+ele+" Clicked Successfully");
		} catch (WebDriverException e) {
		reportStep("The Element is not Clicked","fail");
			//System.err.println("The Element "+ele+"is not Clicked");
		} finally {
			//takeSnap();
		}
	}

	@Override
	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			Select dd = new Select(ele);
			dd.selectByVisibleText(value);
			System.out.println("The DropDown Is Selected with VisibleText "+value);
		} catch (Exception e) {
			System.err.println("The DropDown Is not Selected with VisibleText "+value);
		} finally {
			takeSnap();
		}

	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean verifyTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyExactText(WebElement ele, String expectedText) {
		 String txt = ele.getText();
		 boolean bol = expectedText.equalsIgnoreCase(txt);
          return bol;
		 
		
          		 

	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
          String t1 = ele.getText();      
          t1.contentEquals(expectedText);
	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyDisplayed(WebElement ele) {
 

	}

	@Override
	public void switchToWindow(int index) {
		Set<String> winhandl=driver.getWindowHandles();
		List<String> win=new ArrayList();
		win.addAll(winhandl);
		
			String str1 = win.get(index);
		driver.switchTo().window(str1);
		
		
			
		}
	

	@Override
	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public void acceptAlert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dismissAlert() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/img"+i+".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			System.err.println("IOException");
		}
		i++;
	}

	@Override
	public void closeBrowser() {
		driver.close();
	}

	@Override
	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
      driver.quit();

	}


	@Override
	public WebElement locateElement(String locValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
