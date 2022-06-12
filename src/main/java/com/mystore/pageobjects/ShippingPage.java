package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.ActionDriver;


public class ShippingPage  {
	
	@FindBy(xpath="//div[contains(@class,'checker')]/span")
	private WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedtocheckout;
	
	ActionDriver action = new ActionDriver();
	
	public ShippingPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	public void  checkTerms() throws InterruptedException {
		Thread.sleep(10000);
		action.explicitwaitforelements(terms);
		action.click(terms);
	}
	
	public PaymentPage clickproceed() {
		action.explicitwaitforelements(proceedtocheckout);
		proceedtocheckout.click();
		return new PaymentPage();
	}

}
