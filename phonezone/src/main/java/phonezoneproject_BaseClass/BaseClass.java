package phonezoneproject_BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass extends browserlistTest {

	@BeforeSuite
	public void opendriver() throws IOException, InterruptedException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/properties/config.properties");
		properties.load(fis);
		InvokeDriver(properties.getProperty("browser"));
		wd.get(properties.getProperty("baseURL"));

		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		  if (properties.getProperty("landing_page").equals("Staff")) {
		  wd.findElement(By.xpath(properties.getProperty("Staff_button"))).click();
		  
		  Stafflogin_credential slc = new Stafflogin_credential();
		  slc.login_Staff_page();
		  
		  } else if (properties.getProperty("landing_page").equals("Admin")) {
		 
		// wd.findElement(By.xpath(properties.getProperty("Admin_button"))).click();
		 
		 Adminlogin_credential alc = new Adminlogin_credential();
		 alc.login_Admin_page();
		} 
		 else if (properties.getProperty("landing_page").equals("Wholesaler")) {
		 wd.findElement(By.xpath(properties.getProperty("wholeseller_button"))).click(
		 ); } 
		 else System.out.println("Not the valid Page Name");
		 

	}

	@AfterSuite
	public void quitedriver() {
		wd.quit();
	}

	public void takescreenshot() throws Throwable {

		String modulename = wd.getCurrentUrl();
		String modname[] = modulename.split("/");

		/*for (int i = 0; i < modname.length; i++) {
			System.out.println(i + ". " + modname[i]);

			System.out.println("**********screenshot*********************");
		}*/

		String displayname = wd.findElement(By.xpath(".//div//h3")).getText();

		File srcfile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir") + "/screenshot_folder/" + modname[3] + "_"
				+ displayname + "_" + timestamp() + ".png"));
		/*
		 * if(modname.length>=4) { FileUtils.copyFile(srcfile, new
		 * File(System.getProperty("user.dir") +
		 * "/screenshot_folder/"+modname[3]+"_"+modname[4]+"_"+modname[5]+"_"+
		 * timestamp() + ".png")); } else if(modname.length<=4) {
		 * FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir") +
		 * "/screenshot_folder/"+modname[3]+"_"+modname[4]+"_"+ timestamp() + ".png"));
		 * 
		 * } else
		 * {System.out.println("Some thing went wrong in the Saving image file");}
		 */

	}

	public static String timestamp() {

		int day, HH, MM, SS, YYYY;
		String month[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

		GregorianCalendar gc = new GregorianCalendar();
		day = gc.get(Calendar.DATE);
		YYYY = gc.get(Calendar.YEAR);
		String monts = month[gc.get(Calendar.MONTH)];

		HH = gc.get(Calendar.HOUR_OF_DAY);
		MM = gc.get(Calendar.MINUTE);
		SS = gc.get(Calendar.SECOND);

		String time = YYYY + monts + day + HH + MM + SS;

		return time;

	}

}
