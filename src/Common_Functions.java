import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Common_Functions {
	public static String navigatetoUrl(WebDriver driver,String URL){
		//WebDriver dr = new FirefoxDriver();
		driver.manage().window().maximize();
		//dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(URL);
		return null;
			}
	public static String click_element(WebDriver driver,String strloctype,String strlocvalue)
	{
		switch(strloctype)
		{
		case"id":
			driver.findElement(By.id(strlocvalue)).click();
			break;
		case"x-path":
			driver.findElement(By.xpath(strlocvalue)).click();
			break;
		case"Linktext":
			driver.findElement(By.linkText(strlocvalue)).click();
			break;
		}
		return null;
		
	}
	public static String entertext(WebDriver driver,String strloctype,  String locvalue,String data)
	{
		switch(strloctype)
		{
		case"id":
			driver.findElement(By.id(locvalue)).sendKeys(data);
			break;
		case"x-path":
			driver.findElement(By.xpath(locvalue)).sendKeys(data);
			break;
		case"Linktext":
			driver.findElement(By.linkText(locvalue)).sendKeys(data);
			break;
		}
		return null;
	}
		public static void closeapp(WebDriver driver)
		{
			driver.quit();
		}
		
		public static String[][] ReadExcelData(String path) throws IOException{
			File excel = new File(path);
			FileInputStream fis = new FileInputStream(excel);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet ws = wb.getSheet("Sheet1");
			int rowNum= ws.getLastRowNum()+1;
			int colNum=ws.getRow(0).getLastCellNum();
			String[][] data = new String [rowNum][colNum];
					
						for(int i=0;i<rowNum;i++)
			{
				HSSFRow row =ws.getRow(i);
				for(int j=0;j<colNum;j++){
					HSSFCell cell=row.getCell(j);
					String value=cellToString(cell);
					data[i][j]=value;
				}
				
				System.out.println("Value is"+data[i][0]+data[i][1]);
				// To Write data
				HSSFCell cell1 = row.createCell(5);
				cell1.setCellType(cell1.CELL_TYPE_STRING);
				cell1.setCellValue("Test1");
				FileOutputStream fos =new FileOutputStream("D://Writing.xls");
				wb.write(fos);
				fos.close();
			}
						wb.close();
						fis.close(); 
						return data;
				}
						//return null;
								
					
			
		private static String cellToString(HSSFCell cell) {
			int type;
			Object result;
			String strReturn = null;
			if(cell==null)
			{
				strReturn="";
			}
			else
			{
				switch(cell.getCellType())
				{
				case Cell.CELL_TYPE_NUMERIC://numeric
					result=cell.getNumericCellValue();
					strReturn = result.toString();
					break;
					
				case Cell.CELL_TYPE_STRING:
					result=cell.getStringCellValue();
					strReturn = result.toString();
					break;
					default:
						strReturn=null;
				}			
				}
			return strReturn;
		}
		
		
		
		
}

		
