package com.mystore.utility;

import org.testng.ITestListener; 
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mystore.actiondriver.ActionDriver;
import com.mystore.Base.BaseClass;




public class Listener extends ExtentReportsManager implements ITestListener{
	
	//******onStart 
	//OnFinish
	//OnPass
	//OnFail
	
	
	ActionDriver action = new  ActionDriver();
	
	
	
	public void onStart(ITestContext result) {
		
	}
	
	public void onFinish(ITestContext result) {
		
	}
	
	public void onTestStart(ITestResult result) {
		
		test= extent.createTest(result.getMethod().getMethodName());
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		String passtest= result.getName();
		test=extent.createTest(passtest);
		if(result.getStatus()==ITestResult.SUCCESS) {
		try {
			//test.log(Status.FAIL,MarkupHelper.createLabel(result.getMethod().getMethodName()+"   TestCase has Failed ......",ExtentColor.RED));
			//test.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable()+"   TestCase has Skipped ......",ExtentColor.RED));
			
			String path = action.getScreenshot(BaseClass.getDriver(),result.getName());
			test.pass("Passed Screenshot Attached",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			test.addScreenCaptureFromPath(path);
			test.log(Status.PASS, "Pass Test case is: " + result.getName());
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void onTestSkipped(ITestResult result) {
		String skiptest= result.getName();
		test=extent.createTest(skiptest);
		if(result.getStatus()==ITestResult.SKIP) {
			
			test.log(Status.SKIP, "Skip Test case is: " + result.getName());
		}
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	public void onTestFailure(ITestResult result) {
		
		String failtest= result.getName();
		test=extent.createTest(failtest);
		if(result.getStatus()==ITestResult.FAILURE) {
			
			try {
			//test.log(Status.FAIL,MarkupHelper.createLabel(result.getMethod().getMethodName()+"   TestCase has Failed ......",ExtentColor.RED));
			//test.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable()+"   TestCase has Skipped ......",ExtentColor.RED));
			
			String path = action.getScreenshot(BaseClass.getDriver(),result.getName());
			test.fail("Failed Screenshot Attached",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			test.addScreenCaptureFromPath(path);
			test.log(Status.PASS, "Fail Test case is: " + result.getName());
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	


}
