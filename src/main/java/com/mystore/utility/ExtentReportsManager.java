package com.mystore.utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mystore.Base.BaseClass;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsManager {
	
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test;
	
	
	//logging object to log messages events screenshots to flow of test steps
	public static ExtentReports extent;
	
	//public static String path=System.getProperty("user.dir")+"/test-output/ExtentReports";
	public static String fileName =  "Report.html";
	public static String filepath = System.getProperty("user.dir")+"/test-output/ExtentReports";
	public static String fileSeparator = System.getProperty("file.separator");
	public static String reportFileLocation = filepath+fileSeparator+fileName;
	public static String fileNamemade= System.getProperty("user.dir")+"/test-output/ExtentReports/"+"reports_"+BaseClass.getCurrentTime()+".html";
	
	public static void setExtent() {
		
		
	
		htmlReporter= new ExtentHtmlReporter(fileNamemade);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+System.getProperty("file.separator")+"extent-config.xml");
		//extent=getInstance();
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName", "MAC");
		extent.setSystemInfo("ProjectName", "MyStoreProjectUI");
		extent.setSystemInfo("Tester", "Chinmayee");
		extent.setSystemInfo("OS", "MacOSMonterey");
		
	 }
	
	public static ExtentReports getInstance() {
		if (extent==null) {
			setExtent();
		}
		return extent;
	}
	
	public static String getFileLocation(String filepath) {
		
		File file = new File(filepath);
		
		if (!file.exists()) {
			
			if(file.mkdir()) {
			System.out.println("Created Directory location for Extent reports");
			return filepath;
			}
			else {
				System.out.println(" Directory location "+filepath+ " could not be created");
				return System.getProperty("user.dir");
			}
		}
		else {
			System.out.println(" Directory location"+filepath+ " for Extent reports exists");
			return filepath;
		}
		
	}
	
	
	public static void endReport() throws IOException {
		
		extent.flush();
		Desktop.getDesktop().browse(new File (fileNamemade).toURI());
	
	}
	
	

}
