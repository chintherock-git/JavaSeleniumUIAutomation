package com.mystore.Base;

import java.io.FileInputStream;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import com.mystore.utility.Log;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.mystore.utility.ExtentReportsManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.mystore.utility.Listener;

/**
 * @author krichin
 *
 */

@Listeners(Listener.class)
public class BaseClass {
	
	public static String config_path=System.getProperty("user.dir")+"//Configuration//config.properties";
	
	public static Properties prop;
	 /**
	 * 
	 */
	
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	@BeforeSuite  (groups = {"smoke","sanity","regression"})
	public void loadConfig()   {
		
		//Step 3 : Create log.java class in UTility and there initialize the log4j.xml via DOMConfigurator(feom apache log4j library) in BAse class
		DOMConfigurator.configure("log4j.xml");
		ExtentReportsManager.setExtent();
		Log.info("Start of Suite\n");
		 prop= new Properties();
		 try {
			 
		 
		 FileInputStream in = new FileInputStream(config_path);
		 prop.load(in);
		 
		 }
		 catch (FileNotFoundException e) {
			 e.printStackTrace();
		 }
		 catch (IOException e ) {
			 e.printStackTrace();
		 }
	 }
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	public static void launchApp(String browsername) {
		if (browsername.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}
		else if (browsername.equalsIgnoreCase("edge")){
			WebDriverManager.chromedriver().setup();
			driver.set(new EdgeDriver());
		}
		else if (browsername.equalsIgnoreCase("safari")){
			WebDriverManager.safaridriver().setup();
			driver.set(new SafariDriver());
		}
		if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTime")), TimeUnit.SECONDS);
		
	 
} 
	
	@AfterSuite (groups = {"smoke","sanity","regression"})
	public void afterTest() throws IOException{
		ExtentReportsManager.endReport();
	}
	public static String getCurrentTime() {
		// TODO Auto-generated method stub
		
		String datetime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
		return datetime;
	}
	
	

}
