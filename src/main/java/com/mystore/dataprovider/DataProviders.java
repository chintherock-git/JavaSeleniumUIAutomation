package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

import com.mystore.utility.ExcelLibrary;

public class DataProviders {
	
	
	ExcelLibrary obj = new ExcelLibrary();
	
	
	@DataProvider(name="credentials")
	public Object[][] getCredentials(){
		int rows = obj.getTotalRowNum("LoginData");
		int col = obj.getColumnCount("LoginData");
		//rows gives total count as indexing starts from 0
		Object[][] data= new Object[rows-1][col];
		
		for (int i=0;i<rows-1;i++) {
			for (int j=0;j<col;j++ ) {
				//i+1 as the excel sheet has header
				data[i][j] = obj.getCellData("LoginData",i+1,j);
				
			}
		}
				return data;
	}

}
