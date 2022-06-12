


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
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmation;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;
import com.mystore.utility.Log;


/**
 * @author baitharu
 *
 */
public class EndToEndTest extends BaseClass {
		  IndexPage index;
		  LoginPage login;
		  SearchResultPage search;
		  AddToCartPage add;
		  OrderPage order;
		  AddressPage address;
		  ShippingPage shipping;
		  PaymentPage payment;
		  OrderConfirmation orderconfirm;
		  
		  
		@Parameters("browser")
			@BeforeMethod(groups = {"smoke","sanity","regression"})
			public void setUp(String browsername) {
				
				BaseClass.launchApp(browsername);
			}

			
			@AfterMethod(groups = {"smoke","sanity","regression"})
			public void tearDown() {
				BaseClass.getDriver().quit();
			}
			
		
	
		@Test(groups = {"regression"})
		public void validateorderpage() throws InterruptedException  {  
			Log.startTestCase(this.getClass().getName());
			try {
				index= new IndexPage();
				search=index.searchProduct("t-shirt");
				add= new AddToCartPage();
				add.clicksearchResult();
				order=add.addsearchresulttocart();
				login=order.checkout();
				address=login.loginforcheckout(prop.getProperty("username"),prop.getProperty("password"));
				
				shipping = address.returnshipping();
				
				shipping.checkTerms();
				payment=shipping.clickproceed();
				orderconfirm = payment.paybywire();
				String actual = orderconfirm.getorderconfirmationtext();
				System.out.println(actual);
				String expected = "Your order on My Store is complete.";
				AssertJUnit.assertEquals(expected, actual);
				Log.endTestCase(this.getClass().getName());
			}
			catch(Exception e) {
				
			}
		}

}
