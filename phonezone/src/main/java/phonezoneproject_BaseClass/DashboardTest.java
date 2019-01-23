package phonezoneproject_BaseClass;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository_PZ.OB_LandingPage;
import ObjectRepository_PZ.OB_LoginPage;
import ObjectRepository_PZ.OB_dashboardPage;

public class DashboardTest extends BaseClass
{
	
	
	
	@Test(priority=0)
	public void adminLogin() throws InterruptedException, IOException
	{
		OB_LandingPage obj_OB_LandingPage = new OB_LandingPage(wd);
		OB_LoginPage obj_OB_LoginPage = new OB_LoginPage(wd);
		OB_dashboardPage obj_OB_dashboardPage = new OB_dashboardPage(wd);
		
		obj_OB_LandingPage.admin_button().click();
		Thread.sleep(4000);
		obj_OB_LoginPage.EmailInput().sendKeys("dhananjay.singh@datagenius.co.nz");
		obj_OB_LoginPage.PasswordInput().sendKeys("phonezone@18#$");
		obj_OB_LoginPage.LoginButton().click();
		Thread.sleep(3000);
		capture("Admin_0_",filename);
		System.out.println(obj_OB_dashboardPage.getCurrentPageHeadingText().getText().trim());

	}
	
	@Test(priority=1)
	public void checkDashboardSections() throws InterruptedException, IOException
	{
		String sections[] = new String[4];
		sections[0] = "Staff Orders";
		sections[1] = "WholeSeller Orders";
		sections[2] = "Low Inventory Products";
		sections[3] = "Stock Take";
		OB_dashboardPage obj_OB_dashboardPage = new OB_dashboardPage(wd);
		Assert.assertEquals(obj_OB_dashboardPage.section_heading1().getText(),sections[0],"Section1 matched.");
		Assert.assertEquals(obj_OB_dashboardPage.section_heading2().getText(),sections[1],"Section2 matched.");
		Assert.assertEquals(obj_OB_dashboardPage.section_heading3().getText(),sections[2],"Section3 matched.");
		Assert.assertEquals(obj_OB_dashboardPage.section_heading4().getText(),sections[3],"Section4 matched.");
		Thread.sleep(2000);
		capture("Admin_1_",filename);
	}
	
	@Test(priority=2)
	public void clickUpdateProfileLink() throws InterruptedException, IOException
	{
		String UpdateProfilePageTitle = "Phone Zone: :Administrator Panel";
		OB_dashboardPage obj_OB_dashboardPage = new OB_dashboardPage(wd);
		obj_OB_dashboardPage.PhoneZoneMenu().click();
		obj_OB_dashboardPage.updateProfileLink().click();
		Thread.sleep(10000);
		Assert.assertEquals(obj_OB_dashboardPage.getCurrentPageHeadingText().getText().trim(),"Change Password");
		System.out.println("Reached Change Password page.");
		capture("Admin_2_",filename);
	}
	
	
	@Test(priority=3)
	public void viewOrderDetails_First() throws InterruptedException, IOException
	{
		int Rownum=0;
		int Cellnum=0;
		Random rand = new Random();
		int n = rand.nextInt(11);
		
		OB_dashboardPage obj_OB_dashboardPage = new OB_dashboardPage(wd);
		obj_OB_dashboardPage.DashboardMenuItem().click();
		Thread.sleep(2000);
		WebElement table = obj_OB_dashboardPage.staffOrdersTable();
		WebElement tableBody;
		WebElement tableRow;
		WebElement tableData;
		WebElement orderNumber;
		
		
		tableBody = table.findElement(By.tagName("tbody"));
		tableRow = tableBody.findElement(By.tagName("tr"));
		tableData = tableRow.findElement(By.tagName("td"));
		orderNumber = tableData.findElement(By.tagName("a"));
		orderNumber.click();
		
//		List<WebElement> staffOrdersList = table.findElements(By.tagName("tr"));
//		for (WebElement row : staffOrdersList)
//		{
//			Rownum++;
//			List<WebElement> cells = row.findElements(By.tagName("td"));
//			orderNumber = cells.get(0).findElement(By.tagName("a"));
//			orderNumber.click();
			Thread.sleep(2000);
////			for(WebElement cell : cells)
////			{
////				Cellnum++;
////				
////				
////			}
//			
//			System.out.println("Total cells in Row no. "+(Rownum-1)+" are: "+Cellnum);
//			Cellnum=0;
//			break;
//		}
		//System.out.println("No. of rows: "+(Rownum-1));
		
		
//		List<WebElement> allRows = table.findElements(By.tagName("tr"));
//		// And iterate over them, getting the cells
//		for (WebElement row : allRows) {
//		    List<WebElement> cells = row.findElements(By.tagName("td"));
//		    for (WebElement cell : cells) {
//		        System.out.println("content >>   " + cell.getText());
//		    }
//		}
		
			capture("Admin_3_",filename);
		
	}
	
}
