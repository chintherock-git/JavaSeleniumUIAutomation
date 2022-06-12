
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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class HomePageTest {
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
		

	
	
	@Test(groups = {"smoke"},description="Checks the validing of the Home page")
	public void validateHomePage() throws InterruptedException {
		Log.startTestCase(this.getClass().getName());
		String actualURL = "http://automationpractice.com/index.php?controller=my-account";
		index= new IndexPage();
		login=index.clickSignIn();
		home = login.login(BaseClass.prop.getProperty("username"), BaseClass.prop.getProperty("password"),actualURL);
		AssertJUnit.assertTrue(home.validateorderHistory());
		AssertJUnit.assertTrue(home.validatewishlist());
		
		AssertJUnit.assertEquals(actualURL,home.getHomeURL());
		Log.endTestCase(this.getClass().getName());
	}
	
	

}
