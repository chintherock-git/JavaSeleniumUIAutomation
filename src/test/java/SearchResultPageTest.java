

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;


import com.mystore.Base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

/**
 * 
 */

/**
 * @author baitharu
 *
 */
public class SearchResultPageTest {
		 IndexPage index;
		 SearchResultPage searchpage;
		

		@Parameters("browser")
			@BeforeMethod(groups = {"smoke","sanity","regression"})
			public void setUp(String browsername) {
				
				BaseClass.launchApp(browsername);
			}


			@AfterMethod(groups = {"smoke","sanity","regression"})
			public void tearDown() {
				BaseClass.getDriver().quit();
			}
			
			
		@Test(groups = {"regression","smoke"}, description="Checks the search Result page test")
		public void checkseachresult() throws InterruptedException  {
			Log.info("3rd test case of class"+this.getClass().getName());
			Log.startTestCase(this.getClass().getName());
			index= new IndexPage();
			searchpage=index.searchProduct("t-shirt");
			boolean flag = searchpage.validatesearchResult();
			AssertJUnit.assertTrue(flag);
			Log.endTestCase(this.getClass().getName());
		}
		
		@Test (priority = -1 ,groups = {"sanity","smoke"}, description="Checks the valid no result page test")
		public void validatenoresulttext() throws InterruptedException  {
			Log.info("2nd test case of class"+this.getClass().getName());
			Log.startTestCase(this.getClass().getName());
			index= new IndexPage();
			String message = index.clicksearchResultfornoresult("");
			String expected = "Please enter a search keyword";
			AssertJUnit.assertEquals(message,expected);
			Log.endTestCase(this.getClass().getName());
		}
		
		@Test (priority = -2)
		public void validatenosearch() throws InterruptedException  {
			Log.info("1st test case of class"+this.getClass().getName());
			Log.startTestCase(this.getClass().getName());
			index= new IndexPage();
			String searchstring = "lehenga";
			String message = index.nosearchProduct_result(searchstring);
			String expected = "No results were found for your search "+"\""+searchstring+"\"";
			AssertJUnit.assertEquals(message,expected);
			Log.endTestCase(this.getClass().getName());
		}


		}
