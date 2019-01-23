package phonezoneproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Plt extends BaseClass {
	@Test()
	public void sear() throws InterruptedException
	{
		wd.findElement(By.xpath("//a[@class='btn btn-primary btn-lg btn_style btn_style-2']")).click();
		wd.findElement(By.xpath("//input[@id='email']")).sendKeys("averma@topsource.net");		
		wd.findElement(By.xpath("//input[@id='password']")).sendKeys("Qwerty123");
		wd.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Testing side 1");
			
	
	
	/*@Test(priority= 2)
	public void sear1() throws InterruptedException
	{*/
		String a ;

		/*Handling the weblElements */

		System.out.println("Testing side 2");
		List<WebElement> Select_Store=wd.findElements(By.xpath(".//div[@class='modal-dialog']//ul//a[@id='Stores_12']"));

		/* Printing the total items on the WebElements*/

		for(int i=0;i<Select_Store.size();i++)
		{
			System.out.println(i+". "+Select_Store.get(i).getText());
		}
		Select_Store.get(0).click();

		/* Clicking on the WebElement form */

		System.out.println(wd.findElement(By.xpath(".//div[@class='forms']//h3")).getText());
		Assert.assertEquals(wd.findElement(By.xpath(".//div[@class='forms']//h3")).getText(), "Recent Order Listing");
		Thread.sleep(5000);
		wd.findElement(By.xpath(".//a[contains(text(),'Store Management')]")).click();
		wd.findElement(By.xpath(".//a[contains(text(),'Place New Order')]")).click();
		wd.findElement(By.xpath(".//input[@id='product_name']")).click();
		wd.findElement(By.xpath(".//input[@id='product_name']")).sendKeys("ABC");
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
