package ObjectRepository_PZ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OB_LandingPage 
{
	WebDriver driver;
	
//	Admin button
	@FindBy(xpath="//a[1][@role='button']")
	WebElement admin_btn;		
	
//	Staff button
	@FindBy(xpath="//a[2][@role='button']")
	WebElement staff_btn;
	
//	Wholeseller button
	@FindBy(xpath="//a[3][@role='button']")
	WebElement whlslr_btn;


//	Initializing the web elements
	public OB_LandingPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
   
//	Returning the admin button
	public WebElement admin_button()
	{
		return admin_btn;
	}
	
//	Returning the staff button
	public WebElement staff_button()
	{
		return staff_btn;
	}
	
//	Returning the wholeseller button
	public WebElement wholeseller_button()
	{
		return whlslr_btn;
	}
}
