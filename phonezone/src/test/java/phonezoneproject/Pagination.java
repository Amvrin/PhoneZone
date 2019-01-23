package phonezoneproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Pagination extends BaseClass {
	@Test(priority = 2)
	public void staff() throws InterruptedException {
		wd.findElement(By.xpath("//a[@class='btn btn-primary btn-lg btn_style btn_style-2']")).click();
		wd.findElement(By.xpath("//input[@id='email']")).sendKeys("averma@topsource.net");		
		wd.findElement(By.xpath("//input[@id='password']")).sendKeys("Qwerty123");
		wd.findElement(By.xpath("//button[@type='submit']")).click();
		

		System.out.println("Testing side 2");
		List<WebElement> Select_Store = wd.findElements(By.xpath(".//div[@class='modal-dialog']//ul//a"));

		for (int i = 0; i < Select_Store.size(); i++) {
			System.out.println(i + ". " + Select_Store.get(i).getText());
		}

		Select_Store.get(0).click();
		System.out.println(wd.findElement(By.xpath(".//div[@class='tables']//h3")).getText());
		Assert.assertEquals(wd.findElement(By.xpath(".//div[@class='tables']//h3")).getText(), "Recent Order Listing");
		Thread.sleep(5000);
		wd.findElement(By.xpath(".//a[contains(text(),'Store Management')]")).click();
		wd.findElement(By.xpath(".//a[contains(text(),'Place New Order')]")).click();
		/*
		 * Assert.assertEquals(wd.findElement(By.
		 * xpath(".//div[@class='title1 margin-top-29']//h3")).getText(),
		 * "Search Results"); System.out.println(wd.findElement(By.
		 * xpath(".//div[@class='title1 margin-top-29']//h3")).getText());
		 */

		for (int i = 2; i <= 126; i++) {
			Thread.sleep(2000);
			wd.findElement(By.xpath(".//div[@class='loader_paging']//a[text()=" + i + "]")).click();
			System.out.println(i + ". Pagination for staff complete");

		}

	}

	@Test(priority = 1)
	public void wholeseller() throws InterruptedException {
		//System.out.println("Aji Ha");
		wd.findElement(By.xpath("//a[@class='btn btn-primary btn-lg btn_style btn_style-3 last-btn']")).click();
		wd.findElement(By.xpath("//input[@id='email']")).sendKeys("deepak.kumar@datagenius.co.nz");		
		wd.findElement(By.xpath("//input[@id='password']")).sendKeys("738hJ8oR");
		wd.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10000);
		
		wd.findElement(By.xpath(".//a[contains(text(),'Store Management')]")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath(".//a[contains(text(),'Place New Order')]")).click();
		/*
		 * Assert.assertEquals(wd.findElement(By.
		 * xpath(".//div[@class='title1 margin-top-29']//h3")).getText(),
		 * "Search Results"); System.out.println(wd.findElement(By.
		 * xpath(".//div[@class='title1 margin-top-29']//h3")).getText());
		 */
		
		for (int i = 2; i <= 126; i++) {
			Thread.sleep(2000);
			wd.findElement(By.xpath(".//div[@class='loader_paging']//a[text()=" + i + "]")).click();
			System.out.println(i + ". Pagination for WholeSeller complete");
		}
		// wd.quit();

	}

}
