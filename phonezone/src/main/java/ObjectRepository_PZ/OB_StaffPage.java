package ObjectRepository_PZ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OB_StaffPage 
{
	WebDriver driver;
	
	//DashboardLink on the Menu bar on top of the dashboard page
	@FindBy(xpath="//*[@id='page-wrapper']/div/ol/li[1]/a")
	WebElement DashboardLinkMenuBarOnTop;
	
	//Staff button link on the Phonezone linkonmov Homepage
	@FindBy(xpath="//div[2]/div/div/a[2]")
	WebElement StaffButtonOnHomepage;
	
	//Modal Popup on Staff Dashboard page
	@FindBy(xpath="//*[@id='selectStore']/div")
	WebElement ModalPopupOnStaffDashboard;
	
	//Stock Take menu link on the LHS(left hand side) menu
	@FindBy(xpath="//*[@id='side-menu']/li[3]/a")
	WebElement StockTakeMenu;
	
	//Send Stock menu sub-item under Stock Menu on the LHS(left hand side) menu
	@FindBy(xpath="//*[@id='side-menu']/li[3]/ul/li/a")
	WebElement SendStockSubMenu;
	
	
	//*[@id='login-form']/button   login button for staff login
	@FindBy(xpath="//*[@id='login-form']/button")
	WebElement ButtonForStaffLogin;
	
	//Search Textbox for Product Name
	@FindBy(xpath="//*[@id='product_name']")
	WebElement SearchTextboxForProductName;
	
	//Select Category ID for Product
	@FindBy(id="categories_id")
	WebElement SelectCategoryIDForProduct;
	
	//Select Sub-Category ID for Product
	@FindBy(id="sub_categories_id")
	WebElement SelectSubCategoryIDForProduct;
	
	//Select Sub-Sub-Category ID for Product
	@FindBy(id="sub_sub_categories_id")
	WebElement SelectSubSubCategoryIDForProduct;
	
	//Search Button for Product Searching
	@FindBy(name="search_button")
	WebElement SearchButtonForProductSearch;
	
	//Download Stock Take button
	@FindBy(xpath="//*[@id='default_load']/div[1]/div/div[1]/a/button")
	WebElement DownloadStockTakeButton;
	
	//	Staff - Product Listing
	@FindBy(xpath="//*[@id='no-more-tables']/table")
	WebElement ProductListingTable;
	
	//	Order by Select WebElement
	@FindBy(name="record_sort_by")
	WebElement OrderBySelect;
	
	
	public OB_StaffPage (WebDriver driver) 
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement DashboardLinkMenuBarOnTop()
	{
		return DashboardLinkMenuBarOnTop;
		
	}
	
	public WebElement StaffButtonOnHomepage()
	{
		return StaffButtonOnHomepage;
		
	}
	
	public WebElement ModalPopupOnStaffDashboard()
	{
		return ModalPopupOnStaffDashboard;
		
	}
	
	public WebElement ButtonForStaffLogin()
	{
		return ButtonForStaffLogin;
		
	}
	
	public WebElement StockTakeMenu()
	{
		return StockTakeMenu;
		
	}
	
	public WebElement SendStockSubMenu()
	{
		return SendStockSubMenu;
		
	}
	
	
	
	public WebElement SearchTextboxForProductName()
	{
		return SearchTextboxForProductName;
	}
	
	public WebElement SelectCategoryIDForProduct()
	{
		return SelectCategoryIDForProduct;
	}
	
	public WebElement SelectSubCategoryIDForProduct()
	{
		return SelectSubCategoryIDForProduct;
	}
	
	public WebElement SelectSubSubCategoryIDForProduct()
	{
		return SelectSubSubCategoryIDForProduct;
	}
	
	public WebElement SearchButtonForProductSearch()
	{
		return SearchButtonForProductSearch;
		
	}
	
	public WebElement DownloadStockTakeButton()
	{
		return DownloadStockTakeButton;	
	}
	
	//	Returning staff orders table
	public WebElement ProductListingTable()
	{
		return ProductListingTable;
	}
	
//	Returning staff orders table
	public WebElement OrderBySelect()
	{
		return OrderBySelect;
	}
	
}
