package phonezone_TestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import phonezoneproject_BaseClass.BaseClass;

public class Admin_PM_Add_New_Category extends BaseClass {

	private static Properties locatorprop = new Properties();
	private static FileInputStream fis;

	static WebDriverWait wait;

	static {
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/properties/locators.properties");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try {
			locatorprop.load(fis);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Test(priority = 9)
	public void go_to_side_nav_bar() throws Throwable {
		wait = new WebDriverWait(wd, 30);
		WebElement sidenav = wd.findElement(By.xpath(locatorprop.getProperty("side_nav")));
		wait.until(ExpectedConditions.visibilityOf(sidenav));

		List<WebElement> litag = sidenav.findElements(By.xpath("li/a"));

		for (int i = 0; i < litag.size(); i++) {
			System.out.println(i + ". " + litag.get(i).getText());

			if (litag.get(i).getText().equals("Product Management")) {

				//
				Assert.assertEquals(litag.get(i).getText(), "Product Management");
				System.out.println("PASS = " + litag.get(i).getText());
				litag.get(i).click();
				takescreenshot();
				break;
			}

		}
	}

	@Test(priority = 10)
	public void edit_Add_new_category() throws Throwable {

		wd.findElement(By.xpath(locatorprop.getProperty("add_new_category"))).click();
		String addNCtext = wd.findElement(By.xpath(locatorprop.getProperty("heading3"))).getText();
		takescreenshot();
		Assert.assertEquals("Add Category", addNCtext);

	}

	@Test(priority = 11)
	public void verify_all_elements_exsist_in_Add_New_category() throws Throwable {

		List<WebElement> labellist = wd.findElements(By.xpath(locatorprop.getProperty("ANC_label")));

		for (int i = 0; i < labellist.size(); i++) {
			if (labellist.get(i).isDisplayed() == true) {
				System.out.println(i + ". PASS = " + labellist.get(i).getText());
				takescreenshot();
			} else { takescreenshot();
				System.out.println(i + ". FAIL = " + labellist.get(i).getText());}

		}
		List<WebElement> inputlist = wd.findElements(By.xpath(locatorprop.getProperty("ANC_input")));
		for (int j = 0; j < inputlist.size(); j++) {
			if (inputlist.get(j).isDisplayed() == true) {
				takescreenshot();
				System.out.println(j + ". PASS = " + inputlist.get(j).getText());
			} else { takescreenshot();
				System.out.println(j + ". FAIL = " + inputlist.get(j).getText());}

		}

	}

	@Test(priority = 12)
	public void verify_the_submit_btn_set_empty_feilds() throws Throwable {
		wd.findElement(By.xpath(locatorprop.getProperty("ANC_inputbtn"))).click();
		takescreenshot();
		Boolean alerttext = wait.until(ExpectedConditions.textToBePresentInElement(
				wd.findElement(By.xpath(locatorprop.getProperty("ANC_alertmsg"))),
				wd.findElement(By.xpath(locatorprop.getProperty("ANC_alertmsg"))).getText()));

		if (alerttext == true) {
			takescreenshot();
			System.out.println("PASS = " + wd.findElement(By.xpath(locatorprop.getProperty("ANC_alertmsg"))).getText());
		} else {takescreenshot();
			System.out.println("FAIL = " + wd.findElement(By.xpath(locatorprop.getProperty("ANC_alertmsg"))).getText());}
		
		

	}

	@Test(priority = 13)
	public void verify_the_submit_btn_set_all_feilds() throws Throwable {

		//wd.findElement(By.xpath(locatorprop.getProperty("ANC_grand_parent_id1"))).click();
		List<WebElement> ANC_grand_parent_id = wd
				.findElements(By.xpath(locatorprop.getProperty("ANC_grand_parent_id")));
		for (int j = 1; j < ANC_grand_parent_id.size(); j++) {

			Select select1 = new Select(wd.findElement(By.xpath(locatorprop.getProperty("ANC_grand_parent_id1"))));
						select1.selectByIndex(j);
						takescreenshot();
						Thread.sleep(1000);

			//wd.findElement(By.xpath(locatorprop.getProperty("ANC_categories_id1"))).click();
			List<WebElement> ANC_categories_id = wd
					.findElements(By.xpath(locatorprop.getProperty("ANC_categories_id")));

			for (int k = 1; k < ANC_categories_id.size(); k++) {
				Thread.sleep(1000);
				Select select2 = new Select(wd.findElement(By.xpath(locatorprop.getProperty("ANC_categories_id1"))));
				select2.selectByIndex(k);
				takescreenshot();
				wd.findElement(By.xpath(locatorprop.getProperty("ANC_textbox_catogory"))).clear();
				wd.findElement(By.xpath(locatorprop.getProperty("ANC_textbox_catogory"))).sendKeys("test1");
				takescreenshot();
				//wd.findElement(By.xpath(locatorprop.getProperty("ANC_status1"))).click();
				List<WebElement> ANC_status = wd.findElements(By.xpath(locatorprop.getProperty("ANC_status")));

				for (int l = 1; l < ANC_status.size(); l++) {
					
					Select select3 = new Select(wd.findElement(By.xpath(locatorprop.getProperty("ANC_status1"))));
					select3.selectByIndex(l);
					takescreenshot();
					
					try {
					wd.switchTo().alert();
					}catch(Exception e) {
						System.out.println("Alert is not coming or available");
					}
					wd.findElement(By.xpath(locatorprop.getProperty("ANC_inputbtn"))).click();
					Thread.sleep(5000);
					Boolean responsetext = wait.until(ExpectedConditions.textToBePresentInElement(
							wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))),
							wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText()));
					takescreenshot();
					if (responsetext == true) {
						
						System.out.println("PASS = " + wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText());
						takescreenshot();
					} else { 
						System.out.println("FAIL = " + wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText());
						takescreenshot();
					}

				}
			}
		}

	}

}
