package PageClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.poifs.property.Child;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.BaseClass;

public class AccountDetailPage extends BaseClass

{
               
	    WebDriver driver;
	    WebDriverWait wait;

	    public AccountDetailPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Corrected Duration usage
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(xpath = "//a[contains(text(),'Account Detail')]")
	    WebElement accDetailslink;

	    @FindBy(xpath = "//select[@id='collection_comp-m8swuunx']")
	    WebElement selectName;

	    @FindBy(xpath="//div[@id='menuitem-0']")
		WebElement accOne;
	    
	    @FindBy(xpath="//button[.='Login']")
		WebElement loginButton;

	  //  @FindBy(xpath = "//span[contains(text(),'Login')]")
	    //WebElement loginBtn;
	    
	    
	    @FindBy(xpath = "//div[@id='tab-comp-m8szwsxa']")      //morelocaters//div[@id='tab-comp-m8szwsxa']  //span[text()='Deposit']  
		WebElement depositTab;

		@FindBy(xpath = "//input[@id='input_comp-m8t00o79']")
		WebElement depositAmount;

		@FindBy(xpath="//div[@id='comp-m8t0270q']")
		WebElement depositButton;

		@FindBy(xpath = "//div[@id='tab-comp-m8szwsx41']")
		WebElement WithdrawlTab;

		@FindBy(xpath = "//input[@id='input_comp-m8t03jwk']")
		WebElement WithdrawlAmount;

		@FindBy(xpath="//div[@id='comp-m8t03jwx']")
		WebElement WithdrawButton;
	    
	    
	    public void clickonAccountDetails() {
	        addImplicitWait();
	    	accDetailslink.click();
	    }
	    
	    
	    
	    public void selectAccount() throws  InterruptedException
		{
			addHardcodedWait();
			selectName.click();
			addExplicitWait(By.xpath("//div[@id='menuitem-0']"));
			accOne.click();

		}
	    
	   


	    public void Login() throws InterruptedException {
	    	addImplicitWait();
	        loginButton.click();
	        Thread.sleep(5000);
	    }
	    
	    public void clickonDepositTab()
		{
			depositTab.click();
		}

		public void enterDepositAmount(String amountToBeDeposit)
		{
			depositAmount.sendKeys(amountToBeDeposit);
		}
		
		public void clickonDepositButton()
		{
			depositButton.click();
		}
		
		public void clickonWithdrawlTab()
		{
			WithdrawlTab.click();
		}

		public void enterWithdrawAmount(String amountToBeWithdraw)
		{
			WithdrawlAmount.sendKeys(amountToBeWithdraw);
		}
		
		public void clickonWithdrawlButton()
		{
			WithdrawButton.click();
		}
		

	}
	    
	    
	
	
