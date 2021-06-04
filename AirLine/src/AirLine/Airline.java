package AirLine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

// I have automated 1 scenario for flight from Boston to Rome. This can be generalized based on the user inputs
public class Airline {
public static void main(String args[]) {
	System.setProperty("webdriver.chrome.driver", "D:\\2june\\jars\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://blazedemo.com/");
	WebElement dropdownFrom = driver.findElement(By.name("fromPort"));
    dropdownFrom.findElement(By.xpath("//option[. = 'Boston']")).click();
    
    WebElement dropdownTo = driver.findElement(By.name("toPort"));
    dropdownTo.findElement(By.xpath("//option[. = 'Rome']")).click();
    
    driver.findElement(By.cssSelector(".btn-primary")).click();
    
    
     driver.findElement(By.cssSelector("tr:nth-child(1) .btn")).click();
     driver.findElement(By.id("inputName")).sendKeys("Customer1");
     
     driver.findElement(By.cssSelector(".btn-primary")).click();
     
     String confirmMsg;
     confirmMsg=driver.findElement(By.xpath("//div/h1")).getText(); //id
     
     if (confirmMsg.equals("Thank you for your purchase today!")) {
    	 System.out.println("Flight booked successfully, test case passed");
     }
     else
    	 System.out.println("Test Case Failed");
     
     //System.out.println(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText()); //id 
     //System.out.println(driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText()); // id value
   
     }
    
    
    }	




