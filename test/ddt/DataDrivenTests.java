package ddt;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.BeforeMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DataDrivenTests {
	WebDriver driver;
  @Test(dataProvider = "LoginData")
  public void loginTest(String user, String pass) {
		driver.findElement(By.id("loginname")).sendKeys(user);
		driver.findElement(By.id("loginpassword")).sendKeys(pass);
		driver.findElement(By.id("loginbutton")).click();
  }
    
  @BeforeMethod
  public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();//Opens the browser - represents one browser window
		driver.get("http://selenium-examples.nichethyself.com");
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider (name = "LoginData")
  public Object[][] readDataFromExternalSource() {
      Object[][] retObjArr=getTableArray("test\\resources\\data\\loginJXL.xls",
              "LoginData", "DataBoundry");
      return retObjArr;
  }
  
  public String[][] getTableArray(String xlFilePath, String sheetName, String tableName){
      String[][] tabArray=null;
      try{
          Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
          //Workbook class is provied by jxl.jar
          //WebDriver provided by Selenium 
          //File is class provided by Java to read a physical file
          Sheet sheet = workbook.getSheet(sheetName);
          Cell tableStart=sheet.findCell(tableName);
          
          int startRow,startCol, endRow, endCol,ci,cj;
          
          startRow=tableStart.getRow();//2
          startCol=tableStart.getColumn();//1

          Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                

          endRow=tableEnd.getRow();//7
          endCol=tableEnd.getColumn();//4
          System.out.println("startRow="+startRow+", endRow="+endRow+", " +
                  "startCol="+startCol+", endCol="+endCol);
          tabArray=new String[endRow-startRow-1][endCol-startCol-1];//4,2
          ci=0; //array row
          //ci=0,i=3, j=3,cj=1
          for (int i=startRow+1;i<endRow;i++,ci++){//i represents xls row
              cj=0;//array column
              for (int j=startCol+1;j<endCol;j++,cj++){//j represents xls column
                  tabArray[ci][cj]=sheet.getCell(j,i).getContents();
              }
          }
      }
      catch (Exception e)    {
          System.out.println("Please check if file path, sheet name and tag name are correct");
          
      }

      return(tabArray);
  }
  
  public static Collection<String[]> getTestData(String fileName) throws IOException {
		List<String[]> records = new ArrayList<String[]>();
		String record;
		// FileReader is meant for reading streams of characters(reading text files)
		// FileReader myReader = new FileReader(fileName);
		// A BufferedReader object takes a FileReader object as 
		// an input which contains all the necessary information 
		// about the text file that needs to be read.
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		while ((record=file.readLine())!=null) {//record = "stc123,12345"
		 	String fields[] = record.split(",");//split() method is inside String class
			records.add(fields);
		}
		file.close();
		return records;
	}
}
