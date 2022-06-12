
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
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;


public class LoginPageTest {
	  IndexPage index;
	  LoginPage login;
	  HomePage home;
		
	
	@Parameters("browser")
		@BeforeMethod(groups = {"smoke","sanity","regression"})
		public void setUp(String browsername) {
			
			BaseClass.launchApp(browsername);
		}

		@AfterMethod(groups = {"smoke","sanity","regression"})
		public void tearDown() {
			BaseClass.getDriver().quit();
		}
		
	
	@Test(dataProvider="credentials",dataProviderClass=DataProviders.class,groups = {"sanity","smoke"},description="Checks the login")
	public void login(String userName,String password,String expectedURL) throws InterruptedException {
		Log.startTestCase(this.getClass().getName());
		index= new IndexPage();
		login=index.clickSignIn();
		//home = login.login(BaseClass.prop.getProperty("username"), BaseClass.prop.getProperty("password"));
		home = login.login(userName,password,expectedURL);
		String currentURL= home.getHomeURL();
		//String actualURL= "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals("False", expectedURL);
		Log.endTestCase(this.getClass().getName());
	}

}
