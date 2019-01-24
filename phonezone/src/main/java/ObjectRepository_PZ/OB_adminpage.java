package ObjectRepository_PZ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OB_adminpage
{

	WebDriver driver;
	
	
 
//	Admin button
	@FindBy(xpath="//a[1][@role='button']")
	WebElement admn_btn;		
	
	

	
//	Initializing the web elements
	public OB_adminpage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
   
//	Returning the admin button
	public WebElement admin_button()
	{
		return admn_btn;
	}
	

	
}
