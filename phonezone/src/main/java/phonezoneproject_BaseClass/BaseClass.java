package phonezoneproject_BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.By;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class BaseClass extends browserlistTest {
	

	String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.jpeg'").format(new Date());
	
	@BeforeSuite
	public void opendriver() throws IOException, InterruptedException
	{
		Properties properties=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "/properties/config.properties");
		properties.load(fis);
	InvokeDriver(properties.getProperty("browser"));
		wd.get(properties.getProperty("baseURL"));
				
		//Adminlogin_credential alc= new Adminlogin_credential();
		//alc.login_Admin_page();
		
		
		
		
			
		
	}
	
	
	public void capture(String module,String filename) throws IOException 
	{
		TakesScreenshot scrShot =((TakesScreenshot)wd);

        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        
        //Move image file to new destination
        File DestFile=new File("D:\\screenshots\\"+module+filename);
        
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
	}
	
	@AfterSuite
	public void quitdriver()
	{
		wd.quit();
	}

}
