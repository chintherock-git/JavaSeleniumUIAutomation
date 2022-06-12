/**
 * 
 */
package com.mystore.utility;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author baitharu
 *
 */
public class ExcelLibrary {
	
	public static String excelpath= System.getProperty("user.dir")+"//ExcelData//TestInputs.xlsx";
	public static String sheetDefault= "TestData";
	public File file;
	public FileInputStream istream;
	

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	
	//parametrized constructor
	public ExcelLibrary(String sheetName) {
		try {
		
		file = new File(excelpath);
		istream = new FileInputStream(file);
		workbook= new XSSFWorkbook(istream);
		sheet=workbook.getSheet(sheetName);
		istream.close();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//default constructor
	
	
	public ExcelLibrary() {
		
		try {
		
		file = new File(excelpath);
		istream = new FileInputStream(file);
		workbook= new XSSFWorkbook(istream);
		sheet=workbook.getSheet(sheetDefault);
		istream.close();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Function to fetch the total row count for sheetname in workbook
	public int getTotalRowNum(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		int rowCount= sheet.getLastRowNum();
		//As the index starts with 0 hence adding to count;
		return rowCount+1;
		
	}
	
	
	//Function to fetch the entire data in the sheet in the Workbook
	public void  getSheetData(String sheetName) {
		
		String value;
		for(int i=0;i<getTotalRowNum(sheetName);i++) {
			row=sheet.getRow(i);
			for (int j=0;j<row.getLastCellNum();j++) {
				value=row.getCell(j).getStringCellValue();
				System.out.print(value+" ");
			}
			
			System.out.println();
		}
		
	}
	
	public int getColumnCount(String sheetName) {
		
		if (isSheetExist(sheetName)) {
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(0);
		}
		if (row==null){
			return -1;
		}
		int colCount=row.getLastCellNum();
		return colCount;	
		
	}
	
	public boolean isSheetExist(String sheetName) {
		
		int index = workbook.getSheetIndex(sheetName);
		if (index==-1) {
			index=workbook.getSheetIndex(sheetName.toUpperCase());
				if (index==-1)
							return false;
				else
					return true;
		}
		return true;
		
	}
	public String getCellData(String sheetName,int rownum,int colnum) {
		String value=null; 
		if (isSheetExist(sheetName)) {
			sheet=workbook.getSheet(sheetName);
			int ifRow=rownum;
			row= sheet.getRow(ifRow);
			//System.out.println("The last column number is "+row.getLastCellNum());
			if(row!=null) {
				cell = row.getCell(colnum);	
				value = cell.getStringCellValue();
			}
				
		}
		System.out.println("The value  is"+value);
		return value;
	}
}
