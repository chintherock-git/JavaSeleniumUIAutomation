package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.ActionDriver;

public class OrderSummary {
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirmorder;
	
	ActionDriver action= new ActionDriver();
	
	public OrderSummary() {
		PageFactory.initElements(BaseClass.getDriver(),this);
	}
	
	public OrderConfirmation clickconfirmorder(WebElement we) {
		action.click(confirmorder);
		OrderConfirmation order= new OrderConfirmation();
		return order;
		
		
	}
}
