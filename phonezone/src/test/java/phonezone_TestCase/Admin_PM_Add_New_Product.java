package phonezone_TestCase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class Admin_PM_Add_New_Product extends BaseClass {

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

	//@Test(priority = 14)
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

	@Test(priority = 15)
	public void edit_Add_new_category() throws Throwable {

		wd.findElement(By.xpath(locatorprop.getProperty("add_new_product"))).click();
		String addNCtext = wd.findElement(By.xpath(locatorprop.getProperty("heading31"))).getText();
		String breadcrumb = wd.findElement(By.xpath(locatorprop.getProperty("ANP_ADbreadcrumb"))).getText();
		System.out.println("********************" + addNCtext + "****************" + breadcrumb + "*****");
		Thread.sleep(1000);
		takescreenshot();
		Assert.assertEquals(addNCtext, breadcrumb);

	}

	@Test(priority = 16)
	public void verify_all_elements_is_exisit() throws Throwable {
		wait =new WebDriverWait(wd,30);
		List<WebElement> ANP_labelname = wd.findElements(By.xpath(locatorprop.getProperty("ANP_labelname")));

		for (int i = 0; i < ANP_labelname.size(); i++) {

			Boolean alerttext = wait.until(
					ExpectedConditions.textToBePresentInElement(ANP_labelname.get(i), ANP_labelname.get(i).getText()));

			if (alerttext == true) {
				System.out.println(i + ". PASS = " + ANP_labelname.get(i).getText());takescreenshot();
			} else
				{System.out.println(i + ". FAIL = " + ANP_labelname.get(i).getText());takescreenshot();}

		}

		List<WebElement> ANP_form_group_element = wd
				.findElements(By.xpath(locatorprop.getProperty("ANP_form_group_element")));
		for (int j = 0; j < ANP_form_group_element.size(); j++) {
			Boolean elementtext = wait.until(ExpectedConditions.visibilityOf(ANP_form_group_element.get(j)))
					.isDisplayed();

			if (elementtext == true) {
				System.out.println(j + ". PASS = " + ANP_form_group_element.get(j).getText());takescreenshot();
			} else
				{System.out.println(j + ". FAIL = " + ANP_form_group_element.get(j).getText());takescreenshot();}
		}

	}

	@Test(priority = 17)
	public void click_on_submit_button_by_set_empty_feilds() throws Throwable {
		wait =new WebDriverWait(wd,30);
		
		wait.until(ExpectedConditions
				.elementToBeClickable(wd.findElement(By.xpath(locatorprop.getProperty("ANP_submitbtn"))))).click();

		List<WebElement> ANP_labelname = wd.findElements(By.xpath(locatorprop.getProperty("ANP_labelname")));
		List<WebElement> error_list = wd.findElements(By.xpath(locatorprop.getProperty("ANP_error_msg")));

		for (int i = 0; i < ANP_labelname.size(); i++) {
			System.out.print(i + ". " + ANP_labelname.get(i).getText());
			takescreenshot();

		}
		for (int j = 0; j < error_list.size(); j++) {

			System.out.println(j + " : " + error_list.get(j).getText());
			takescreenshot();

		}

	}

	@Test(priority = 18)
	public void enter_the_invalid_data_in_textbox() throws Throwable {

		wd.navigate().refresh();
		String textpass = "as";
		int textlength = textpass.length();

		wd.findElement(By.xpath(locatorprop.getProperty("ANP_producttitle"))).sendKeys(textpass);
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_short_description"))).sendKeys(textpass);
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_barcode"))).sendKeys(textpass);
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_available_qty"))).sendKeys(textpass);
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_price"))).sendKeys(textpass);
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_retail_price"))).sendKeys(textpass);
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_wholesale_price"))).sendKeys(textpass);
		wd.findElement(By.xpath(locatorprop.getProperty("ANC_status1"))).click();
		takescreenshot();
		List<WebElement> error_list = wd.findElements(By.xpath(locatorprop.getProperty("ANP_error_msg")));
		for (int j = 0; j < error_list.size(); j++) {
			/*
			 * Boolean errortext = wait
			 * .until(ExpectedConditions.textToBePresentInElement(error_list.get(j),
			 * error_list.get(j).getText()));
			 */

			if (textlength <= 3 || textlength <= 10) {
				System.out.println(j + ". PASS : " + error_list.get(j).getText());takescreenshot();
			} else
				{System.out.println(j + ". FAIL : " + error_list.get(j).getText());takescreenshot();}

		}

	}

	@Test(priority = 19)
	public void verify_the_response_text_when_status_is_Active() throws Throwable {
		wait =new WebDriverWait(wd,30);
		wd.navigate().refresh();
		Thread.sleep(1000);
		List<WebElement> ANC_categories_id = wd.findElements(By.xpath(locatorprop.getProperty("ANC_categories_id")));
		for (int j = 1; j < ANC_categories_id.size(); j++) {

			Select select1 = new Select(wd.findElement(By.xpath(locatorprop.getProperty("ANC_categories_id1"))));
			select1.selectByIndex(j);
			Thread.sleep(1000);

			List<WebElement> ANP_sub_categories_id = wd
					.findElements(By.xpath(locatorprop.getProperty("ANP_sub_categories_id")));

			for (int k = 1; k < ANP_sub_categories_id.size(); k++) {
				Thread.sleep(1000);
				try {
					Select select2 = new Select(
							wd.findElement(By.xpath(locatorprop.getProperty("ANP_sub_categories_id1"))));
					select2.selectByIndex(k);
				} catch (Exception e) {
					System.out.println(" ANP_sub_categories_id1 = Drop_down is empty");
				}

				List<WebElement> ANP_sub_sub_categories_id = wd
						.findElements(By.xpath(locatorprop.getProperty("ANP_sub_sub_categories_id")));
				for (int d = 1; d < ANP_sub_sub_categories_id.size(); d++) {
					Thread.sleep(1000);
					try {
						Select select4 = new Select(
								wd.findElement(By.xpath(locatorprop.getProperty("ANP_sub_sub_categories_id1"))));
						select4.selectByIndex(d);
					} catch (Exception e) {
						System.out.println(" ANP_sub_sub_categories_id1 =Drop_down is empty");
					}

					String textpass = "Test123456781";
					int textlength = textpass.length();

					wd.findElement(By.xpath(locatorprop.getProperty("ANP_producttitle"))).clear();
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_producttitle"))).sendKeys(textpass);
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_short_description"))).clear();
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_short_description"))).sendKeys(textpass);
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_barcode"))).clear();
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_barcode"))).sendKeys("201302");
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_available_qty"))).clear();
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_available_qty"))).sendKeys("2");
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_price"))).clear();
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_price"))).sendKeys("2");
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_retail_price"))).clear();
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_retail_price"))).sendKeys("2");
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_wholesale_price"))).clear();
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_wholesale_price"))).sendKeys("2");

					List<WebElement> ANC_status = wd.findElements(By.xpath(locatorprop.getProperty("ANC_status")));

					/* for (int l = 1; l < ANC_status.size(); l++) { */

					Select select3 = new Select(wd.findElement(By.xpath(locatorprop.getProperty("ANC_status1"))));
					select3.selectByIndex(1);
                   Thread.sleep(2000);
					wd.findElement(By.xpath(locatorprop.getProperty("ANC_inputbtn"))).click();
					
					Boolean responsetext = wait.until(ExpectedConditions.textToBePresentInElement(
							wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))),
							wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText()));

					if (responsetext == true) {
						System.out.println("PASS = "
								+ wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText());takescreenshot();

					} else if (responsetext.equals("") == true) {
						System.out.println("FAIL = "
								+ wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText());takescreenshot();}
					else
						{System.out.println("FAIL = "
								+ wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText());takescreenshot();}

					select1.selectByIndex(j);
					
					try {
						Select select2 = new Select(
								wd.findElement(By.xpath(locatorprop.getProperty("ANP_sub_categories_id1"))));
						select2.selectByIndex(k - 1);
					} catch (Exception e) {
						System.out.println(" ANP_sub_categories_id1 = Drop_down is empty");
					}

					// }
				}

			}

		}

	}

	@Test(priority = 20)
	public void verify_the_response_text_when_status_is_Inactive() throws Throwable {
		wait =new WebDriverWait(wd,30);
		wd.navigate().refresh();
		
		List<WebElement> ANC_categories_id = wd.findElements(By.xpath(locatorprop.getProperty("ANC_categories_id")));
		for (int j = 1; j < ANC_categories_id.size(); j++) {

			Select select1 = new Select(wd.findElement(By.xpath(locatorprop.getProperty("ANC_categories_id1"))));
			select1.selectByIndex(j);
			Thread.sleep(1000);

			List<WebElement> ANP_sub_categories_id = wd
					.findElements(By.xpath(locatorprop.getProperty("ANP_sub_categories_id")));

			for (int k = 1; k < ANP_sub_categories_id.size(); k++) {
				Thread.sleep(1000);
				try {
					Select select2 = new Select(
							wd.findElement(By.xpath(locatorprop.getProperty("ANP_sub_categories_id1"))));
					select2.selectByIndex(k);
				} catch (Exception e) {
					System.out.println(" ANP_sub_categories_id1 = Drop_down is empty");
				}

				List<WebElement> ANP_sub_sub_categories_id = wd
						.findElements(By.xpath(locatorprop.getProperty("ANP_sub_sub_categories_id")));
				for (int d = 1; d < ANP_sub_sub_categories_id.size(); d++) {
					Thread.sleep(1000);
					try {
						Select select4 = new Select(
								wd.findElement(By.xpath(locatorprop.getProperty("ANP_sub_sub_categories_id1"))));
						select4.selectByIndex(d);
					} catch (Exception e) {
						System.out.println(" ANP_sub_sub_categories_id1 =Drop_down is empty");
					}

					String textpass = "Test123456781";
					int textlength = textpass.length();

					wd.findElement(By.xpath(locatorprop.getProperty("ANP_producttitle"))).clear();
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_producttitle"))).sendKeys(textpass);
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_short_description"))).clear();
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_short_description"))).sendKeys(textpass);
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_barcode"))).clear();
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_barcode"))).sendKeys("201302");
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_available_qty"))).clear();
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_available_qty"))).sendKeys("2");
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_price"))).clear();
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_price"))).sendKeys("2");
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_retail_price"))).clear();
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_retail_price"))).sendKeys("2");
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_wholesale_price"))).clear();
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_wholesale_price"))).sendKeys("2");

					List<WebElement> ANC_status = wd.findElements(By.xpath(locatorprop.getProperty("ANC_status")));

					/* for (int l = 1; l < ANC_status.size(); l++) { */

					Select select3 = new Select(wd.findElement(By.xpath(locatorprop.getProperty("ANC_status1"))));
					select3.selectByIndex(2);

					wd.findElement(By.xpath(locatorprop.getProperty("ANC_inputbtn"))).click();
					try {
					wd.switchTo().alert();
					}catch(Exception e) {
						System.out.println("Alert is not coming or available");
					}
					Thread.sleep(1000);
					Boolean responsetext = wait.until(ExpectedConditions.textToBePresentInElement(
							wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))),
							wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText()));

					if (responsetext == true) {
						System.out.println("PASS = "
								+ wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText());takescreenshot();

					} else if (responsetext.equals("") == true)
						{System.out.println("FAIL = "
								+ wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText());takescreenshot();}
					else
						{System.out.println("FAIL = "
								+ wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText());takescreenshot();}

					select1.selectByIndex(j);
					
					try {
						Select select2 = new Select(
								wd.findElement(By.xpath(locatorprop.getProperty("ANP_sub_categories_id1"))));
						select2.selectByIndex(k - 1);
					} catch (Exception e) {
						System.out.println(" ANP_sub_categories_id1 = Drop_down is empty");
					}
					// }
				}

			}
		}

	}
}
