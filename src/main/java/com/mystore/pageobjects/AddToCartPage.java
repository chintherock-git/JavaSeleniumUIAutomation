package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.ActionDriver;

public class AddToCartPage {

	
	@FindBy(xpath="//a[contains(@class,'product_img_link')]")
	private WebElement producttile;
	
	@FindBy(xpath="//div[@class='layer_cart_product col-xs-12 col-md-6']/h2")
	private WebElement cartsuccessmessage;
	
	@FindBy(id="add_to_cart")
	private WebElement addtocart;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement checkout;
	
	
	
ActionDriver action = new ActionDriver();
	
	public AddToCartPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
		
	
public void clicksearchResult() {
		
		action.explicitwaitforelements(producttile);
		action.click(producttile);
		action.explicitwaitforelements(addtocart);
		action.click(addtocart);
		action.explicitwaitforelements(cartsuccessmessage);
		action.click(cartsuccessmessage);
		
	}

public OrderPage addsearchresulttocart() {
	action.explicitwaitforelements(checkout);
	action.click(checkout);
	return new OrderPage();
	
}

}
