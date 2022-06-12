package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.ActionDriver;

public class AddressPage{
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement addressCheckOut;
	
	ActionDriver action = new ActionDriver();
	
	public AddressPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	public ShippingPage returnshipping() {
		action.explicitwaitforelements(addressCheckOut);
		action.click(addressCheckOut);
		ShippingPage shipping = new ShippingPage();
		return shipping;
	}

}
