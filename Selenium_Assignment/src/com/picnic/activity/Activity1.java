package com.picnic.activity;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Activity1 {

		public static void main(String[] args) throws InterruptedException, IOException {
			WebDriver driver = null;
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://demo.guru99.com/test/newtours/register.php");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			
			register(driver, "Kevin", "Rynjah", "9874563210", "kevin@gmail.com", "laban", "shillong", "meghalaya", "793004", "AUSTRALIA", "kevinr", "12345P");
			register(driver, "John", "Legend", "9874563210", "kevin@maveric-systems.com", "lumparin", "guwahati", "assam", "793024", "INDIA", "kevinr", "Passw123");
		
			driver.quit();
		}
			
			public static void register(WebDriver driver, String firstName,String lastName, String phone,String email,String adress,String city,
					String state,String postalCode,String country,String userName,String pass) throws IOException, InterruptedException {
				{
					
					WebElement fname = driver.findElement(By.xpath("//input[@name='firstName']"));
					WebElement lname = driver.findElement(By.xpath("//input[@name='lastName']"));
					WebElement phone1 = driver.findElement(By.xpath("//input[@name='phone']"));
					WebElement email1 = driver.findElement(By.xpath("//input[@name='userName']"));
					WebElement address = driver.findElement(By.xpath("//input[@name='address1']"));
					WebElement city1 = driver.findElement(By.xpath("//input[@name='city']"));
					WebElement state1 = driver.findElement(By.xpath("//input[@name='state']"));
					WebElement pin_code = driver.findElement(By.xpath("//input[@name='postalCode']"));
					WebElement country1 = driver.findElement(By.xpath("//select[@name='country']"));
					WebElement username = driver.findElement(By.xpath("//input[@name='email']"));
					WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
					WebElement confirm_password = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
				
					fname.sendKeys(firstName);
					lname.sendKeys(lastName);
					phone1.sendKeys(phone);
					email1.sendKeys(email);
					address.sendKeys(adress);
					city1.sendKeys(city);
					state1.sendKeys(state);
					pin_code.sendKeys(postalCode);
					country1.click();
					Select sc = new Select(country1);
					sc.selectByValue(country);	
					username.sendKeys(userName);
					password.sendKeys(pass);
					confirm_password.sendKeys(pass);
					screenshot(driver);
						}
					List<WebElement> list= driver.findElements(By.xpath("//select//option"));
					int size = list.size();
					for(int i=1;i<=size;i++)
					{
						String str = driver.findElement(By.xpath("//select//option["+i+"]")).getText();
						System.out.println(str);
					}
					WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
					submit.click();
					Thread.sleep(4000);
					Assert.assertEquals("Note: Your user name is "+userName+".",driver.findElement(By.xpath("//b[text()=' Note: Your user name is "+userName+".']")).getText());
					screenshot(driver); 
					System.out.println("Registered successfully");
					driver.get("http://demo.guru99.com/test/newtours/register.php");
					Thread.sleep(3000);
			
	}
		public static void screenshot(WebDriver driver) throws IOException
		{
			int count = 1;
			File fill=new File("C:\\Users\\Acer\\Desktop\\Screenshots");
			String[] str = fill.list();
			if(str.length!=0) {
				count = (str.length) + count;
			}
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			
			File SrcFile =scrShot.getScreenshotAs(OutputType.FILE);
			
			File DestFile = new File("C:\\Users\\Acer\\Desktop\\Screenshots"+count+".png");
			
		    Files.copy(SrcFile,DestFile);
			count++;
		}
}
