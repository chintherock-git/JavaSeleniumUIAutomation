

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
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

/**
 * 
 */

/**
 * @author baitharu
 *
 */
public class OrderPageTest {
		  IndexPage index;
		  LoginPage login;
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
			
		
		  
		@Test(groups = {"smoke"},description="Checks the valid Order page test page")
		public void validateorderpage() throws InterruptedException  {  
			Log.startTestCase(this.getClass().getName());
			try {
				index= new IndexPage();
				search=index.searchProduct("t-shirt");
				add= new AddToCartPage();
				add.clicksearchResult();
				order=add.addsearchresulttocart();
				double unit= order.getUnitPrice();
				double shipping= order.getUnitPrice();
				double total_cost=unit+shipping;
				double actual=order.gettotalprice();
				AssertJUnit.assertEquals(total_cost,actual);	
				Log.endTestCase(this.getClass().getName());
			}
			catch(Exception e) {
				
			}
		}

}
