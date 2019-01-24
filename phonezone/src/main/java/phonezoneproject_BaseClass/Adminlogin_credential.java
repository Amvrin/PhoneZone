package phonezoneproject_BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Adminlogin_credential extends BaseClass{
	
	
	private static  Properties locatorprop =new Properties();
	private static FileInputStream fis;
	
	static {
        try {
        	fis=new FileInputStream(System.getProperty("user.dir")+ "/properties/locators.properties");
        	
        } catch (FileNotFoundException e) {
        	
            e.printStackTrace();
        } 
        
        try {
        	locatorprop.load(fis);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       
    }
	
	private static  Properties configprop =new Properties();
	static {
        try {
        	fis=new FileInputStream(System.getProperty("user.dir")+ "/properties/config.properties");
        	
        } catch (FileNotFoundException e) {
        	
            e.printStackTrace();
        } 
        
        try {
        	configprop.load(fis);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       
    }
	

	public void login_Admin_page() throws InterruptedException
	{
		System.out.println(wd.getTitle());
		wd.findElement(By.xpath(locatorprop.getProperty("Admin_username"))).clear();
		wd.findElement(By.xpath(locatorprop.getProperty("Admin_username"))).sendKeys(configprop.getProperty("username"));
		wd.findElement(By.xpath(locatorprop.getProperty("Admin_password"))).clear();
		wd.findElement(By.xpath(locatorprop.getProperty("Admin_password"))).sendKeys(configprop.getProperty("password"));
		wd.findElement(By.xpath(locatorprop.getProperty("Admin_login"))).click();
	
	}

}
