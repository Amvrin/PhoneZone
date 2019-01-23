package ObjectRepository_PZ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OB_dashboardPage 
{
	WebDriver driver;
	
	
//*************************Finding WebElements*************************************//	 
//	Admin button
	@FindBy(xpath="//a[1][@role='button']")
	WebElement admn_btn;		
	
//	Staff Orders table
	@FindBy(xpath="//*[@id='no-more-tables']/table")
	WebElement staffOrdersTable;
	
//	List of pagination links
	WebElement StaffOrders_PaginationLinks;
	
//***************************************************************//
//	Page Title & various section heading texts on dashboard page
	
	@FindBy(xpath="//*[@id='page-wrapper']/div/div[1]/h3")
	WebElement getCurrentPageHeadingText;
	
	@FindBy(xpath="//html/head/title")
	WebElement getPageTitle;
	
	@FindBy(xpath="//div[@class='tables']/h4[contains(text(),'Staff Orders')]")
	WebElement section_heading1;
	
	@FindBy(xpath="//div[@class='tables']/h4[contains(text(),'WholeSeller Orders')]")
	WebElement section_heading2;
	
	@FindBy(xpath="//div[@class='tables']/h4[contains(text(),'Low Inventory Products')]")
	WebElement section_heading3;
	
	@FindBy(xpath="//*/h4[contains(text(),'Stock Take')]")
	WebElement section_heading4;

//***************************************************************//
	
	@FindBy(xpath="//*[@id='side-menu']/li[1]/a")
	WebElement DashboardMenuItem;
	
//	Profile Menu link
	@FindBy(xpath="*//div[2]/ul/li/a/div/div[1]/p")
	WebElement PhoneZoneMenu;
	
//	Update Profile Link
	@FindBy(xpath="*//div[2]/ul/li/ul/li[1]/a")
	WebElement updateProfileLink;
	
//	Logout Profile Link
	@FindBy(xpath="//div[2]/ul/li/ul/li[2]/a[@text='Logout']")
	WebElement logoutLink;
//***************************************************************//

	
//*************************Initializing the web elements********//
	public OB_dashboardPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

//**************************Methods*************************************//
	public WebElement admin_button()
	{
		return admn_btn;
	}
	
//	Returning staff orders table
	public WebElement staffOrdersTable()
	{
		return staffOrdersTable;
	}
	
//	Returning pagination link elements
	public WebElement StaffOrders_PaginationLinks()
	{
		return StaffOrders_PaginationLinks;
	}
	
//	Returning Page Title & various section heading texts
	
	public WebElement getCurrentPageHeadingText()
	{
		return getCurrentPageHeadingText;
	}
	
	public WebElement getPageTitle()
	{
		return getPageTitle;
	}
	
	public WebElement section_heading1()
	{
		return section_heading1;
	}
	public WebElement section_heading2()
	{
		return section_heading2;
	}
	public WebElement section_heading3()
	{
		return section_heading3;
	}
	public WebElement section_heading4()
	{
		return section_heading4;
	}
	
//	Returning menu items links
	
	
	public WebElement DashboardMenuItem()
	{
		return DashboardMenuItem;
	}
	
	public WebElement updateProfileLink()
	{
		return updateProfileLink;
	}
	
	public WebElement logoutLink()
	{
		return logoutLink;
	}
	
//	Returning Profile Menu link
	public WebElement PhoneZoneMenu()
	{
		return PhoneZoneMenu;
	}
	
}
