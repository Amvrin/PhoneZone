package phonezoneproject_BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class BaseClass extends browserlistTest {
	

	
	
	@BeforeSuite
	public void opendriver() throws IOException, InterruptedException
	{
		Properties properties=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "/properties/config.properties");
		properties.load(fis);
	InvokeDriver(properties.getProperty("browser"));
		wd.get(properties.getProperty("baseURL"));
				
		Adminlogin_credential alc= new Adminlogin_credential();
		alc.login_Admin_page();
		
		
		
		
			
		
	}
	
	
	
	@AfterSuite
	public void quitedriver()
	{
		wd.quit();
	}

}
