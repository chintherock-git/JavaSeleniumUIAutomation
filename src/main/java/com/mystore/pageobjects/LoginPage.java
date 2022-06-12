package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.ActionDriver;

public class LoginPage {
	
	ActionDriver action =new ActionDriver();
	
	@FindBy(id="email")
	private WebElement emailAddress;
	
	@FindBy(id="passwd")
	private WebElement password;
	
	@FindBy(id="SubmitLogin")
	private WebElement signIn;
	
	@FindBy(id="SubmitCreate")
	private WebElement createAccountButton;
	
	@FindBy(id="email_create")
	private WebElement createAccountEmail;
	
	
	LoginPage(){
		PageFactory.initElements(BaseClass.getDriver(),this);
	}
	
	public HomePage login(String username,String passwd,String expectedURL) throws InterruptedException {
		Thread.sleep(10000);
		
		System.out.println("Is Email address Field displayed "+action.isDisplayed(emailAddress));
		System.out.println("Is the Password field displayed" +action.isDisplayed(password));
		System.out.println("Is the Sign in  field displayed" +action.isDisplayed(signIn));
		action.type(emailAddress,username);
		action.type(password,passwd);
		action.click(signIn);
		Thread.sleep(1000);
		
		HomePage home= new HomePage();
		
		return home;
	}
	
	public AccountCreationPage createAcount(String email) {
		System.out.println("Is the Create Account Email address displayed "+action.isDisplayed(createAccountEmail));
		System.out.println("Is the Create accountemail enabled "+action.isEnabled(createAccountEmail));
		System.out.println("Is the Sign In button enabled "+action.isDisplayed(createAccountButton));
		action.type(createAccountEmail,email);
		action.click(createAccountButton);
		AccountCreationPage acc = new AccountCreationPage();
		return acc;
	}
	
	public AddressPage loginforcheckout(String username,String passwd) {
		action.explicitwaitforelements(emailAddress);
		action.type(emailAddress,username);
		action.type(password,passwd);
		action.click(signIn);
		return new AddressPage();
	}

}
