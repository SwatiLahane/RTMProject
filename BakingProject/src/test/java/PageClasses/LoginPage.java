package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class LoginPage extends BaseClass
{
    WebDriver driver;
    
    public LoginPage(WebDriver driver)
    {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath="(//a[@class='t-menu__link-item'])[5]")
    WebElement login;	
    
   
    @FindBy(xpath ="//input[@id='input_1495646567135']")
    WebElement loginUsername;
    
    @FindBy(xpath ="//input[@id='input_1742715919526']")
    WebElement loginPassword;
    
    ////button[@type='submit']
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btn;
    
    @FindBy(xpath="//div[@class='js-successbox t-form__successbox t-text t-text_md']")
	WebElement textMessage;
    
    public void clickonLogin()
    {
    	login.click();
    }
	public void enterUid(String userName)
	{
		loginUsername.sendKeys(userName);
	}
	public void enterPassword(String passwrd)
	{
		loginPassword.sendKeys(passwrd);
	}
	public void clickOnSubmit()
	{
		btn.click();
	}
    public String VerifyMessage()
	{
		String message=textMessage.getText();
		return message;
	}
}
