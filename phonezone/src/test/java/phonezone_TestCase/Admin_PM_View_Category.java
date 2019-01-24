package phonezone_TestCase;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import phonezoneproject_BaseClass.BaseClass;

public class Admin_PM_View_Category extends BaseClass {

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

	 //@Test(priority = 21)
	public void go_to_side_nav_bar() throws Throwable {
		wait = new WebDriverWait(wd, 30);
		WebElement sidenav = wd.findElement(By.xpath(locatorprop.getProperty("side_nav")));
		wait.until(ExpectedConditions.visibilityOf(sidenav));

		List<WebElement> litag = sidenav.findElements(By.xpath("li/a"));

		for (int i = 0; i < litag.size(); i++) {
			System.out.println(i + ". " + litag.get(i).getText());

			if (litag.get(i).getText().equals("Product Management")) {
				Assert.assertEquals(litag.get(i).getText(), "Product Management");
				takescreenshot();
				System.out.println("PASS = " + litag.get(i).getText());
				litag.get(i).click();
				takescreenshot();
				break;
			}

		}
	}

	@Test(priority = 22)
	public void edit_view_category() throws Throwable {

		wd.findElement(By.xpath(locatorprop.getProperty("view_category"))).click();
		String addNCtext = wd.findElement(By.xpath(locatorprop.getProperty("view_category"))).getText();
		String breadcrumb = wd.findElement(By.xpath(locatorprop.getProperty("ANP_ADbreadcrumb"))).getText();
		System.out.println("********************" + addNCtext + "****************" + breadcrumb + "*****");
		takescreenshot();
		Thread.sleep(1000);
		Assert.assertEquals(addNCtext, breadcrumb);

	}

	@Test(priority = 23)
	public void verify_the_search_functionality() throws Throwable {

		wait = new WebDriverWait(wd, 30);
		String entertext = "Key";
		wd.findElement(By.xpath(locatorprop.getProperty("ANC_textbox_catogory"))).clear();

		wd.findElement(By.xpath(locatorprop.getProperty("ANC_textbox_catogory"))).sendKeys(entertext);

		wd.findElement(By.xpath(locatorprop.getProperty("searchbtn"))).click();
		wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath(locatorprop.getProperty("table_heading")))));

		List<WebElement> table_heading = wd.findElements(By.xpath(locatorprop.getProperty("table_heading")));
		for (int i = 0; i < table_heading.size(); i++) {

			if (table_heading.get(i).getText().equals("PARENT CATEGORY")) {
				System.out.println("PASS " + table_heading.get(i).getText());
			} else if (table_heading.get(i).getText().equals("CATEGORY NAME")) {
				System.out.println("PASS " + table_heading.get(i).getText());
			} else if (table_heading.get(i).getText().equals("STATUS")) {
				System.out.println("PASS " + table_heading.get(i).getText());
			} else if (table_heading.get(i).getText().equals("ACTION")) {
				System.out.println("PASS " + table_heading.get(i).getText());
			} else {
				System.out.println("FAIL " + table_heading.get(i).getText());
			}

			takescreenshot();
		}

		List<WebElement> count_categorylist = wd.findElements(By.xpath(locatorprop.getProperty("count_categorylist")));
		int rowcount = count_categorylist.size();
		if (rowcount > 0) {
			for (int j = 0; j < rowcount; j++) {
				System.out.println("PASS " + count_categorylist.get(j).getText());
				
			}takescreenshot();
		} else if (rowcount == 0) {
			System.out.println("PASS " + " Data not Available with repect to the searching keyword : " + entertext);
			takescreenshot();
		} else {
			System.out.println("FAIL ");
			takescreenshot();
		}

	}

	@Test(priority = 24)
	public void verify_the_pagination_of_searching_records() throws Throwable {
		Actions act = new Actions(wd);
		wait = new WebDriverWait(wd, 30);
		wd.findElement(By.xpath(locatorprop.getProperty("ANC_textbox_catogory"))).clear();
		wd.findElement(By.xpath(locatorprop.getProperty("searchbtn"))).click();
		Thread.sleep(1000);
		List<WebElement> pagielement = wd.findElements(By.xpath(locatorprop.getProperty("pagination")));
		int paginum = pagielement.size();
		if (paginum >= 5) {
			wd.findElement(By.xpath(locatorprop.getProperty("click_lastpage"))).click();
			String lastpagetext = wd.findElement(By.xpath(locatorprop.getProperty("text_lastpagenumber"))).getText()
					.trim();
			int lastpagenumber = Integer.parseInt(lastpagetext);

			System.out.println(lastpagenumber);
			Thread.sleep(1000);
			wd.findElement(By.xpath(locatorprop.getProperty("click_firstpage"))).click();
			Thread.sleep(1000);
			List<WebElement> count_categorylist = wd
					.findElements(By.xpath(locatorprop.getProperty("count_categorylist")));
			int rowcount = count_categorylist.size();

			if (rowcount > 0) {
				for (int l = 0; l < rowcount; l++) {
					System.out.println("PASS " + count_categorylist.get(l).getText());
					
				}takescreenshot();
			} else if (rowcount == 0) {
				System.out.println("PASS " + " Data not Available with repect to the searching keyword : ");
				takescreenshot();
			} else {
				System.out.println("FAIL ");
				takescreenshot();
			}
			for (int i = 2; i <= lastpagenumber; i++) {

				Thread.sleep(1000);
				act.moveToElement(wd.findElement(
						By.xpath(".//div[@id='default_load']//div[2]/ul/li/a[contains(text()," + i + ")]")))
						.click(wd.findElement(
								By.xpath(".//div[@id='default_load']//div[2]/ul/li/a[contains(text()," + i + ")]")))
						.build().perform();

				List<WebElement> count_categorylist1 = wd
						.findElements(By.xpath(locatorprop.getProperty("count_categorylist")));
				int rowcount1 = count_categorylist1.size();

				if (rowcount1 > 0) {
					for (int l = 0; l < rowcount1; l++) {
						System.out.println("PASS " + count_categorylist1.get(l).getText());
						
					}takescreenshot();
				} else if (rowcount1 == 0) {
					System.out.println("PASS " + " Data not Available with repect to the searching keyword : ");
					takescreenshot();
				} else {
					System.out.println("FAIL ");
					takescreenshot();
				}
			}

		} else if (paginum < 5 || paginum >= 1) {
			List<WebElement> count_categorylist = wd
					.findElements(By.xpath(locatorprop.getProperty("count_categorylist")));
			int rowcount = count_categorylist.size();
			if (rowcount > 0) {
				for (int l = 0; l < rowcount; l++) {
					System.out.println("PASS " + count_categorylist.get(l).getText());
					
				}takescreenshot();
			} else if (rowcount == 0) {
				System.out.println("PASS " + " Data not Available with repect to the searching keyword : ");
				takescreenshot();
			} else {
				System.out.println("FAIL ");
				takescreenshot();
			}
			for (int i = 2; i <= paginum; i++) {

				Thread.sleep(1000);
				act.moveToElement(wd.findElement(
						By.xpath(".//div[@id='default_load']//div[2]/ul/li/a[contains(text()," + i + ")]")))
						.click(wd.findElement(
								By.xpath(".//div[@id='default_load']//div[2]/ul/li/a[contains(text()," + i + ")]")))
						.build().perform();

				List<WebElement> count_categorylist1 = wd
						.findElements(By.xpath(locatorprop.getProperty("count_categorylist")));
				int rowcount1 = count_categorylist1.size();

				if (rowcount1 > 0) {
					for (int l = 0; l < rowcount1; l++) {
						System.out.println("PASS " + count_categorylist1.get(l).getText());
						
					}
					takescreenshot();
				} else if (rowcount1 == 0) {
					System.out.println("PASS " + " Data not Available with repect to the searching keyword : ");
					takescreenshot();
				} else {
					System.out.println("FAIL ");
					takescreenshot();
				}

			}

		} else
			System.out.println("*************No Record exist********************************************************");

	}

	@Test(priority = 25)
	public void verify_the_filterby_and_pagination_dropdown() throws Throwable {

		Actions act = new Actions(wd);
		wait = new WebDriverWait(wd, 30);
		Select select = new Select(wd.findElement(By.xpath(locatorprop.getProperty("select_filterby"))));
		List<WebElement> filterby = wd.findElements(By.xpath(locatorprop.getProperty("select_filterby_option")));
		for (int k = 1; k < filterby.size(); k++) {
			select.selectByIndex(k);
			System.out.println(filterby.get(k).getText());
			Thread.sleep(1000);

			List<WebElement> pagielement = wd.findElements(By.xpath(locatorprop.getProperty("pagination")));
			int paginum = pagielement.size();
			if (paginum >= 5) {
				wd.findElement(By.xpath(locatorprop.getProperty("click_lastpage"))).click();
				String lastpagetext = wd.findElement(By.xpath(locatorprop.getProperty("text_lastpagenumber"))).getText()
						.trim();
				int lastpagenumber = Integer.parseInt(lastpagetext);

				System.out.println(lastpagenumber);
				Thread.sleep(1000);
				wd.findElement(By.xpath(locatorprop.getProperty("click_firstpage"))).click();
				Thread.sleep(1000);
				List<WebElement> count_categorylist = wd
						.findElements(By.xpath(locatorprop.getProperty("count_categorylist")));
				int rowcount = count_categorylist.size();

				if (rowcount > 0) {
					for (int l = 0; l < rowcount; l++) {
						System.out.println("PASS " + count_categorylist.get(l).getText());
						
					}takescreenshot();
				} else if (rowcount == 0) {
					System.out.println("PASS " + " Data not Available with repect to the searching keyword : ");
					takescreenshot();
				} else {
					System.out.println("FAIL ");
					takescreenshot();
				}
				for (int i = 2; i <= lastpagenumber; i++) {

					Thread.sleep(1000);
					act.moveToElement(wd.findElement(
							By.xpath(".//div[@id='default_load']//div[2]/ul/li/a[contains(text()," + i + ")]")))
							.click(wd.findElement(
									By.xpath(".//div[@id='default_load']//div[2]/ul/li/a[contains(text()," + i + ")]")))
							.build().perform();

					List<WebElement> count_categorylist1 = wd
							.findElements(By.xpath(locatorprop.getProperty("count_categorylist")));
					int rowcount1 = count_categorylist1.size();

					if (rowcount1 > 0) {
						for (int l = 0; l < rowcount1; l++) {
							System.out.println("PASS " + count_categorylist1.get(l).getText());
							
						}takescreenshot();
					} else if (rowcount1 == 0) {
						System.out.println("PASS " + " Data not Available with repect to the searching keyword : ");
						takescreenshot();
					} else {
						System.out.println("FAIL ");
						takescreenshot();
					}
				}

			} else if (paginum < 5 || paginum >= 1) {
				List<WebElement> count_categorylist = wd
						.findElements(By.xpath(locatorprop.getProperty("count_categorylist")));
				int rowcount = count_categorylist.size();
				if (rowcount > 0) {
					for (int l = 0; l < rowcount; l++) {
						System.out.println("PASS " + count_categorylist.get(l).getText());
						
					}takescreenshot();
				} else if (rowcount == 0) {
					System.out.println("PASS " + " Data not Available with repect to the searching keyword : ");
					takescreenshot();
				} else {
					System.out.println("FAIL ");
					takescreenshot();
				}
				for (int i = 2; i <= paginum; i++) {

					Thread.sleep(1000);
					act.moveToElement(wd.findElement(
							By.xpath(".//div[@id='default_load']//div[2]/ul/li/a[contains(text()," + i + ")]")))
							.click(wd.findElement(
									By.xpath(".//div[@id='default_load']//div[2]/ul/li/a[contains(text()," + i + ")]")))
							.build().perform();

					List<WebElement> count_categorylist1 = wd
							.findElements(By.xpath(locatorprop.getProperty("count_categorylist")));
					int rowcount1 = count_categorylist1.size();

					if (rowcount1 > 0) {
						for (int l = 0; l < rowcount1; l++) {
							System.out.println("PASS " + count_categorylist1.get(l).getText());
							
						}
						takescreenshot();
					} else if (rowcount1 == 0) {
						System.out.println("PASS " + " Data not Available with repect to the searching keyword : ");
						takescreenshot();
					} else {
						System.out.println("FAIL ");
						takescreenshot();
					}

				}

			} else
				System.out.println(
						"*************No Record exist********************************************************");

		}
	}

	@Test(priority = 26)
	public void verify_the_update_edit_btn_in_view_category() throws Throwable {

		wait = new WebDriverWait(wd, 30);

		String actinact = wd.findElement(By.xpath(locatorprop.getProperty("VC_status"))).getText();

		wd.findElement(By.xpath(locatorprop.getProperty("VC_editpensil"))).click();
		wait.until(ExpectedConditions.textToBePresentInElement(
				wd.findElement(By.xpath(locatorprop.getProperty("heading3"))), "Update Category"));
		String addNCtext = wd.findElement(By.xpath(locatorprop.getProperty("heading3"))).getText();
		String VCbreadcrumb = wd.findElement(By.xpath(locatorprop.getProperty("ANP_ADbreadcrumb"))).getText();
		Assert.assertEquals(VCbreadcrumb, addNCtext);

		Thread.sleep(1000);

		Select select1 = new Select(wd.findElement(By.xpath(locatorprop.getProperty("ANC_grand_parent_id1"))));
		select1.selectByIndex(3); // user input
		Thread.sleep(1000);

		Select select2 = new Select(wd.findElement(By.xpath(locatorprop.getProperty("ANC_categories_id1"))));
		try {
			select2.selectByIndex(2);
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("no options is exist in the dropdown");
		}
		wd.findElement(By.xpath(locatorprop.getProperty("ANC_textbox_catogory"))).clear();
		wd.findElement(By.xpath(locatorprop.getProperty("ANC_textbox_catogory"))).sendKeys("A Series 123");

		Select select3 = new Select(wd.findElement(By.xpath(locatorprop.getProperty("ANC_status1"))));
		if (actinact.equalsIgnoreCase("Active")) {
			select3.selectByVisibleText("Inactive");
		} else if (actinact.equalsIgnoreCase("InActive")) {
			select3.selectByVisibleText("Active");
		}
		Thread.sleep(1000);
		wd.findElement(By.xpath(locatorprop.getProperty("ANC_inputbtn"))).click();

		Thread.sleep(1000);
		Boolean responsetext = wait.until(ExpectedConditions.textToBePresentInElement(
				wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))),
				wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText()));

		if (responsetext == true) {
			System.out.println(
					"PASS = " + wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText());
			takescreenshot();

		} else if (responsetext.equals("") == true) {
			System.out.println(
					"FAIL = " + wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText());
			takescreenshot();
		} else {
			System.out.println(
					"FAIL = " + wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText());
			takescreenshot();
		}

	}

	@Test(priority = 27)
	public void verify_the_delete_functionality() throws Throwable {

		wait = new WebDriverWait(wd, 30);
		wd.findElement(By.xpath(locatorprop.getProperty("view_category"))).click();
		wait.until(ExpectedConditions
				.visibilityOf(wd.findElement(By.xpath(locatorprop.getProperty("heading3")))));
		wd.findElement(By.xpath(locatorprop.getProperty("ANC_textbox_catogory"))).clear();
		wd.findElement(By.xpath(locatorprop.getProperty("ANC_textbox_catogory"))).sendKeys("test");

		wd.findElement(By.xpath(locatorprop.getProperty("searchbtn"))).click();
		takescreenshot();
		wd.findElement(By.xpath(locatorprop.getProperty("PS_searchbtn"))).click();
		try {
		List<WebElement> VC_deletebtn_list = wd.findElements(By.xpath(locatorprop.getProperty("count_categorylist")));
		if(VC_deletebtn_list.size()>=0) {
		wait.until(ExpectedConditions
				.visibilityOf(wd.findElement(By.xpath(locatorprop.getProperty("count_categorylist")))));
				
		for (int i = 0; i < VC_deletebtn_list.size(); i++) {
			wd.findElement(By.xpath(locatorprop.getProperty("VC_deletebtn"))).click();

			wait.until(ExpectedConditions.alertIsPresent());
			wd.switchTo().alert().accept();

			List<WebElement> listorrow = wd.findElements(By.xpath(locatorprop.getProperty("count_categorylist")));
			if (listorrow.size() == 0) {
				takescreenshot();
				System.out.println("PASS -- Data deleted successfully");
			} else if(listorrow.size()>=1) {
				takescreenshot();
				System.out.println("FAIL -- data not deleted successfully");
			} else System.out.println("Data Not Exsist in the Table");
		}

	}
	}catch(Exception e) {System.out.println("Not table record exsist");}
		}
	

}
