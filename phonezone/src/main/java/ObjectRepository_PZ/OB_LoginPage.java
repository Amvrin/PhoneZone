package ObjectRepository_PZ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OB_LoginPage 
{
	WebDriver driver;
	
	@FindBy(id="email")
	WebElement EmailInput;

	@FindBy(id="password") 
	WebElement PasswordInput;

	@FindBy(xpath="//*[@id='login-form']/button")  
	WebElement LoginButton;

	@FindBy(xpath="//div[2]/center[1]/a")
	WebElement ForgotPasswordLink;
	
	@FindBy(xpath="//div[2]/center[2]/a")
	WebElement MainMenuLink;

	
	
	public OB_LoginPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement EmailInput()
	{
		return EmailInput;
	}
	
	public WebElement PasswordInput()
	{
		return PasswordInput;
	}
	
	public WebElement LoginButton()
	{
		return LoginButton;
	}
	
	
	public WebElement ForgotPasswordLink()
	{
		return ForgotPasswordLink;
	}
	
	
	public WebElement MainMenuLink()
	{
		return MainMenuLink;
	}
}
