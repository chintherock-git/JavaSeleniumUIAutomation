package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.ActionDriver;

public class SearchResultPage{
	
	ActionDriver action = new ActionDriver();
	
	public SearchResultPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	@FindBy(xpath="//div[@class='ac_results']")
	private WebElement productResult;
	
	@FindBy(id="search_query_top")
	private WebElement searchbox;
	
	@FindBy(xpath="(//div[@class='ac_results']/ul/li)[1]")
	private WebElement firstitem_search;
	
	@FindBy(id="//i[@class='icon-ok']")
	private WebElement addeditemmessage;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement checkout;
	
	@FindBy(name="submit_search")
	private WebElement searchicon;
	
	@FindBy(xpath="//span[contains(text(),'result has been found')]")
	private WebElement searchresult;
	


	public boolean validatesearchResult() {
		
		//text = 0 results have been found.        
		boolean flag =false;
		try {
			action.explicitwaitforelements(searchresult);
			
			if (action.isDisplayed(searchresult))
				flag=true;
			
		 	}
		catch (Exception e) {
			System.out.println("Search Result is not visible");
		}
		return flag;
	}
	
	
	

	

}
