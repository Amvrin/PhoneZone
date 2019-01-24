package datadriven_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class passparameter {
	
	static String filename = "E:\\test1.xlsx"; 
	static String sheetname = "dk";
	static FileInputStream fis;
	static FileOutputStream fos;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	
	
	/*@Test(dataProvider = "getdata")
	public void printdata(String searchtext, String result, String time)
	{
		System.out.print(searchtext);
		System.out.print(result);
		System.out.println(time);
		System.out.println("**********************************************");
		
	}
	*/
	
	
	@DataProvider
	public Object [][] getdata() throws IOException
	{
		fis = new FileInputStream(filename);
		wb= new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetname);
		
		int rownum = sheet.getLastRowNum()-(sheet.getFirstRowNum()-1);
		
		System.out.println("Number of ROW is = "+ rownum);
		int colnum = sheet.getRow(0).getLastCellNum();
		System.out.println("Number of Column is = "+ colnum);
		
		Object [][] data = new Object [rownum-1][2];
		
		for(int i=1;i<rownum;i++)
		{
			for(int j=0;j<2;j++)
			{
				data[i-1][j]=getcelldata(i,j);
			}
			
			
		}
		
		return data;
		
		
	}
	
	
	public String getcelldata(int a, int b)
	{
		row =sheet.getRow(a);
		cell = row.getCell(b);
		
		try {
			
			if(row==null)
			{
				return null;
			}
			if(cell==null)
			{
				return null;
			}
			
			else if(cell.getCellType()==cell.CELL_TYPE_STRING)
			{
				String value = cell.getStringCellValue();
				return value;
			}
			
			else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC || cell.getCellType()==cell.CELL_TYPE_FORMULA)
			{
				String value_num = String.valueOf(cell.getNumericCellValue());
				String value_mula = String.valueOf(cell.getCellFormula());
				if(cell.CELL_TYPE_NUMERIC==cell.getNumericCellValue())
				 {return value_num;}
				else {return value_mula;}
			}
			else if(cell.getCellType()== cell.CELL_TYPE_BLANK)
			{
				String value = String.valueOf("");
				return value;
			}
			else return String.valueOf(cell.getBooleanCellValue());
			
			
		}
		
		catch(Exception e) {
			return "ROW ["+a+"] COLUMN ["+b+"] is having null value";
//			
		}
	}
	
	
	public static void writecelldata(String [] text) throws IOException
	{
		
	try {	
		
		
		fis = new FileInputStream(filename);
		wb= new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetname);
		
		int rowcount = sheet.getLastRowNum()-(sheet.getFirstRowNum()-1);
		System.out.println("Number of ROW is = "+ rowcount);
		
		
		int rownum = 7;
		int colnum = sheet.getRow(0).getLastCellNum();
		System.out.println("Number of Column is = "+ colnum);
		
		for(int i=1;i<rowcount;i++)
		 {	
			// row = sheet.createRow((rowcount+1));
			System.out.println("Costant number is = "+rownum);
			
			 for(int j=2;j<colnum;j++)
			 {
				 //row = sheet.getRow(i);				 
				 cell=sheet.createRow((rowcount)).getCell(j);
				 System.out.println("number of cell is "+ cell);
				 
					if(cell ==null )
					{
						System.out.println("cell is found NULL");
						sheet.getRow(rowcount-rownum).createCell(j).setCellValue(text[j]);
					}
					else {
						System.out.println("cell is NOT found NULL");
						sheet.createRow(rowcount+1).createCell(j).setCellValue(text[j]);
						
						}
			 }
			 
		 }
		 fos = new FileOutputStream(filename);
		 wb.write(fos);
		 fos.flush();
		 fos.close();
		
	
	}catch(Exception e) {
		System.out.println("Row and column is Empty");
		
	}

}
	
}
