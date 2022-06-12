
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.mystore.Base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class AddToCartPageTest extends BaseClass {
	  IndexPage index;
	  SearchResultPage search;
	  AddToCartPage add;
	  OrderPage order;
		
	  
	@Parameters("browser")
		@BeforeMethod(groups = {"smoke","sanity","regression"})
		public void setUp(String browsername) {
			
			BaseClass.launchApp(browsername);
		}

		
		@AfterMethod(groups = {"smoke","sanity","regression"})
		public void tearDown() {
			BaseClass.getDriver().quit();
		}
		
	
	@Test(groups = {"smoke"}, description="Checks the valid add to cart message")
	public void validateaddtocartmessage() throws InterruptedException  {
		Log.startTestCase(this.getClass().getName());
		index= new IndexPage();
		search=index.searchProduct("t-shirt");
		add= new AddToCartPage();
		add.clicksearchResult();
		order=add.addsearchresulttocart();
		String currentvtUrl=getDriver().getCurrentUrl();
		AssertJUnit.assertEquals(currentvtUrl, "http://automationpractice.com/index.php?controller=order");
		Log.endTestCase(this.getClass().getName());
		
	}

}
