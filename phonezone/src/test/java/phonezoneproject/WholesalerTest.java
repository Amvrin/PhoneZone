package phonezoneproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WholesalerTest extends beforeandafterclassTest {

	private static Properties prop = new Properties();
	private static FileInputStream fis;

	static {
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/properties/locators.properties");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Test
	public void wholesaler_button_test() throws InterruptedException, IOException {
		wd.findElement(By.xpath(prop.getProperty("wholeseller_button"))).click();
		System.out.println(wd.getTitle());
		String text = wd.findElement(By.xpath(prop.getProperty("common_header_login"))).getText();

		Assert.assertEquals(text, "Staff/Wholeseller Login");
		Thread.sleep(5000);
	}

	@Test
	public void verifyWholeSellerScreen()
	{
		wd.findElement(By.xpath(prop.getProperty("wholeseller_button"))).click();
		System.out.println(wd.getTitle());
		if (wd.findElement(By.xpath(prop.getProperty("common_header_login"))).isDisplayed() == true &&
				wd.findElement(By.xpath(prop.getProperty("enter_email_input_field"))).isDisplayed() == true &&
				wd.findElement(By.xpath(prop.getProperty("enter_password_iput_field"))).isDisplayed() == true &&
				wd.findElement(By.xpath(prop.getProperty("login_button"))).isDisplayed() == true &&
				wd.findElement(By.xpath(prop.getProperty("forgot_password"))).isDisplayed() == true &&
				wd.findElement(By.xpath(prop.getProperty("wholeseller_screen_text"))).isDisplayed() == true &&
				wd.findElement(By.xpath(prop.getProperty("main_menu_button"))).isDisplayed() == true)
		{
			System.out.println("All elements are visible on the screen");
			Assert.assertEquals(true, true);
		}
	}
}
