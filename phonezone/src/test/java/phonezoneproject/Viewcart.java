package phonezoneproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Viewcart extends BaseClass {
	@Test (priority= 1)
	public void staffcart() throws InterruptedException
	{

		/*clicking on the staff button*/

		wd.findElement(By.xpath("//a[@class='btn btn-primary btn-lg btn_style btn_style-2']")).click();
		wd.findElement(By.xpath("//input[@id='email']")).sendKeys("averma@topsource.net");		
		wd.findElement(By.xpath("//input[@id='password']")).sendKeys("Qwerty123");
		wd.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("Testing side 1");
	}

	@Test(priority= 2)
	public void cartview() throws InterruptedException
	{
		String a ;

		/*Handling the weblElements */

		System.out.println("Testing side 2");
		Thread.sleep(10000);
		List<WebElement> Select_Store=wd.findElements(By.xpath(".//div[@class='modal-dialog']//ul//a[@id='Stores_12']"));
		Thread.sleep(15000);
		System.out.println("Testing side 3");
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
		wd.findElement(By.xpath(".//a[contains(text(),'View Cart')]")).click();
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


