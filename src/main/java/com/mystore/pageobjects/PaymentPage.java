package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.ActionDriver;

public class PaymentPage  {
	
	ActionDriver action= new ActionDriver();
	
	@FindBy(xpath="//a[contains(text(),'Pay by bank wire')]")
	private WebElement paybywire;
	
	
	@FindBy(xpath="//a[contains(text(),'Pay by check')]")
	private WebElement paybycheck;
	
	public PaymentPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	public OrderConfirmation paybywire () {
		action.explicitwaitforelements(paybywire);
		action.click(paybywire);
		return new OrderConfirmation();
	}
	

}
