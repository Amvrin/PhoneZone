package phonezone_TestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import phonezoneproject_BaseClass.Adminlogin_credential;
import phonezoneproject_BaseClass.BaseClass;

public class Admin_Special_Order extends BaseClass {

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

	@Test(priority = 1)
	public void Verify_side_navigation_bar_special_order() throws Throwable {
		wait = new WebDriverWait(wd, 30);
		WebElement sidenav = wd.findElement(By.xpath(locatorprop.getProperty("side_nav")));
		wait.until(ExpectedConditions.visibilityOf(sidenav));

		List<WebElement> litag = sidenav.findElements(By.xpath("li/a"));

		for (int i = 0; i < litag.size(); i++) {
			System.out.println(i + ". " + litag.get(i).getText());

			if (litag.get(i).getText().equals("Special Order")) {
				Assert.assertEquals(litag.get(i).getText(), "Special Order");
				System.out.println("Found the " + litag.get(i).getText());
				litag.get(i).click();
				takescreenshot();
				break;
			}

		}

	}

	@Test(priority = 2)
	public void click_on_the_send_special_order() throws Throwable {
		wd.findElement(By.xpath(locatorprop.getProperty("click_send_special_order"))).click();
		String headingtext2 = wd.findElement(By.xpath(locatorprop.getProperty("click_send_special_order"))).getText();

		String headingtext1 = wd.findElement(By.xpath(locatorprop.getProperty("heading3"))).getText();
		takescreenshot();
		Assert.assertEquals(headingtext2, headingtext1, "PASS");

	}

	@Test(priority = 3)
	public void verify_the_elements_is_exsist() throws Throwable {

		WebElement headingtext4 = wd.findElement(By.xpath(locatorprop.getProperty("heading4_sendspecial")));
		if (headingtext4.isDisplayed() == true) {
			Assert.assertEquals(headingtext4.getText(), "Send Special Order to all store");
			System.out.println("Element is exist " + headingtext4.getText() + " PASS");
			takescreenshot();
		}

		else
			{System.out.println("Element is not exist " + headingtext4.getText() + " FAIL");
		takescreenshot();}

		WebElement table_sendspecialordertoall_1 = wd
				.findElement(By.xpath(locatorprop.getProperty("table_sendspecialordertoall_1")));
		if (table_sendspecialordertoall_1.isDisplayed() == true) {
			takescreenshot();
			System.out.println("Element is exist  PASS");
			
		}

		else {takescreenshot();
			System.out.println("Element is not exist  FAIL");}

		WebElement table_sendspecialordertoall_2 = wd
				.findElement(By.xpath(locatorprop.getProperty("table_sendspecialordertoall_2")));
		if (table_sendspecialordertoall_2.isDisplayed() == true) {
			takescreenshot();
			System.out.println("Element is exist  PASS");
		}

		else {takescreenshot();
			System.out.println("Element is not exist  FAIL");}
		WebElement table_sendspecialordertoall_3 = wd
				.findElement(By.xpath(locatorprop.getProperty("table_sendspecialordertoall_3")));
		if (table_sendspecialordertoall_3.isDisplayed() == true) {
			takescreenshot();
			System.out.println("Element is exist  PASS");
		}

		else {takescreenshot();
			System.out.println("Element is not exist  FAIL");}
		WebElement table_sendspecialordertoall_4 = wd
				.findElement(By.xpath(locatorprop.getProperty("table_sendspecialordertoall_4")));
		if (table_sendspecialordertoall_4.isDisplayed() == true) {
			takescreenshot();
			System.out.println("Element is exist  PASS");
		}

		else { takescreenshot();
			System.out.println("Element is not exist  FAIL");}
		WebElement table_sendspecialordertoall_5 = wd
				.findElement(By.xpath(locatorprop.getProperty("table_sendspecialordertoall_5")));
		if (table_sendspecialordertoall_5.isDisplayed() == true) {
			takescreenshot();
			System.out.println("Element is exist  PASS");
		}

		else {takescreenshot();
			System.out.println("Element is not exist  FAIL");}
	}

	@Test(priority = 4)
	public void click_on_the_send_btn() throws Throwable {

		wd.findElement(By.xpath(locatorprop.getProperty("table_sendspecialordertoall_5"))).click();
		takescreenshot();
	

	}

	@Test(priority = 5)
	public void validate_the_send_button_set_feilds_empty() throws Throwable {
		Thread.sleep(1000);
		// wd.findElement(By.xpath(locatorprop.getProperty("table_sendspecialordertoall_5"))).click();
		String noti_msgtext = wd.findElement(By.xpath(locatorprop.getProperty("noti_msg"))).getText();
		takescreenshot();
		Assert.assertEquals(noti_msgtext, "Please enter notification message", "PASS");

	}

	@Test(priority = 6)
	public void validate_the_send_button_not_select_dropdown() throws Throwable {

		wait = new WebDriverWait(wd, 30);
		wd.findElement(By.xpath(locatorprop.getProperty("table_sendspecialordertoall_4"))).sendKeys("test");
		wd.findElement(By.xpath(locatorprop.getProperty("table_sendspecialordertoall_5"))).click();
		takescreenshot();
		wait.until(ExpectedConditions
				.visibilityOf(wd.findElement(By.xpath(locatorprop.getProperty("response_send_order")))));

		String alertresponse = wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText();

		if (alertresponse.equals("Error: unable to sent special order.")) {
			Assert.assertEquals(alertresponse, "Error: unable to sent special order.");
			System.out.println("PASS = " + alertresponse);
		}

		else if (alertresponse.equals("Special Order sent successfully.")) {
			Assert.assertEquals(alertresponse, "Special Order sent successfully.");
			System.out.println("PASS = " + alertresponse);
		} else
			System.out.println("FAIL = " + alertresponse);
		// Thread.sleep(5000);

	}

	@Test(priority = 7)
	public void select_data_from_dropdown_of_select_store() throws Throwable {

		wait = new WebDriverWait(wd, 30);
		wd.findElement(By.xpath(locatorprop.getProperty("click_dropdown_seletstore"))).click();
		try {
			WebElement selected_checkbox = wd.findElement(By.xpath(locatorprop.getProperty("selected_checkbox")));
			if (selected_checkbox.isDisplayed() == true) {
				takescreenshot();
				selected_checkbox.click();
			}
		} catch (Exception e) {
			List<WebElement> list_selectstore = wd
					.findElements(By.xpath(locatorprop.getProperty("checkbox_seletstore")));
			takescreenshot();
			for (int i = 0; i < list_selectstore.size(); i++) {
				System.out.println(i + ". " + list_selectstore.get(i).getText());
				list_selectstore.get(i).click();
				String textbox_selectstore = wd
						.findElement(By.xpath(locatorprop.getProperty("click_dropdown_seletstore"))).getText();
				takescreenshot();
				Thread.sleep(1000);
				Assert.assertEquals(list_selectstore.get(i).getText(), textbox_selectstore);
				list_selectstore.get(i).click();
			}

		}

	}

	@Test(priority = 8)
	public void validate_the_send_btn() throws Throwable {
		wd.navigate().refresh();
		for (int i = 0; i < 2; i++) {
			Thread.sleep(1000);
			wd.findElement(By.xpath(locatorprop.getProperty("click_dropdown_seletstore"))).click();
			List<WebElement> list_selectstore = wd
					.findElements(By.xpath(locatorprop.getProperty("checkbox_seletstore")));
			takescreenshot();
			list_selectstore.get(4).click();
			wd.findElement(By.xpath(locatorprop.getProperty("click_dropdown_seletstore"))).click();
			wd.findElement(By.xpath(locatorprop.getProperty("table_sendspecialordertoall_4"))).sendKeys("test");
			wd.findElement(By.xpath(locatorprop.getProperty("table_sendspecialordertoall_5"))).click();

			wait.until(ExpectedConditions
					.visibilityOf(wd.findElement(By.xpath(locatorprop.getProperty("response_send_order")))));

			String alertresponse = wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText();

			if (alertresponse.equals("Error: unable to sent special order.")) {
				Assert.assertEquals(alertresponse, "Error: unable to sent special order.");
				takescreenshot();
				System.out.println("PASS = " + alertresponse);
			}

			else if (alertresponse.equals("Special Order sent successfully.")) {
				takescreenshot();
				Assert.assertEquals(alertresponse, "Special Order sent successfully.");
				System.out.println("PASS = " + alertresponse);
			} else {takescreenshot();
				System.out.println("FAIL = " + alertresponse);}

		}

	}

}
