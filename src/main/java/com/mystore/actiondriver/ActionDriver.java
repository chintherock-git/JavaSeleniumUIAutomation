package com.mystore.actiondriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.Base.BaseClass;
import com.mystore.actionInterface.ActionInterface;

public class ActionDriver extends BaseClass implements ActionInterface{
	
	public String getTitle(WebDriver driver) {
		return driver.getTitle();	
		}
	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();	
		}
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();	
		}
	public String getText(WebElement we) {
		return we.getText();
	}
	
	public String getAttribute(WebElement we,String attribute) {
		return we.getAttribute(attribute);
		}
	public String getTagName(WebElement we) {
		return we.getTagName();
	}
	
	
	public boolean isDisplayed(WebElement we) {
		boolean flag;
		flag=we.isDisplayed();
		if(flag) 
			System.out.println("The element is successfully displayed on the page ");
		else 
			System.out.println("The element is not displayed in the page");
		return flag;
	}
	 public  boolean isEnabled(WebElement we) {
		 boolean flag= we.isEnabled();
		 if (flag) 
			 System.out.println("The button element is enabled");
		else
				 System.out.println("The button element is not Enabled on page");
		 
		 return flag;
	 }
	 public boolean isSelected(WebElement we) {
		 boolean flag= we.isSelected();
		 if(flag) 
			 System.out.println("The element either dropdown/Checkbox/radio button is selected in page");
		 else
			 System.out.println("The element either radioi button/checkbox/dropdownlist is not selected");
		 return flag;
	 }
	 public void getSize(WebElement we) {
		int height= we.getSize().getHeight();
		int width = we.getSize().getWidth();
		 
		 System.out.println("The height of the object is "+height);
		 System.out.println("The width of the object is "+width);
		 
	 }
	 
	 //returns point with respect to Desktop Screen
	 public void getLocation(WebElement we) {
		 int xcoord= we.getLocation().getX();
		 int ycoord= we.getLocation().getY();
		 
		 System.out.println("The x coordinate of the object is "+xcoord);
		 System.out.println("The y coordinate of the object is "+ycoord);
		 
	 }
	 
	 public String getCssValue(WebElement we,String propName) {
		 String attrValue = we.getCssValue(propName);
		 return attrValue;
		 
	 }
	 public void scrollByVisibilityofElement(WebDriver driver,WebElement we) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView",we);
			 
		}
	 
	 public boolean type(WebElement we,String text) {
		 boolean flag= false;
		 try {
			 flag= we.isDisplayed();
			 we.clear();
			 we.sendKeys(text);	
			 flag=true;
			 
		 }
		 catch(Exception e ) {
			 System.out.println("Element could not be found");
			 flag=false;
		 }
		 
		 finally{
			 if(flag) {
				 System.out.println("User was able to enter desired text in the field");
			 }
			 else
				 System.out.println("User was not able to enter desired text in the field");
		 }
		 return flag;
	 }
	public boolean JSClick(WebDriver driver, WebElement we) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			JavascriptExecutor js= (JavascriptExecutor)driver; 
			js.executeScript("arguments[0].click",we);
			flag=true;
		}
		catch(Exception e) {
			System.out.println(e.toString());
			flag=false;
		}
		finally {
			if(flag) {
				System.out.println("Element is clicked");
				flag=true;
			}
			else
				System.out.println("Element could not be clicked");
		}
 		return flag;
	}
	
	public void selectRadioButton(WebElement we) {
		boolean flag =  false;
		try {
		flag=we.isDisplayed();
		we.click();
		if (we.isSelected()) {
			flag=true;
			System.out.println(" The radio option "+we.getText()+"is selected ");
		}
		else {
			flag=false;
			System.out.println(" The radio option "+we.getText()+"could not be selected ");
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag)
				System.out.println("Radio button is selected");
		   else
			System.out.println("Radio Button could not be selected");
		}
	}
	
	public void click(WebElement we) {
		boolean flag =false;
		try {
			flag=we.isDisplayed();
			we.click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if (flag)
			System.out.println("Element is clicked");
			else
				System.out.println("Element could not be clicked");
		}
	}
	
	public boolean selectByValue(WebElement we, String value) {
		boolean flag= false;
		try {
			if(we.isDisplayed()) {
				Select se= new Select(we);
				se.selectByValue(value);
				flag=true;
			}
		}
		catch (Exception e) {
			
		}
		finally {
			if (flag)
				System.out.println("The item was selected by value");
			else
				System.out.println("The item not be selected");
		}
		return flag;
	}
	
	public boolean selectByIndex(WebElement we, int Index) {
		boolean flag= false;
		try {
			if(we.isDisplayed()) {
				Select se= new Select(we);
				se.selectByIndex(Index);
				flag=true;
			}
		}
		catch (Exception e) {
			
		}
		finally {
			if (flag)
				System.out.println("The item was selected by value");
			else
				System.out.println("The item not be selected");
		}
		return flag;
	}
	
	public boolean selectByVisibleText(WebElement we, String text) {
		boolean flag= false;
		try {
			if(we.isDisplayed()) {
				Select se= new Select(we);
				se.selectByVisibleText(text);
				flag=true;
			}
		}
		catch (Exception e) {
			
		}
		finally {
			if (flag)
				System.out.println("The item was selected by value");
			else
				System.out.println("The item not be selected");
		}
		return flag;
	}
	@SuppressWarnings("deprecation")
	public void implicitWaitforelments() {
		getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
	}
	
	
	public void explicitwaitforelements(WebElement we) {
		
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(getDriver(),Integer.parseInt(prop.getProperty("implicitWait")));
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	
	public void fluentwaitexample(WebElement e,String messagetocontain) {
		final String s= messagetocontain;
		FluentWait<WebElement> wait = new FluentWait<WebElement>(e)
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class)
				.withTimeout(Duration.ofSeconds(30));
		
		wait.until(new Function<WebElement,Boolean>(){
			public Boolean apply(WebElement e) {
				return e.getText().equals(s);
			}
		});
		
	}
	
	public String getScreenshot(WebDriver driver, String filename) {
		String fileseparator = System.getProperty("file.separator");
		String filelocation= System.getProperty("user.dir")+"/TestReports/Screenshots/";
		
		String datetime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src= screenshot.getScreenshotAs(OutputType.FILE);
		String destination = filelocation+filename+"_"+BaseClass.getCurrentTime()+".png";
		try {
			FileUtils.copyFile(src,new File(destination));
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		
		
		return destination;
	}
}

