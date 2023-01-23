package TestNGTutorials;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;									

public class DataProvideFromExcelNotHardCoded 
{
	
	@Test
	public Object[][] getDataFromExcel() throws IOException
		{
			//Object is the superset of all the data
			//Object[][] data= {{"hello","text",1},{"bye","message",143},{"solo","call",453} };
			FileInputStream fis= new FileInputStream("D://Testing_Practice//RahulShetty_tutorial_DDT From Excel//SampleDataFromExceltoUSedataProvider.xlsx");
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheetAt(0);
			int rowCount=sheet.getPhysicalNumberOfRows();
			XSSFRow row= sheet.getRow(0);
			int colcount=row.getLastCellNum();
			Object data[][]= new Object[rowCount-1][colcount];
			
			for (int i=0;i<rowCount-1;i++) 
			{
				//System.out.println("This is outer loop");
				row=sheet.getRow(i+1);
				for (int j=0;i<colcount;j++) 
				{
					data[i][j]=  row.getCell(j);
					
				}
				
				
			}
		
			return data;
		}
	
	

}
