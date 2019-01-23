package ObjectRepository_PZ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OB_WholesellerPage 
{
	WebDriver driver;
	
	//DashboardLink on the Menu bar on top of the dashboard page
	@FindBy(xpath="//*[@id='page-wrapper']/div/ol/li[1]/a")
	WebElement DashboardLinkMenuBarOnTop;
	
	
	@FindBy(xpath="//*[@id='side-menu']/li[1]/a")
	WebElement sideMenuDashboardLink;

	
	
	
	public OB_WholesellerPage (WebDriver driver) 
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement DashboardLinkMenuBarOnTop()
	{
		return DashboardLinkMenuBarOnTop;
		
	}
	
	public WebElement sideMenuDashboardLink()
	{
		return sideMenuDashboardLink;
		
	}
}
