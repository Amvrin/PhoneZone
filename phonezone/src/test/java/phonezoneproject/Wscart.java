package phonezoneproject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
@Test(priority=1)
public class Wscart extends BaseClass {
/*@Test(priority=1)
	public void wsvcart() throws InterruptedException
	{
		Wvcart wsc = new Wvcart();
		wsc.wcart();
		Thread.sleep(10000);
	}*/
@Test(priority=2)
	public void wscs() throws InterruptedException
	{
	Thread.sleep(5000);
	wd.findElement(By.xpath("//a[@class='btn btn-primary btn-lg btn_style btn_style-3 last-btn']")).click();
	wd.findElement(By.xpath("//input[@id='email']")).sendKeys("deepak.kumar@datagenius.co.nz");		
	wd.findElement(By.xpath("//input[@id='password']")).sendKeys("738hJ8oR");
	wd.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(10000);
	
	    Thread.sleep(5000);
		wd.findElement(By.xpath(".//a[contains(text(),'Store Management')]")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath(".//a[contains(text(),'Place New Order')]")).click();

		Select dd=new Select(wd.findElement(By.xpath(".//*[@id='categories_id']")));

		dd.selectByVisibleText("Cases");
		Thread.sleep(3000);
		Select scdd=new Select(wd.findElement(By.xpath(".//*[@id='sub_categories_id']")));
		Thread.sleep(2000);
		scdd.selectByVisibleText("Apple");

		Thread.sleep(2000);
		Select sscdd=new Select(wd.findElement(By.xpath(".//*[@id='sub_sub_categories_id']")));
		sscdd.selectByVisibleText("iPhone 5/5S/SE Cases");
		wd.findElement(By.xpath(".//div[@class='form-group']//button[@value='Search']")).click();
		Thread.sleep(1000);

		for(int i=1;i<=3;i++) {
			Thread.sleep(10000);
			wd.findElement(By.xpath("//tr["+i+"]//button[contains(text(),'+')]")).click();
			System.out.println("Item-"+i);
			
		}
		

		wd.findElement(By.xpath(".//button[@id='save_cart']")).click();
		Thread.sleep(15000);

	}

}
