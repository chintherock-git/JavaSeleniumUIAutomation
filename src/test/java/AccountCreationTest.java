

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
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.ExcelLibrary;
import com.mystore.utility.Log;

/**
 * 
 */

/**
 * @author baitharu
 *
 */
public class AccountCreationTest extends BaseClass {
		  IndexPage index;
		  LoginPage login;
		  AccountCreationPage accountcreate;
		  ExcelLibrary excel;
		  
		  
		@Parameters("browser")
			@BeforeMethod(groups = {"smoke","sanity","regression"})
			public void setUp(String browsername) {
				
				BaseClass.launchApp(browsername);
			}

		
			@AfterMethod(groups = {"smoke","sanity","regression"})
			public void tearDown() {
				BaseClass.getDriver().quit();
			}
			
		
		
		@Test(groups = {"sanity"} ,description="Checks the valid account creation page")
		public void validateAccountCreationPage() throws InterruptedException {
		//extent.createTest(result.getMethod().getMethodName());
		Log.startTestCase(this.getClass().getName());
		excel=new  ExcelLibrary();
		excel.getSheetData(ExcelLibrary.sheetDefault);
		//System.out.println ("The Cell Value is "+excel.getCellData(ExcelLibrary.sheetDefault,8,2));
		index= new IndexPage();
		login=index.clickSignIn();
		accountcreate= login.createAcount("testservice341@gmail.com");
		boolean actual=accountcreate.validateCreateAccountPage();
		AssertJUnit.assertTrue(actual);
		Log.endTestCase(this.getClass().getName());
		}

}
