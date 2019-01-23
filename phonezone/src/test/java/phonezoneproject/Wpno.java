package phonezoneproject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Wpno extends BaseClass {
	@Test(priority=1)
	public void wsp() throws InterruptedException 
	{
		wd.findElement(By.xpath("//a[@class='btn btn-primary btn-lg btn_style btn_style-3 last-btn']")).click();
		wd.findElement(By.xpath("//input[@id='email']")).sendKeys("deepak.kumar@datagenius.co.nz");		
		wd.findElement(By.xpath("//input[@id='password']")).sendKeys("738hJ8oR");
		wd.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10000);
		
		wd.findElement(By.xpath(".//a[contains(text(),'Store Management')]")).click();
		wd.findElement(By.xpath(".//a[contains(text(),'Place New Order')]")).click();
		System.out.println(wd.findElement(By.xpath(".//div[@class='form-title']//h4")).getText());
		Thread.sleep(5000);
		Assert.assertEquals(wd.findElement(By.xpath(".//div[@class='form-title']//h4")).getText(), "Search Product");
		Thread.sleep(5000);
		System.out.println("Hello Search Product");

	} 


}
