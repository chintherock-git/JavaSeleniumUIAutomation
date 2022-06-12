package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.ActionDriver;

public class OrderConfirmation {
	
	ActionDriver action = new ActionDriver();
	
	@FindBy(xpath="//p[contains(@class,'cheque-indent')]/strong[contains(text(),'Your order on My Store is complete.')]")
	private WebElement OrderConfirmation;
	
	@FindBy(xpath="//button/span[contains(text(),'I confirm my order')]")
	private WebElement confirmbutton;

	public OrderConfirmation(){
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	public String getorderconfirmationtext() {
		action.explicitwaitforelements(confirmbutton);
		action.click(confirmbutton);
		action.explicitwaitforelements(OrderConfirmation);
		String orderconfirmationtext= action.getText(OrderConfirmation);
		return orderconfirmationtext;
		
	}
	
	
}
