package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.ActionDriver;

public class OrderPage {
	public OrderPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	ActionDriver action = new ActionDriver();
	
	@FindBy(id="cart_title")
	private WebElement orderpage;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedtocheckout;
	
	@FindBy(xpath="//span/span[@class='price']")
	private WebElement unitprice;
	
	@FindBy(id="total_price")
	private WebElement totalprice;

	@FindBy(id="total_shipping")
	private WebElement shippingcost;
	

	
	public String validatetitle(WebElement we) {
		return action.getText(we);
	}
	
	
	public LoginPage checkout() {
	    action.explicitwaitforelements(proceedtocheckout);
	    action.click(proceedtocheckout);
		return new LoginPage();
	}
	
	public double getUnitPrice() {
		String text= action.getText(unitprice);
		String nodollar=text.replaceAll("[^$]","");
		double price = Double.parseDouble(nodollar);
		return price;
	}
	
	public double getShippingPrice() {
		String text= action.getText(shippingcost);
		String nodollar=text.replaceAll("[^$]","");
		double price = Double.parseDouble(nodollar);
		return price;
	}
	
	public double gettotalprice() {
		String tprice=action.getText(totalprice);
		String tp=tprice.replaceAll("[^$]","");
		double price = Double.parseDouble(tp);
		return price;
	}

}
