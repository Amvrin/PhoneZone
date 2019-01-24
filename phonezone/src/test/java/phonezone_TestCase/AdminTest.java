package phonezone_TestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import phonezoneproject_BaseClass.BaseClass;

public class AdminTest extends BaseClass {

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

	@Test(priority = 1)
	public void admin_button_test() throws InterruptedException, IOException {

		wd.findElement(By.xpath(prop.getProperty("Admin_button"))).click();
		System.out.println(wd.getTitle());

		String text = wd.findElement(By.xpath(prop.getProperty("common_header_login"))).getText();
		Assert.assertEquals(text, "Admin Login");
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void admin_page_all_element_is_present() {

		wd.findElement(By.xpath(prop.getProperty("Admin_button"))).click();

		WebElement para = wd.findElement(By.xpath(prop.getProperty("para_text")));

		if (para.isDisplayed() == true) {
			if (para.getText()
					.equals("For authorized users only. Unauthorized access prohibited and punishable by law.")) {
				System.out.println("text is visible PASS");
				System.out.println("Text is == " + para.getText());
			}

		} else
			System.out.println("FAIL");

		WebElement username = wd.findElement(By.xpath(prop.getProperty("Admin_username")));
		if (username.isDisplayed() == true) {
			System.out.println("Admin_Username is PASS");
		} else
			System.out.println("Admin username is FAIL");

		WebElement password = wd.findElement(By.xpath(prop.getProperty("Admin_password")));
		if (password.isDisplayed() == true) {
			System.out.println("Admin_Password is PASS");
		} else
			System.out.println("Admin Password is FAIL");

		WebElement loginbtn = wd.findElement(By.xpath(prop.getProperty("Admin_login")));
		if (loginbtn.isDisplayed() == true) {
			System.out.println("Admin_Login Btn is PASS");
		} else
			System.out.println("Admin Login Btn is FAIL");

		WebElement forgotpass = wd.findElement(By.xpath(prop.getProperty("Admin_forgotpass")));
		if (forgotpass.isDisplayed() == true) {
			System.out.println("Admin_Forgot Pass is PASS");
		} else
			System.out.println("Admin Forgot Pass is FAIL");

		WebElement mainmenubtn = wd.findElement(By.xpath(prop.getProperty("Admin_mainmenubtn")));
		if (mainmenubtn.isDisplayed() == true) {
			System.out.println("Admin_Main Menu is PASS");
		} else
			System.out.println("Admin Main Menu is FAIL");

	}

	@Test(priority = 3)
	public void click_on_forgot_pass() {

		wd.findElement(By.xpath(prop.getProperty("Admin_button"))).click();
		WebElement forgotpass = wd.findElement(By.xpath(prop.getProperty("Admin_forgotpass")));
		forgotpass.click();

		System.out.println(wd.getTitle());
		WebElement heading = wd.findElement(By.xpath(prop.getProperty("common_header_login")));
		if (heading.isDisplayed() == true) {
			String text = wd.findElement(By.xpath(prop.getProperty("common_header_login"))).getText();
			Assert.assertEquals(text, "Forgot Password");
			System.out.println("Page name is PASS == " + heading.getText());
		} else
			System.out.println("Page name is FAIL");

		WebElement forgotemail = wd.findElement(By.xpath(prop.getProperty("forgot_email")));
		if (forgotemail.isDisplayed() == true) {
			System.out.println("Forgot page is PASS");
		} else
			System.out.println("Forgot page is FAIL");

		WebElement recover_btn = wd.findElement(By.xpath(prop.getProperty("recoverbtn")));
		if (recover_btn.isDisplayed() == true) {
			System.out.println("Recovery btn is PASS");
		} else
			System.out.println("Recovery btn is FAIL");

		WebElement adminloginbtn = wd.findElement(By.xpath(prop.getProperty("Admin_login_btn")));
		if (adminloginbtn.isDisplayed() == true) {
			System.out.println("Admin_login_btn is PASS");
		} else
			System.out.println("Admin_login_btn  is FAIL");

	}

	@Test(priority = 4)
	public void return_to_admin_login_page() {
		wd.findElement(By.xpath(prop.getProperty("Admin_button"))).click();
		WebElement forgotpass1 = wd.findElement(By.xpath(prop.getProperty("Admin_forgotpass")));
		forgotpass1.click();
		WebElement adminloginbtn = wd.findElement(By.xpath(prop.getProperty("Admin_login_btn")));
		adminloginbtn.click();

		// verify the Admin_Login Page

		WebElement para = wd.findElement(By.xpath(prop.getProperty("para_text")));

		if (para.isDisplayed() == true) {
			if (para.getText()
					.equals("For authorized users only. Unauthorized access prohibited and punishable by law.")) {
				System.out.println("text is visible PASS");
				System.out.println("Text is == " + para.getText());
			}

		} else
			System.out.println("FAIL");

		WebElement username = wd.findElement(By.xpath(prop.getProperty("Admin_username")));
		if (username.isDisplayed() == true) {
			System.out.println("Admin_Username is PASS");
		} else
			System.out.println("Admin username is FAIL");

		WebElement password = wd.findElement(By.xpath(prop.getProperty("Admin_password")));
		if (password.isDisplayed() == true) {
			System.out.println("Admin_Password is PASS");
		} else
			System.out.println("Admin Password is FAIL");

		WebElement loginbtn = wd.findElement(By.xpath(prop.getProperty("Admin_login")));
		if (loginbtn.isDisplayed() == true) {
			System.out.println("Admin_Login Btn is PASS");
		} else
			System.out.println("Admin Login Btn is FAIL");

		WebElement forgotpass = wd.findElement(By.xpath(prop.getProperty("Admin_forgotpass")));
		if (forgotpass.isDisplayed() == true) {
			System.out.println("Admin_Forgot Pass is PASS");
		} else
			System.out.println("Admin Forgot Pass is FAIL");

		WebElement mainmenubtn = wd.findElement(By.xpath(prop.getProperty("Admin_mainmenubtn")));
		if (mainmenubtn.isDisplayed() == true) {
			System.out.println("Admin_Main Menu is PASS");
		} else
			System.out.println("Admin Main Menu is FAIL");

	}

	@Test(priority = 5)
	public void click_on_Main_Menu_btn() {
		wd.findElement(By.xpath(prop.getProperty("Admin_button"))).click();
		WebElement mainmenubtn = wd.findElement(By.xpath(prop.getProperty("Admin_mainmenubtn")));
		mainmenubtn.click();

		System.out.println(wd.getTitle());

		WebElement phonezonelogo = wd.findElement(By.xpath(prop.getProperty("phonezone_logo")));

		if (phonezonelogo.isDisplayed() == true) {
			System.out.println("PhoneZone logo is PASS");
		} else
			System.out.println("PhoneZone Logo is FAIL");

		WebElement Adminbtn = wd.findElement(By.xpath(prop.getProperty("Admin_button")));

		if (Adminbtn.isDisplayed() == true) {
			System.out.println("Admin_button is PASS");
		} else
			System.out.println("Admin_button is FAIL");

		WebElement Staffbtn = wd.findElement(By.xpath(prop.getProperty("Staff_button")));

		if (Staffbtn.isDisplayed() == true) {
			System.out.println("Staff_button is PASS");
		} else
			System.out.println("Staff_button is FAIL");

		WebElement wholesellerbtn = wd.findElement(By.xpath(prop.getProperty("wholeseller_button")));

		if (wholesellerbtn.isDisplayed() == true) {
			System.out.println("wholeseller_button is PASS");
		} else
			System.out.println("wholeseller_button is FAIL");

	}

}
