package com.picnic.activity;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4 {

	public static void main(String[] args){
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		
		try {
			driver.manage().window().maximize();
			WebElement newWindow =	driver.findElement(By.id("button1"));
			
			newWindow.click();
			
			Set<String> Windows  = driver.getWindowHandles();
		
			System.out.println(Windows.size());
			String parrentWindow = driver.getWindowHandle(); 
			
			Windows.remove(parrentWindow);
			driver.switchTo().window(Windows.iterator().next());
		}catch (NoSuchElementException e) {
			System.out.println(e);
		}catch (NoSuchWindowException e) {
			System.out.println(e);
		}catch (ElementNotVisibleException e) {
			System.out.println(e);
		}catch(TimeoutException e){
			System.out.println(e);
		}
	
	}
		}
