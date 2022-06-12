package com.mystore.actionInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {


	public String getTitle(WebDriver driver);
	public String getCurrentURL(WebDriver driver);
	public String getPageSource(WebDriver driver);
	public void scrollByVisibilityofElement(WebDriver driver,WebElement we);
	public boolean type(WebElement we,String text);
	public boolean JSClick(WebDriver driver,WebElement we);

}
