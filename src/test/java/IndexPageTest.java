
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
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.ExtentReportsManager;
import com.mystore.utility.Log;

/**
 * 
 */

/**
 * @author baitharu
 * the testng execution method is 
 * Suite
 * Test  
 * class
 * Method
 * @Test
 */
public class IndexPageTest {
	private IndexPage index;
	 
	
	@Parameters("browser")
		@BeforeMethod(groups = {"smoke","sanity","regression"})
		public void setUp(String browsername) {
			
			BaseClass.launchApp(browsername);
		}

		
		@AfterMethod(groups = {"smoke","sanity","regression"})
		public void tearDown() {
			BaseClass.getDriver().quit();
			
		}
		
	
	@Test(groups = {"sanity","smoke"},description="Checks the validation of the Logo ")
	public void checkLogotest() throws InterruptedException {
		Log.startTestCase(this.getClass().getName());
		Thread.sleep(1000);
		index = new IndexPage();
		boolean actualresult=index.checkLogo();
		//Assert.assertTrue(actualresult);
		AssertJUnit.assertFalse(actualresult);
		Log.endTestCase(this.getClass().getName());
	}
		@Test(groups = {"smoke"})
		public void checkTitleTest() {
		Log.startTestCase(this.getClass().getName());
		Log.info("2nd Test for same class"+this.getClass().getName());
		String actualtitle = index.getStoreTitle();
		AssertJUnit.assertEquals("My Store", actualtitle);
		Log.endTestCase(this.getClass().getName());
	}
}
