package phonezoneproject_BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class BaseClass extends browserlistTest {
	

	
	
	@BeforeMethod
	public void opendriver() throws IOException
	{
		Properties properties=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "/properties/config.properties");
		properties.load(fis);
	InvokeDriver(properties.getProperty("browser"));
		wd.get(properties.getProperty("baseURL"));
		
		
		/*
		 * wd.findElement(By.xpath(locatorprop.getProperty("Admin_button"))).click();
		System.out.println(wd.getTitle());
		wd.findElement(By.xpath(locatorprop.getProperty("Admin_username"))).clear();
		wd.findElement(By.xpath(locatorprop.getProperty("Admin_username"))).sendKeys(configprop.getProperty("username"));
		wd.findElement(By.xpath(locatorprop.getProperty("Admin_password"))).clear();
		wd.findElement(By.xpath(locatorprop.getProperty("Admin_password"))).sendKeys(configprop.getProperty("password"));
		wd.findElement(By.xpath(locatorprop.getProperty("Admin_login"))).click();
		System.out.println("welcome_to_Admin_page");
		 */
		
		
		
		
			
		
	}
	
	
	
	@AfterMethod
	public void quitedriver()
	{
		wd.quit();
	}

}
