package phonezoneproject_BaseClass;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ObjectRepository_PZ.OB_LandingPage;
import ObjectRepository_PZ.OB_LoginPage;
import ObjectRepository_PZ.OB_WholesellerPage;

public class WholesellerDashboardTest extends BaseClass
{
	
	
	@Test(priority=0)
	public void wholesellerLogin() throws InterruptedException, IOException
	{
		OB_LandingPage obj_OB_LandingPage = new OB_LandingPage(wd);
		OB_LoginPage obj_OB_LoginPage = new OB_LoginPage(wd);
		String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.jpeg'").format(new Date());
		
		
		obj_OB_LandingPage.wholeseller_button().click();
		Thread.sleep(3000);
		obj_OB_LoginPage.EmailInput().sendKeys("deepak.kumar@datagenius.co.nz");
		obj_OB_LoginPage.PasswordInput().sendKeys("738hJ8oR");
		obj_OB_LoginPage.LoginButton().click();
		
		
		//Taking a screenshot
		//Convert web driver object to TakeScreenshot

        capture("Wholeseller_0_",filename);
        
    	Thread.sleep(3000);
		
	}


	
	
	
	@Test(priority=1)
	public void DashboardViaSideMenu() throws InterruptedException, IOException
	{
		
		
		OB_WholesellerPage obj_OB_WholesellerPage = new OB_WholesellerPage(wd);
		obj_OB_WholesellerPage.sideMenuDashboardLink().click();
		Thread.sleep(2000);
		capture("Wholeseller_1_",filename);
	}
	
	
}
