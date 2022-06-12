package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.ActionDriver;

public class AccountCreationPage {
	
	
	@FindBy(xpath="//h1[contains(text(),'Create an account')]")
	private WebElement pagetitle;
	
	@FindBy(id="id_gender2")
	private WebElement titlemrs;
	
	@FindBy(id="id_gender1")
	private WebElement titlemr;
	
	@FindBy(id="customer_firstname")
	private WebElement firstname;
	
	@FindBy(id="customer_lastname")
	private WebElement lastname;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="passwd")
	private WebElement password;
	
	@FindBy(id="days")
	private WebElement dob_days;
	
	@FindBy(id="months")
	private WebElement dob_months;
	
	@FindBy(id="years")
	private WebElement dob_years;
	
	@FindBy(id="firstname")
	private WebElement address_fname;
	
	@FindBy(id="lastname")
	private WebElement address_lname;
	
	@FindBy(id="company")
	private WebElement address_company;
	
	@FindBy(id="address1")
	private WebElement address_companyaddress;
	
	@FindBy(id="address2")
	private WebElement address_companyaddress2;
	
	@FindBy(id="city")
	private WebElement city_companyaddress;

	@FindBy(id="id_state")
	private WebElement state_companyaddress;

	@FindBy(id="postcode")
	private WebElement postcode_companyaddress;
	 
	@FindBy(id="id_country")
	private WebElement country_companyaddress;
	 
	@FindBy(id="other")
	private WebElement additionalInfo_companyaddress;
	
	@FindBy(id="phone")
	private WebElement phone_companyaddress;
	
	@FindBy(id="phone_mobile")
	private WebElement mobile_companyaddress;
	
	@FindBy(id="alias")
	private WebElement alias_companyaddress;
	
	@FindBy(xpath="//span[contains(text(),'Register')]")
	private WebElement register;
	
	ActionDriver action= new ActionDriver();
	
	public AccountCreationPage () {
		PageFactory.initElements(BaseClass.getDriver(),this);
	}
	
	public void createAccount(String title,String fname,String lname,String pwd,String dob_day,String dob_month,String dob_year,String company,String address,
			String state, String city,String zip,String country,String additionalInfo,String Mobile,String aliasaddress) 
	{
		if (title.equalsIgnoreCase("mr"))
			action.selectRadioButton(titlemr);
		else if(title.equalsIgnoreCase("mrs"))
			action.selectRadioButton(titlemrs);
		action.type(firstname,fname);
		action.type(lastname,lname);
		action.type(password,pwd);
		
		
		action.selectByVisibleText(dob_days,dob_day);
		action.selectByVisibleText(dob_months,dob_month);
		action.selectByVisibleText(dob_years,dob_year);
		
		action.type(firstname,fname);
		action.type(lastname,lname);
		action.type(address_company,company);
		action.type(address_companyaddress,address);
		action.type(city_companyaddress,city);
		
		action.selectByVisibleText(city_companyaddress,state);
		action.type(postcode_companyaddress,zip);
		action.selectByVisibleText(country_companyaddress,country);
		action.type(additionalInfo_companyaddress,additionalInfo);
		action.type(mobile_companyaddress,Mobile);
		action.type(alias_companyaddress,aliasaddress);
		
		
		
	}
	
	public HomePage validateRegistration() {
		action.click(register);
		HomePage home= new HomePage();
		return home;
		}
	
	public boolean validateCreateAccountPage() {
		return action.isDisplayed(pagetitle);
	}

}
