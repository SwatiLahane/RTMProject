package Utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass 
{
	 
	static String browserName;
	public static WebDriver driver;
	
	public static WebDriver initializeDriver() 
	{
		
		try {
			browserName=FetchDataFromProperty.readDataFromProperty().getProperty("browser");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			
			driver = new ChromeDriver();
			try {
				driver.get(FetchDataFormExcel.getURL());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver.manage().window().maximize();
			
		}
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			
			driver=new FirefoxDriver();
			try {
				driver.get(FetchDataFormExcel.getURL());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			driver.manage().window().maximize();
		}
		
		if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			try {
				driver.get(FetchDataFormExcel.getURL());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			driver.manage().window().maximize();
		}
		
		return driver;
		
	}
	
	public static void addImplicitWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public static void scrollDown()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	public static void scrollUp()
	{
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,500)", "");
		
	}
	
	public static String getPageTitle()
	{
	   String title=driver.getTitle();
	   return title;
	}
	
	
	public static void addHardcodedWait() throws InterruptedException
	{
		Thread.sleep(5000);
	}
	
	public void addExplicitWait(By locator)
	{
	   //By WebDriver wait = new WebDriver(driver);	
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
    public void getWindowHandle()
    {
    	//accountDetails.click();  
		Set<String> s1 = driver.getWindowHandles();
		System.out.println(s1);
		
		Iterator<String> i1 = s1.iterator();
		
		String ParentId = i1.next();
		String ChildId = i1.next();
		
		driver.switchTo().window(ChildId);

    }
   
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	
}
