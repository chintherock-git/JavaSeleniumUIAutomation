package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.ActionDriver;

import com.mystore.Base.BaseClass;

public class HomePage  {
	
	ActionDriver action = new ActionDriver();
	
	@FindBy(xpath="//span[contains(text(),'Order history and details')]")
	private WebElement orderHistory_tab;
	
	@FindBy(xpath="//span[(text()='My wishlists')]")
	private WebElement wishlist;
	
	public HomePage() {
		PageFactory.initElements(BaseClass.getDriver(),this);
	}
	
	public boolean validateorderHistory() {
		//action.fluentwaitexample(orderHistory_tab,"Order history and details");
		boolean flag=action.isDisplayed(orderHistory_tab);
		//System.out.println("The Order History is displayed is "+flag);
		return flag;
	}
	
	public boolean validatewishlist() {
		boolean flag=action.isDisplayed(wishlist);
		return flag;
		}
	
	public String getHomeURL() {
		String homepageURL=action.getCurrentURL(BaseClass.getDriver());
		return homepageURL;
	}

}
