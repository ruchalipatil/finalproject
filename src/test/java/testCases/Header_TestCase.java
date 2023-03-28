package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import Resources.BaseClass;
import Resources.CommonUtilities;
import Resources.Constant;
import pageObjectModel.AddToCart_Product_PageObject;
import pageObjectModel.Header_PageObject;
import pageObjectModel.MainMenu_PageObject;

public class Header_TestCase extends BaseClass {

	@Test
	public static void verifyHeader() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 WebDriver driver = new ChromeDriver(options);
		 driver.get("https://naveenautomationlabs.com/opencart/");
		
		Header_PageObject hpo=new Header_PageObject(driver);
		AddToCart_Product_PageObject apo=new AddToCart_Product_PageObject(driver);
		MainMenu_PageObject mpo = new MainMenu_PageObject(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//Currency
		hpo.currencyClick().click();
		hpo.currencyOptionSelect().click();
//PhoneNo
		hpo.phoneClick().click();
		hpo.phoneNameEnter().sendKeys(Constant.phone_name);
		hpo.phoneEmailEnter().sendKeys(Constant.phone_email);
		hpo.phoneEnquiryEnter().sendKeys(Constant.phone_enquiry);
		hpo.phoneSubmitClick().click();
//Account 
		hpo.accountClick().click();
		hpo.accountLoginClick().click();
		hpo.accountEmailEnter().sendKeys(Constant.account_email);
		hpo.accountPasswordEnter().sendKeys(Constant.account_password);
		hpo.accountLoginBtnClick().click();
//WishList
		hpo.wishlistClick().click();
		apo.searchEnter().sendKeys(Constant.search1);
		apo.searchBtnClick().click();
		mpo.desktopAddtoWishlistClick().click();
		hpo.wishlistToAddCart().click();
		
//Shopping Cart
		hpo.shoppingCartClick().click();
		hpo.shoppingCartQtyEnter().sendKeys(Constant.shop_cart_qty);
		hpo.shoppingCartRefreshClick().click();
//Checkout
		hpo.checkoutClick().click();
		hpo.checkoutEstimateShipTaxClick().click();
		CommonUtilities.handleDropDownByVisibleText(hpo.checkoutCountrySelect(),Constant.checkout_country);
		hpo.checkoutStateSelect().click();
		CommonUtilities.handleDropDownByVisibleText(hpo.checkoutStateSelect(),Constant.checkout_state);
		hpo.checkoutPincodeEnter().sendKeys(Constant.checkout_pincode);
		hpo.checkoutGetQuotesClick().click();
		hpo.checkoutGetQuotesPopupRadiobtnSelect().click();
		hpo.checkoutGetQuotesPopupApplyClick().click();
		
	}
}
