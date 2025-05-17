package PageClasses;

import org.apache.xmlbeans.impl.soap.Text;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.TextMessage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class ContactUsPage extends BaseClass
{
           
	WebDriver driver;
	
	public ContactUsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="(//a[@class='t-menu__link-item'])[2]")
//	@FindBy(linkText = "Contacts Us")
	WebElement clickOnContactUsLink;

   @FindBy(xpath="//input[@id='input_1496238250184']")
   WebElement contactName;
   
   @FindBy(xpath = "//input[@id='input_1496238230199']")
   WebElement contactEmail;
   
   @FindBy(xpath = "//input[@id='input_1496238259342']")
   WebElement contactPhoneNumber;   
   
   @FindBy(xpath ="//input[@id='input_1496238259342']")
   WebElement contactAddress;
   
  @FindBy(xpath = "//input[@id='input_1742714886366']")
  WebElement contactCountry;   
		  
  
  @FindBy(xpath ="//input[@id = 'input_1742714901821']")
  WebElement zipCode;
  
  @FindBy(xpath = "//button[@type='submit']")
  WebElement submitButton;
  
  @FindBy(xpath="//div[@class='js-successbox t-form__successbox t-text t-text_md']")
	WebElement cntactUstextMessage;
  //Methods
   public void ClickOnContactUs()
   {
	   clickOnContactUsLink.click();
   }
   public void enterName(String fName)

   {
	   contactName.sendKeys(fName);
   }
   public void enterEmail(String emailId)
   {
	   contactEmail.sendKeys(emailId);
   }
   public void enterPhoneNumber(String phoneNumber)
   {
	   contactPhoneNumber.sendKeys(phoneNumber);
   }
   public void enterAddress(String address)
   {
	   contactAddress.sendKeys(address);
   }
   public void enterCountry(String country)
   {
	   contactCountry.sendKeys(country);
   }
   public void enterZipCode(String ZipCode)
   {
	   zipCode.sendKeys(ZipCode);
   }
   public void ClickOnSubmitBtn()
   {
	   submitButton.click();
   }
   
   public  String VerifyMessage()
	{
		String message1= cntactUstextMessage.getText()  ;
		return message1;
	}
}
