package phonezoneproject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
@Test (priority= 1)
public class Wvcart extends BaseClass{

	/*@Test (priority= 1)
	public void wcart() throws InterruptedException
	{
		clicking on the staff button

		wd.findElement(By.xpath("//a[@class='btn btn-primary btn-lg btn_style btn_style-3 last-btn']")).click();
		wd.findElement(By.xpath("//input[@id='email']")).sendKeys("deepak.kumar@datagenius.co.nz");		
		wd.findElement(By.xpath("//input[@id='password']")).sendKeys("738hJ8oR");
		wd.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10000);
		System.out.println("Testing side 1");
	}*/

	@Test(priority= 2)
	public void wcartview() throws InterruptedException
	{
		String a ;
		
		wd.findElement(By.xpath("//a[@class='btn btn-primary btn-lg btn_style btn_style-3 last-btn']")).click();
		wd.findElement(By.xpath("//input[@id='email']")).sendKeys("deepak.kumar@datagenius.co.nz");		
		wd.findElement(By.xpath("//input[@id='password']")).sendKeys("738hJ8oR");
		wd.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10000);
		System.out.println("Testing side 1");
		

		Thread.sleep(12000);
		
		wd.findElement(By.xpath(".//a[contains(text(),'Store Management')]")).click();
		wd.findElement(By.xpath(".//a[contains(text(),'View Cart')]")).click();
		System.out.println(wd.findElement(By.xpath(".//div[@class='tables']//h3")).getText());
		Assert.assertEquals(wd.findElement(By.xpath(".//div[@class='tables']//h3")).getText(), "View Cart");
		System.out.println(wd.getTitle());
		a=wd.getTitle();
		Thread.sleep(5000);

		/* Checking whether the right page is opened or not*/

		if(a.equals("Phone Zone: User Panel:Phone Zone Panel"))
		{
			a=wd.getTitle();
			System.out.println("On cart :: "+a);
		}
		else
		{
			System.out.println("Why are you roaming");

		}
	}

}
