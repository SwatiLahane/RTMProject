package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.BaseClass;

//These are page class
public class SignUpPage extends BaseClass //inheritance implimented
{
    
WebDriver driver;
	
	public SignUpPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@class='t-menu__link-item'])[3]")
	WebElement signUp;
	
	@FindBy(xpath="//input[@id='input_1495646567135']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='input_1500473664921']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='input_1495646533382']")
	WebElement phone;
	
	@FindBy(xpath="//input[@id='input_1742711839224']")
	WebElement dob;
	
	@FindBy(xpath="//select[@id='input_1742711863977']")
	WebElement selectGender;
	
	@FindBy(xpath = "//input[@id='input_1742711965354']")
	WebElement city;
	
	@FindBy(xpath = "//input[@id='input_1742711986078']")
	WebElement userName;
	
	@FindBy(xpath = "//input [@id='input_1742712432708']")
	WebElement passWord;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath="//div[@class='js-successbox t-form__successbox t-text t-text_md']")
	WebElement textMessage;
	
	
	public void clickOnSignUp()
	{
		signUp.click();
	}
	
	
	public void enterFirstName(String fName)
	{
		firstName.sendKeys(fName);
	}
	
	
	public void enterLastName(String lName)
	{
		lastName.sendKeys(lName);
	}
	
	public void enterPhone(String phonenum)
	{
		phone.sendKeys(phonenum);
	}
	
	public void enterDOB(String dateOfBirth)
	{
		dob.sendKeys(dateOfBirth);
	}
	
	public void selectGender(int x)
	{
		Select oselect=new Select(selectGender);
		oselect.selectByIndex(x);
	}
	
	public void enterCityName(String City)
	{
		city.sendKeys(City);
	
	}
	
	public void enterUserId(String uName)
	{
		userName.sendKeys(uName);
	
	}
	public void enterPassword(String password)
	{
		 passWord.sendKeys(password);
	
	}
	public void clickonSubmit()
	{
		submitButton.submit();
	}
	
	public String validateMessage()
	{
		String message=textMessage.getText();
		return message;
	}
	
	
	
}
