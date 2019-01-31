package phonezone_TestCase;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import phonezoneproject_BaseClass.BaseClass;

public class Admin_PM_View_product extends BaseClass {

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

	// @Test(priority = 30)
	public void go_to_side_nav_bar() throws Throwable {
		wait = new WebDriverWait(wd, 30);
		WebElement sidenav = wd.findElement(By.xpath(locatorprop.getProperty("side_nav")));
		wait.until(ExpectedConditions.visibilityOf(sidenav));

		List<WebElement> litag = sidenav.findElements(By.xpath("li/a"));

		for (int i = 0; i < litag.size(); i++) {
			System.out.println(i + ". " + litag.get(i).getText());

			if (litag.get(i).getText().equals("Product Management")) {

				Assert.assertEquals(litag.get(i).getText(), "Product Management");
				System.out.println("PASS = " + litag.get(i).getText());
				litag.get(i).click();
				takescreenshot();
				break;
			}

		}
	}

	@Test(priority = 31)
	public void edit_view_product() throws Throwable {

		wd.findElement(By.xpath(locatorprop.getProperty("view_product"))).click();
		String addNCtext = wd.findElement(By.xpath(locatorprop.getProperty("view_product"))).getText();
		String breadcrumb = wd.findElement(By.xpath(locatorprop.getProperty("ANP_ADbreadcrumb"))).getText();
		System.out.println("********************" + addNCtext + "****************" + breadcrumb + "*****");
		takescreenshot();
		Thread.sleep(1000);
		Assert.assertEquals(addNCtext, breadcrumb);

	}

	@Test(priority = 32)
	public void verify_the_filterBy_and_pagination_of_view_product() throws Throwable {
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

					}
					takescreenshot();
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

			} else if (paginum < 5 || paginum >= 1) {
				List<WebElement> count_categorylist = wd
						.findElements(By.xpath(locatorprop.getProperty("count_categorylist")));
				int rowcount = count_categorylist.size();
				if (rowcount > 0) {
					for (int l = 0; l < rowcount; l++) {
						System.out.println("PASS " + count_categorylist.get(l).getText());

					}
					takescreenshot();
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

			} else if (paginum == 0) {
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
			} else
				System.out.println(
						"*************No Record exist********************************************************");

		}
	}

	@Test(priority = 33)
	public void verify_the_search_functionality_of_view_product1() throws Throwable {

		wd.findElement(By.xpath(locatorprop.getProperty("PS_productname"))).sendKeys("Test123456781");
		wd.findElement(By.xpath(locatorprop.getProperty("PS_barcode"))).sendKeys("201302");

		/*Select select = new Select(wd.findElement(By.xpath(locatorprop.getProperty("ANC_categories_id1"))));
		select.selectByIndex(1);
		Thread.sleep(1000);
		Select select1 = new Select(wd.findElement(By.xpath(locatorprop.getProperty("ANP_sub_categories_id1"))));
		try {
			select1.selectByIndex(1);
		} catch (Exception e) {
			System.out.println("************ not found the dropdown*** in Sub Category***");
		}
		Thread.sleep(1000);
		Select select2 = new Select(wd.findElement(By.xpath(locatorprop.getProperty("ANP_sub_sub_categories_id1"))));
		try {
			select2.selectByIndex(1);
		} catch (Exception e) {
			System.out.println("************ not found the dropdown*** in Sub Sub Category***");
		}
*/
		Thread.sleep(1000);
		wd.findElement(By.xpath(locatorprop.getProperty("PS_searchbtn"))).click();

		wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath(locatorprop.getProperty("table_heading")))));

		List<WebElement> table_heading = wd.findElements(By.xpath(locatorprop.getProperty("table_heading")));
		for (int i = 0; i < table_heading.size(); i++) {

			if (table_heading.get(i).getText().equals("BARCODE")) {
				System.out.println("PASS " + table_heading.get(i).getText());
			} else if (table_heading.get(i).getText().equals("NAME")) {
				System.out.println("PASS " + table_heading.get(i).getText());
			} else if (table_heading.get(i).getText().equals("DESCRIPTION")) {
				System.out.println("PASS " + table_heading.get(i).getText());
			} else if (table_heading.get(i).getText().equals("AVL QTY")) {
				System.out.println("PASS " + table_heading.get(i).getText());
			} else if (table_heading.get(i).getText().equals("PRICE")) {
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
				Assert.assertEquals(count_categorylist.get(j).findElement(By.xpath("td[2]")).getText(),
						"Test123456781");
				Assert.assertEquals(count_categorylist.get(j).findElement(By.xpath("td[1]")).getText(), "201302");
			}
			takescreenshot();
		} else if (rowcount < 0) {
			System.out.println(
					"PASS " + " Data not Available with repect to the NAME searching keyword : " + "Test123456781");

			System.out.println(
					"PASS " + " Data not Available with repect to the BARCODE searching keyword : " + "201302");
			takescreenshot();
		} else {
			System.out.println("FAIL ");
			takescreenshot();
		}

		/*
		 * Actions act = new Actions(wd);
		 * 
		 * wd.findElement(By.xpath(locatorprop.getProperty("PS_productname"))).sendKeys(
		 * "Test123456781");
		 * wd.findElement(By.xpath(locatorprop.getProperty("PS_barcode"))).sendKeys(
		 * "201302");
		 * 
		 * List<WebElement> ps_categoryid_dropdown = wd
		 * .findElements(By.xpath(locatorprop.getProperty("ANC_categories_id"))); for
		 * (int d = 1; d < ps_categoryid_dropdown.size(); d++) {
		 * 
		 * Select select = new
		 * Select(wd.findElement(By.xpath(locatorprop.getProperty("ANC_categories_id1"))
		 * )); select.selectByIndex(d); Thread.sleep(1000);
		 * 
		 * List<WebElement> ps_sub_categoryid_dropdown = wd
		 * .findElements(By.xpath(locatorprop.getProperty("ANP_sub_categories_id")));
		 * 
		 * for (int j = 1; j < ps_sub_categoryid_dropdown.size(); j++) {
		 * 
		 * Select select1 = new Select(
		 * wd.findElement(By.xpath(locatorprop.getProperty("ANP_sub_categories_id1"))));
		 * try { select1.selectByIndex(j); } catch (Exception e) { System.out.
		 * println("************ not found the dropdown*** in Sub Category***"); }
		 * 
		 * List<WebElement> ps_sub_sub_categoryid_dropdown = wd
		 * .findElements(By.xpath(locatorprop.getProperty("ANP_sub_sub_categories_id")))
		 * ;
		 * 
		 * for (int k = 1; k < ps_sub_sub_categoryid_dropdown.size(); k++) {
		 * 
		 * Select select2 = new Select(
		 * wd.findElement(By.xpath(locatorprop.getProperty("ANP_sub_sub_categories_id1")
		 * ))); try { select2.selectByIndex(k); } catch (Exception e) { System.out.
		 * println("************ not found the dropdown*** in Sub Sub Category***"); }
		 * 
		 * Thread.sleep(3000); takescreenshot();
		 * wd.findElement(By.xpath(locatorprop.getProperty("PS_searchbtn"))).click();
		 * 
		 * wait.until(ExpectedConditions
		 * .visibilityOf(wd.findElement(By.xpath(locatorprop.getProperty(
		 * "count_categorylist"))))); List<WebElement> pagielement =
		 * wd.findElements(By.xpath(locatorprop.getProperty("pagination"))); int paginum
		 * = pagielement.size(); if (paginum >= 5) {
		 * wd.findElement(By.xpath(locatorprop.getProperty("click_lastpage"))).click();
		 * String lastpagetext =
		 * wd.findElement(By.xpath(locatorprop.getProperty("text_lastpagenumber")))
		 * .getText().trim(); int lastpagenumber = Integer.parseInt(lastpagetext);
		 * 
		 * System.out.println(lastpagenumber); Thread.sleep(1000);
		 * wd.findElement(By.xpath(locatorprop.getProperty("click_firstpage"))).click();
		 * Thread.sleep(1000); List<WebElement> count_categorylist = wd
		 * .findElements(By.xpath(locatorprop.getProperty("count_categorylist"))); int
		 * rowcount = count_categorylist.size();
		 * 
		 * if (rowcount > 0) { for (int l = 0; l < rowcount; l++) {
		 * 
		 * System.out.println("PASS " + count_categorylist.get(l).getText()); }
		 * takescreenshot(); } else if (rowcount == 0) { takescreenshot();
		 * System.out.println("PASS " +
		 * " Data not Available with repect to the searching keyword : "); } else
		 * System.out.println("FAIL "); for (int i = 2; i <= lastpagenumber; i++) {
		 * 
		 * Thread.sleep(1000); act.moveToElement(wd.findElement(
		 * By.xpath(".//div[@id='default_load']//div[2]/ul/li/a[contains(text()," + i +
		 * ")]"))) .click(wd.findElement(By.xpath(
		 * ".//div[@id='default_load']//div[2]/ul/li/a[contains(text()," + i + ")]")))
		 * .build().perform(); takescreenshot(); List<WebElement> count_categorylist1 =
		 * wd .findElements(By.xpath(locatorprop.getProperty("count_categorylist")));
		 * int rowcount1 = count_categorylist1.size();
		 * 
		 * if (rowcount1 > 0) { takescreenshot(); for (int l = 0; l < rowcount1; l++) {
		 * System.out.println("PASS " + count_categorylist1.get(l).getText());
		 * 
		 * } takescreenshot(); } else if (rowcount1 == 0) { System.out.println( "PASS "
		 * + " Data not Available with repect to the searching keyword : ");
		 * takescreenshot(); } else { System.out.println("FAIL "); takescreenshot(); } }
		 * 
		 * } else if (paginum < 5 || paginum >= 1) { List<WebElement> count_categorylist
		 * = wd .findElements(By.xpath(locatorprop.getProperty("count_categorylist")));
		 * int rowcount = count_categorylist.size(); if (rowcount > 0) { for (int l = 0;
		 * l < rowcount; l++) { System.out.println("PASS " +
		 * count_categorylist.get(l).getText());
		 * 
		 * } takescreenshot(); } else if (rowcount == 0) { System.out.println("PASS " +
		 * " Data not Available with repect to the searching keyword : ");
		 * takescreenshot(); } else { System.out.println("FAIL "); takescreenshot(); }
		 * for (int n = 2; n < paginum; n++) {
		 * 
		 * Thread.sleep(1000); act.moveToElement(wd.findElement(
		 * By.xpath(".//div[@id='default_load']//div[2]/ul/li/a[contains(text()," + n +
		 * ")]"))) .click(wd.findElement(By.xpath(
		 * ".//div[@id='default_load']//div[2]/ul/li/a[contains(text()," + n + ")]")))
		 * .build().perform();
		 * 
		 * List<WebElement> count_categorylist1 = wd
		 * .findElements(By.xpath(locatorprop.getProperty("count_categorylist"))); int
		 * rowcount1 = count_categorylist1.size();
		 * 
		 * if (rowcount1 > 0) { for (int l = 0; l < rowcount1; l++) {
		 * System.out.println("PASS " + count_categorylist1.get(l).getText());
		 * 
		 * } takescreenshot(); } else if (rowcount1 == 0) { System.out.println( "PASS "
		 * + " Data not Available with repect to the searching keyword : ");
		 * takescreenshot(); } else { System.out.println("FAIL "); takescreenshot(); }
		 * 
		 * }
		 * 
		 * } else if (paginum == 0) { List<WebElement> count_categorylist1 = wd
		 * .findElements(By.xpath(locatorprop.getProperty("count_categorylist"))); int
		 * rowcount1 = count_categorylist1.size();
		 * 
		 * if (rowcount1 > 0) { for (int l = 0; l < rowcount1; l++) {
		 * System.out.println("PASS " + count_categorylist1.get(l).getText());
		 * 
		 * } takescreenshot(); } else if (rowcount1 == 0) { System.out.println("PASS " +
		 * " Data not Available with repect to the searching keyword : ");
		 * takescreenshot(); } else { System.out.println("FAIL "); takescreenshot(); } }
		 * else System.out.println(
		 * "*************No Record exist********************************************************"
		 * );
		 * 
		 * }
		 * 
		 * }
		 * 
		 * }
		 */
	}

	@Test(priority = 34)
	public void verify_the_Edit_update_btn() throws Throwable {

		Robot r=new Robot();
		wait = new WebDriverWait(wd, 30);
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);

		wd.findElement(By.xpath(locatorprop.getProperty("PS_infobtn"))).click();
		Thread.sleep(1000);

		String actinact = wd.findElement(By.xpath(locatorprop.getProperty("PS_status"))).getText();

		wd.findElement(By.xpath(locatorprop.getProperty("PS_modal_close"))).click();

		wait.until(
				ExpectedConditions.visibilityOf(wd.findElement(By.xpath(locatorprop.getProperty("PS_productname")))));
		wd.findElement(By.xpath(locatorprop.getProperty("PS_productname"))).clear();
		wd.findElement(By.xpath(locatorprop.getProperty("PS_productname"))).sendKeys("Test123456781");
		wd.findElement(By.xpath(locatorprop.getProperty("PS_barcode"))).clear();
		wd.findElement(By.xpath(locatorprop.getProperty("PS_barcode"))).sendKeys("201302");
		/*Select select = new Select(wd.findElement(By.xpath(locatorprop.getProperty("ANC_categories_id1"))));
		select.selectByIndex(1);
		Thread.sleep(2000);
		Select psselect1 = new Select(wd.findElement(By.xpath(locatorprop.getProperty("ANP_sub_categories_id1"))));
		try {
			psselect1.selectByIndex(1);
		} catch (Exception e) {
			System.out.println("************ not found the dropdown*** in Sub Category***");
		}

		Select psselect2 = new Select(wd.findElement(By.xpath(locatorprop.getProperty("ANP_sub_sub_categories_id1"))));
		try {
			psselect2.selectByIndex(1);
		} catch (Exception e) {
			System.out.println("************ not found the dropdown*** in Sub Sub Category***");
		}*/
		Thread.sleep(2000);
		wd.findElement(By.xpath(locatorprop.getProperty("PS_searchbtn"))).click();
		takescreenshot();
		Thread.sleep(2000);

		wd.findElement(By.xpath(locatorprop.getProperty("PS_Editbtn"))).click();
		wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath(locatorprop.getProperty("heading3")))));

		Select select1 = new Select(wd.findElement(By.xpath(locatorprop.getProperty("ANC_categories_id1"))));
		select1.selectByIndex(1);

		try {
			Select select2 = new Select(wd.findElement(By.xpath(locatorprop.getProperty("ANP_sub_categories_id1"))));
			select2.selectByIndex(1);
		} catch (Exception e) {
			System.out.println(" ANP_sub_categories_id1 = Drop_down is empty");
		}

		try {
			Select select4 = new Select(
					wd.findElement(By.xpath(locatorprop.getProperty("ANP_sub_sub_categories_id1"))));
			select4.selectByIndex(1);
		} catch (Exception e) {
			System.out.println(" ANP_sub_sub_categories_id1 =Drop_down is empty");
		}
		takescreenshot();

		String textpass = "Test product781";
		int textlength = textpass.length();

		wd.findElement(By.xpath(locatorprop.getProperty("ANP_producttitle"))).clear();
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_producttitle"))).sendKeys(textpass);
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_short_description"))).clear();
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_short_description"))).sendKeys(textpass);
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_barcode"))).clear();
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_barcode"))).sendKeys("201302");
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_available_qty"))).clear();
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_available_qty"))).sendKeys("20");
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_price"))).clear();
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_price"))).sendKeys("12");
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_retail_price"))).clear();
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_retail_price"))).sendKeys("2");
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_wholesale_price"))).clear();
		wd.findElement(By.xpath(locatorprop.getProperty("ANP_wholesale_price"))).sendKeys("2");

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
			takescreenshot();
			System.out.println(
					"PASS = " + wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText());

		} else if (responsetext.equals("") == true) {
			takescreenshot();
			System.out.println(
					"FAIL = " + wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText());
		} else {
			takescreenshot();
			System.out.println(
					"FAIL = " + wd.findElement(By.xpath(locatorprop.getProperty("response_send_order"))).getText());
		}

	}

	@Test(priority = 35)
	public void verify_the_delete_functionality() throws Throwable {

		String barcode = "201302";
		String name = "Test123456781";
		Actions act = new Actions(wd);
		wait = new WebDriverWait(wd, 30);
		wd.findElement(By.xpath(locatorprop.getProperty("view_product"))).click();
		Thread.sleep(2000);
		wait.until(
				ExpectedConditions.visibilityOf(wd.findElement(By.xpath(locatorprop.getProperty("PS_productname")))));
		wd.findElement(By.xpath(locatorprop.getProperty("PS_productname"))).clear();
		wd.findElement(By.xpath(locatorprop.getProperty("PS_productname"))).sendKeys(name);
		wd.findElement(By.xpath(locatorprop.getProperty("PS_barcode"))).clear();
		wd.findElement(By.xpath(locatorprop.getProperty("PS_barcode"))).sendKeys(barcode);
		takescreenshot();
		Thread.sleep(1000);
		wd.findElement(By.xpath(locatorprop.getProperty("PS_searchbtn"))).click();
		Robot r=new Robot();
		wait = new WebDriverWait(wd, 30);
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);

		String barcode_rowcol = wd.findElement(By.xpath(locatorprop.getProperty("PS_barcode_rowcol"))).getText();
		String name_rowcol = wd.findElement(By.xpath(locatorprop.getProperty("PS_name_rowcol"))).getText();

		List<WebElement> VC_deletebtn_list = wd.findElements(By.xpath(locatorprop.getProperty("count_categorylist")));
		if (VC_deletebtn_list.size() > 0) {
			wait.until(ExpectedConditions
					.visibilityOf(wd.findElement(By.xpath(locatorprop.getProperty("count_categorylist")))));
			
			List<WebElement> PS_deletebtn_list = wd.findElements(By.xpath(locatorprop.getProperty("PS_deletebtn")));

			for (int i = 0; i < PS_deletebtn_list.size(); i++) {

				if (barcode_rowcol.equalsIgnoreCase(barcode) && name_rowcol.equalsIgnoreCase(name)) {

					//wd.findElement(By.xpath(locatorprop.getProperty("PS_deletebtn"))).click();
					PS_deletebtn_list.get(i).click();
					Thread.sleep(2000);
					wait.until(ExpectedConditions.alertIsPresent());
					wd.switchTo().alert().accept();
					Thread.sleep(2000);
					
				}

			}

		} else {
			System.out.println("No data table found in the page");
		}

		/*
		 * if (barcode_rowcol.equalsIgnoreCase(barcode) &&
		 * name_rowcol.equalsIgnoreCase(name)) {
		 * 
		 * List<WebElement> VC_deletebtn_list = wd
		 * .findElements(By.xpath(locatorprop.getProperty("count_categorylist"))); if
		 * (VC_deletebtn_list.size() >= 0) { wait.until(ExpectedConditions
		 * .visibilityOf(wd.findElement(By.xpath(locatorprop.getProperty(
		 * "count_categorylist")))));
		 * 
		 * for (int i = 0; i < VC_deletebtn_list.size(); i++) { Thread.sleep(2000);
		 * 
		 * //act.moveToElement(wd.findElement(By.xpath(locatorprop.getProperty(
		 * "PS_deletebtn")))).click().build().perform();
		 * 
		 * wd.findElement(By.xpath(locatorprop.getProperty("PS_deletebtn"))).click();
		 * Thread.sleep(2000); wait.until(ExpectedConditions.alertIsPresent());
		 * wd.switchTo().alert().accept();
		 * 
		 * List<WebElement> listorrow = wd
		 * .findElements(By.xpath(locatorprop.getProperty("count_categorylist"))); if
		 * (listorrow.size() == 0) { takescreenshot();
		 * System.out.println("PASS -- Data deleted successfully"); } else if
		 * (listorrow.size() >= 1) {
		 * 
		 * System.out.println("FAIL -- data not deleted successfully");
		 * takescreenshot();
		 * wd.findElement(By.xpath(locatorprop.getProperty("PS_deletebtn"))).click();
		 * Thread.sleep(2000); wait.until(ExpectedConditions.alertIsPresent());
		 * wd.switchTo().alert().accept(); } else
		 * System.out.println("Data Not Exsist in the Table"); }
		 * 
		 * } } else { System.out.println("No data table found in the page"); }
		 */
	}

}
