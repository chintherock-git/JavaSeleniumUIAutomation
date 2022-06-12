package com.mystore.pageobjects;

import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.mystore.pageobjects.IndexPage;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.ActionDriver;

public class IndexPage {
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	private WebElement signin;
	
	@FindBy(xpath="//div[@id='header_logo']/a/img")
	private WebElement logo;
	
	@FindBy(id="search_query_top")
	private WebElement searchbox;
	
	@FindBy(name="submit_search")
	private WebElement searchsubmit;
	
	@FindBy(xpath="//span[@class='heading-counter']")
	private WebElement zeroresult;
	
	@FindBy(xpath="//p[contains(@class,'alert alert-warning')]")
	private WebElement searchkeywordmessage;
	
	@FindBy(xpath="//div[@id='center_column']/p")
	private WebElement message;
	
	ActionDriver action = new ActionDriver();
	
	public IndexPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	public boolean checkLogo() {
		boolean flag=false;
		if(action.isDisplayed(logo)) {
			flag=true;
		}
		return flag;	
	}
	
	public LoginPage  clickSignIn() throws InterruptedException {
		Thread.sleep(2000);
		action.isDisplayed(signin);
		action.click(signin);
		return new LoginPage();
	}
	
	public String getStoreTitle() {
		return action.getTitle(BaseClass.getDriver());
	}
	
	public SearchResultPage searchProduct(String productname) {
		action.isDisplayed(searchbox);
		action.type(searchbox,productname);
		action.explicitwaitforelements(searchsubmit);
		action.click(searchsubmit);
		action.implicitWaitforelments();
	    return new SearchResultPage();
	}
	
	public String nosearchProduct_result(String productname) {
		
		action.isDisplayed(searchbox);
		action.type(searchbox,productname);
		action.explicitwaitforelements(searchsubmit);
		action.click(searchsubmit);
		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(),Duration.ofSeconds(30));
		 wait.until(new Function<WebDriver,Boolean>(){
	          public Boolean apply(WebDriver driver) {
	        	  String message="No results were found for your search"+" \""+productname+"\"";
	        	  return driver.findElement(By.xpath("//div[@id='center_column']/p")).getText().contains(message);
	          }
	    });
		 
		 return message.getText();
		
	}
	
	public String clicksearchResultfornoresult(String seachtext) {
			action.isDisplayed(searchbox);
			action.type(searchbox,seachtext);
			action.explicitwaitforelements(searchsubmit);
			action.click(searchsubmit);
			action.explicitwaitforelements(searchkeywordmessage);
			return searchkeywordmessage.getText();
	}

}
