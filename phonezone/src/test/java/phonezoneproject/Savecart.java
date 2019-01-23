package phonezoneproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(priority=1)
public class Savecart extends BaseClass{
	
	/*public void cartsave() throws InterruptedException
	{
		Viewcart vc = new Viewcart();
		vc.staffcart();
	}*/
	@Test(priority=2)
	public void cart() throws InterruptedException
	{
			
		System.out.println("Testing side 2");
		Thread.sleep(5000);
		wd.findElement(By.xpath("//a[@class='btn btn-primary btn-lg btn_style btn_style-2']")).click();
		wd.findElement(By.xpath("//input[@id='email']")).sendKeys("averma@topsource.net");		
		wd.findElement(By.xpath("//input[@id='password']")).sendKeys("Qwerty123");
		wd.findElement(By.xpath("//button[@type='submit']")).click();
		
		List<WebElement> Select_Store=wd.findElements(By.xpath(".//div[@class='modal-dialog']//ul//a"));

		for(int i=0;i<Select_Store.size();i++)
		{
			System.out.println(i+". "+Select_Store.get(i).getText());
		}                   

		Select_Store.get(0).click();
		System.out.println(wd.findElement(By.xpath(".//div[@class='tables']//h3")).getText());
		Assert.assertEquals(wd.findElement(By.xpath(".//div[@class='tables']//h3")).getText(), "Recent Order Listing");
		Thread.sleep(5000);
		wd.findElement(By.xpath(".//a[contains(text(),'Store Management')]")).click();
		wd.findElement(By.xpath(".//a[contains(text(),'Place New Order')]")).click();
		Thread.sleep(5000);

		/* Selecting the dropdowns  */

		Select dd=new Select(wd.findElement(By.xpath(".//*[@id='categories_id']")));
		//dd.selectByVisibleText("Accessories");


		dd.selectByVisibleText("Cases");
		Thread.sleep(3000);
		/*dd.selectByVisibleText("Repairs");
		dd.selectByVisibleText("Staiotnary Others");*/

		Select scdd=new Select(wd.findElement(By.xpath(".//*[@id='sub_categories_id']")));
		Thread.sleep(2000);
		scdd.selectByVisibleText("Apple");
		/*scdd.selectByVisibleText("IPADS");
		scdd.selectByVisibleText("IPOD");
		scdd.selectByVisibleText("SAMSUNG CASES");*/

		/*scdd.selectByVisibleText("Glass Screen Protectors");			
		scdd.selectByVisibleText("Chargers");
		Thread.sleep(3000);
		scdd.selectByVisibleText("Earpods/Headphones");
		scdd.selectByVisibleText("Computer Accessories");
		scdd.selectByVisibleText("Phone Holders");
		scdd.selectByVisibleText("USB Drives/Memory Cards");
		scdd.selectByVisibleText("Genral Items");
		scdd.selectByVisibleText("Speakers");
		scdd.selectByVisibleText("Addon Camera");*/
		Thread.sleep(2000);
		Select sscdd=new Select(wd.findElement(By.xpath(".//*[@id='sub_sub_categories_id']")));
		sscdd.selectByVisibleText("iPhone 5/5S/SE Cases");
		/*sscdd.selectByVisibleText("iPhone 5C Cases");
		sscdd.selectByVisibleText("iPhone 6/6S Cases");
		sscdd.selectByVisibleText("iPhone 6/6S Plus Cases ");
		sscdd.selectByVisibleText("iPhone 7/8 Cases");
		sscdd.selectByVisibleText("iPhone 7/8 Plus Cases");
		sscdd.selectByVisibleText("iPhone X");
		sscdd.selectByVisibleText("iPhone XR");
		sscdd.selectByVisibleText("iPhone XS MAX");*/
		wd.findElement(By.xpath(".//div[@class='form-group']//button[@value='Search']")).click();
		Thread.sleep(3000);
		for(int i=0;i<=3;i++) {
			wd.findElement(By.xpath(".//div[@id='quantity_272']//button[@data-spin='up']")).click();
			wd.findElement(By.xpath(".//div[@id='quantity_273']//button[@data-spin='up']")).click();
		}
		wd.findElement(By.xpath(".//button[@id='save_cart']")).click();
		Thread.sleep(5000);
	}

}
