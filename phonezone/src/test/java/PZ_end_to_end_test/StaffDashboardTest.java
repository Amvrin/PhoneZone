package PZ_end_to_end_test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ObjectRepository_PZ.OB_StaffPage;
import ObjectRepository_PZ.OB_LoginPage;
import ObjectRepository_PZ.OB_LandingPage;
import ObjectRepository_PZ.OB_dashboardPage;
import phonezoneproject_BaseClass.Adminlogin_credential;
import phonezoneproject_BaseClass.BaseClass;
import phonezoneproject_BaseClass.Stafflogin_credential;

public class StaffDashboardTest extends BaseClass
{
	
	
	@Test(priority = 1)
	public void login_to_Admin_page() throws InterruptedException {
		Stafflogin_credential sc = new Stafflogin_credential();
		sc.login_Staff_page();
	}
	
	@Test(priority=2)
	public void staffLogin_and_StoreSelector() throws Throwable
	{
		//Object repository object declarations
		OB_StaffPage obj_OB_StaffPage = new OB_StaffPage(wd);
		OB_LoginPage obj_OB_LoginPage = new OB_LoginPage(wd);
		OB_LandingPage obj_OB_LandingPage = new OB_LandingPage(wd);
		OB_dashboardPage obj_OB_dashboardPage = new OB_dashboardPage(wd);
		
		int Rownum=0;
		int Cellnum=0;
				
		//Clicking on store name
		List<WebElement> storesList = obj_OB_StaffPage.ModalPopupOnStaffDashboard().findElements(By.tagName("li"));
		for (WebElement store : storesList)
		{
			store.findElement(By.xpath("//*[@id='Stores_5']")).click();
			break;
		}
		
		
		//capture("Staff_0_",filename);
		takescreenshot();
		
	}
	
	
	@Test(priority=3)
	public void NavigateToDashboardViaTopMenu() throws Throwable
	{
		OB_StaffPage obj_OB_StaffPage = new OB_StaffPage(wd);
		OB_dashboardPage obj_OB_dashboardPage = new OB_dashboardPage(wd);
		
		Thread.sleep(3000);
		obj_OB_StaffPage.DashboardLinkMenuBarOnTop().click();
		Thread.sleep(2000);
		//Code for Logging-out
		//Thread.sleep(3000);
		//obj_OB_dashboardPage.PhoneZoneMenu().click();
		//obj_OB_dashboardPage.logoutLink().click();
		takescreenshot();
	}
	
	
	@Test(priority=4)
	public void StockTakeMenu() throws InterruptedException
	{
		OB_StaffPage obj_OB_StaffPage = new OB_StaffPage(wd);
		obj_OB_StaffPage.StockTakeMenu().click();
		obj_OB_StaffPage.SendStockSubMenu().click();
		Thread.sleep(2000);
		
		
	}
	
	@Test(priority=5)
	public void SortByBarcodeAscending() throws InterruptedException
	{
		OB_StaffPage obj_OB_StaffPage = new OB_StaffPage(wd);
		Select selectOrderBy = new Select(wd.findElement(By.name("record_sort_by")));
		selectOrderBy.selectByVisibleText("Barcode (Ascending)");
		Thread.sleep(2000);
	}
	
	@Test(priority=6)
	public void SortByBarcodeDescending() throws InterruptedException
	{
		OB_StaffPage obj_OB_StaffPage = new OB_StaffPage(wd);
		Select selectOrderBy = new Select(wd.findElement(By.name("record_sort_by")));
		selectOrderBy.selectByVisibleText("Barcode (Descending)");
		Thread.sleep(2000);
	}
	
	@Test(priority=7)
	public void SortByTitleAscending() throws InterruptedException
	{
		OB_StaffPage obj_OB_StaffPage = new OB_StaffPage(wd);
		Select selectOrderBy = new Select(wd.findElement(By.name("record_sort_by")));
		selectOrderBy.selectByVisibleText("Title (Ascending)");
		Thread.sleep(2000);
	}
	
	@Test(priority=8)
	public void SortByTitleDescending() throws InterruptedException
	{
		OB_StaffPage obj_OB_StaffPage = new OB_StaffPage(wd);
		Select selectOrderBy = new Select(wd.findElement(By.name("record_sort_by")));
		selectOrderBy.selectByVisibleText("Title (Descending)");
		Thread.sleep(2000);
	}
	
	@Test(priority=9)
	public void SearchProductByName() throws InterruptedException
	{
		long timeout = 3000;
		
		final WebDriverWait wait = new WebDriverWait(wd, timeout);
		
		//Variable Declaration
		Select selectCategoryIDForProduct, selectSubCategoryIDForProduct, selectSubSubCategoryIDForProduct;
		OB_StaffPage obj_OB_StaffPage = new OB_StaffPage(wd);
		String prod_name;
		int num=0;
		
		Random random = new Random(); 
        num = random.nextInt(5); 
        
		switch(num)
		{
			case 1:
				prod_name="Eraser";
				break;
			case 2:
				prod_name="Pencil";
				break;
			case 3:
				prod_name="Sharpener";
				break;
			case 4:
				prod_name="Paper";
				break;
			default:
				prod_name="Pen";
				break;
		}
		
		obj_OB_StaffPage.SearchTextboxForProductName().sendKeys(prod_name);
		selectCategoryIDForProduct = new Select(wd.findElement(By.id("categories_id")));
		selectCategoryIDForProduct.selectByVisibleText("Accessories");
		
		
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.refreshed(
		        ExpectedConditions.elementToBeClickable(By.id("sub_categories_id"))));
		selectSubCategoryIDForProduct = new Select(wd.findElement(By.id("sub_categories_id")));
	    //wd.findElement(By.id("sub_categories_id")).click();
		
		selectSubCategoryIDForProduct.selectByVisibleText("Computer Accessories");
		
		
		
		   Thread.sleep(2000);
	    wait.until(ExpectedConditions.refreshed(
	        ExpectedConditions.elementToBeClickable(By.id("sub_sub_categories_id"))));
	    selectSubSubCategoryIDForProduct = new Select(wd.findElement(By.id("sub_sub_categories_id")));
	    //wd.findElement(By.id("sub_sub_categories_id")).click();
	 
	    selectSubSubCategoryIDForProduct.selectByVisibleText("Earphones");
	    
		obj_OB_StaffPage.SearchButtonForProductSearch().click();
		
		
		Thread.sleep(3000);
	}
	
	
	@Test(priority=10)
	public void SendStock() throws InterruptedException
	{
		
	}
	
	@Test(priority=11)
	public void DownloadStockTake() throws InterruptedException, AWTException
	{
		long timeout = 3000;
		final WebDriverWait wait = new WebDriverWait(wd, timeout);
		
		OB_StaffPage obj_OB_StaffPage = new OB_StaffPage(wd);
		obj_OB_StaffPage.DownloadStockTakeButton().click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.refreshed(
		        ExpectedConditions.elementToBeClickable(By.tagName("button"))));
		
		System.out.println(System.getenv("USERPROFILE")+"\\Downloads\\");
		WebElement table = obj_OB_StaffPage.ProductListingTable();
		WebElement tableBody;
		WebElement tableRow;
		WebElement tableData;
		//WebElement div1;
		//WebElement div2;
		WebElement plusButton;
		
		Thread.sleep(2000);
		tableBody = table.findElement(By.tagName("tbody"));
		tableRow = tableBody.findElement(By.tagName("tr"));
		tableData = tableRow.findElement(By.tagName("td"));
		//div1 = tableData.findElement(By.tagName("div"));
		//div2 = tableData.findElement(By.tagName("div"));
		plusButton = tableData.findElement(By.xpath("//button[2]"));
		//plusButton = tableData.findElement(By.xpath("//button[@data-spin='up']"));
		for(int i=0;i<5;i++)
		{
			plusButton.click();
			Thread.sleep(2000);
		}
		obj_OB_StaffPage.DownloadStockTakeButton().click();
		Thread.sleep(3000);
		Robot r=new Robot();
		r.mouseMove(1350, 700);
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
		
	
	}

}
