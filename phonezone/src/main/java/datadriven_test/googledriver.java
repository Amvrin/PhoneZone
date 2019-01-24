package datadriven_test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;




public class googledriver extends passparameter {
	WebDriver driver;
	//@Test(dataProvider="getdata", dataProviderClass=passparameter.class)
	@Test(dataProvider="getdata")

	
	//public void printdata(String searchtext, String result, String time)
	/*public void printdata(String searchtext)

	{
		System.out.print(searchtext);
		System.out.print(result);
		System.out.println(time);
		System.out.println("**********************************************");
		
	}*/
	
	
	
	//@Test
	public void testrun(String searchtext, String text2) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		
		driver.get("http://www.google.com");
		driver.findElement(By.xpath(".//input[@name='q']")).sendKeys(searchtext);
		text2= driver.getTitle();
		System.out.println("second parameter is "+text2);
		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			driver.findElement(By.xpath(".//div//center//img")).click();
		}
		
		
		//System.out.println(result +" --- "+ time);
		try {
			driver.findElement(By.xpath("//*[@id=\"sbtc\"]/div[2]/div[2]/div[1]/div/ul/li[11]/div/span[1]/span/input")).click();
			
		}catch (Exception e) {
			driver.findElement(By.xpath(".//center//input[@type='submit'][1]")).click();
		}
		String resultstats = driver.findElement(By.xpath(".//div//div[@id='resultStats']")).getText();
		
		System.out.println("Result Status is " + resultstats);
		
		String [] splitstr = resultstats.split(" ");
		
		int x=splitstr.length;
		
		for(int i=0;i<x;i++)
		{
			System.out.println("Text is == "+ splitstr[i].trim());
		}
		
		System.out.println("**********************************************************************************");
		
String result =splitstr[1]; String ttk= splitstr[3];
		
		String [] writetext = {searchtext, text2,result,ttk};
		//passparameter write = new passparameter();
		
		passparameter.writecelldata(writetext);
		
driver.quit();
}
}
