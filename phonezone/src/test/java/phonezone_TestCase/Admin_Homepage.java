package phonezone_TestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import phonezoneproject_BaseClass.Adminlogin_credential;
import phonezoneproject_BaseClass.BaseClass;

public class Admin_Homepage extends BaseClass {
	
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
	
	
	@Test
	public void special_order () throws InterruptedException
	{
	Thread.sleep(10000);
		System.out.println("welcome_to_Admin_page");
		
		
		
	}

}
