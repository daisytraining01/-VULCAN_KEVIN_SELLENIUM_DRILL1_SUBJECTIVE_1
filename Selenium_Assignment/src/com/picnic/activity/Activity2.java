package com.picnic.activity;

import com.codoid.products.fillo.Fillo;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
//import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Activity2 {

	public static void main(String[] args) throws InterruptedException, FilloException, IOException {
		
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/sql/sql_and_or.asp");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		XSSFWorkbook wb = null; 
		
		XSSFSheet sh = null;
		XSSFCell cell = null;
		String s1=null,s2=null,s3=null;
		//sh.createRow(0).createCell(0).setCellValue("Age")
		List<WebElement> listrow = driver.findElements(By.xpath("//table[@class='w3-table-all notranslate']//tr"));
		int sizerow = listrow.size();
		System.out.println(sizerow);
		List<WebElement> listcol = driver.findElements(By.xpath("//table[@class='w3-table-all notranslate']//tr//td"));
		int sizecol = listcol.size();
		System.out.println(sizecol);
		for(int i=2; i<= sizerow; i++)
		{
			for(int j=1; j<=7 ;j++)
			{
				String heading = driver.findElement(By.xpath("//table[@class='w3-table-all notranslate']//tr["+1+"]//th["+j+"]")).getText();
				String row = driver.findElement(By.xpath("//table[@class='w3-table-all notranslate']//tr["+i+"]//td["+j+"]")).getText();
				//String col = driver.findElement(By.xpath("//table[@class='w3-table-all notranslate']//tr["+i+"]")).getText();
				System.out.println(heading);
				System.out.println(row);
				//ell = sh.getRow(i).getCell(j);
				updateExcel("Data",heading,row);
			}
			break;
		}
		
	}
		/* private static void updateExcel(String SheetName,XSSFCell createCell, String value) throws FilloException {
				String TestDataLocation="C:\\Users\\Acer\\Desktop\\Screenshots\\Activity2.xlsx";
				Fillo fillo=new Fillo();
				Connection connection=fillo.getConnection(TestDataLocation);
				String DataQuery="Update "+SheetName+" Set "+createCell+"='"+value+"'";
				System.out.println("query:"+DataQuery);
				connection.executeUpdate(DataQuery);
				connection.close();
		
	}*/
		public static void  updateExcel( String SheetName,String heading,String object) throws FilloException
			{
				String TestDataLocation="C:\\Users\\Acer\\Desktop\\Screenshots\\Activity2.xlsx";
				Fillo fillo=new Fillo();
				Connection connection=fillo.getConnection(TestDataLocation);
				String DataQuery = "Update "+ SheetName +" Set "+ heading +"='"+ object +"'";
				//String DataQuery = "INSERT INTO "+ SheetName(fieldName) +" VALUES "+ (value) +"'";
				//String DataQuery="Update "+SheetName+" Set "+fieldName+"='"+value+"'  Where TestData_Key='"+DataBinder+"'";
				//"INSERT INTO Sheet1(Name,Course) VALUES('RAMESH','SELENIUM WITH JAVA')";
				
				System.out.println("query:"+DataQuery);
				connection.executeUpdate(DataQuery);
				connection.close();
			}
		
		
		
		
	}
	

