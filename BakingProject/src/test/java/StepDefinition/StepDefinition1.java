package StepDefinition;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageClasses.AccountDetailPage;
import PageClasses.ContactUsPage;
import PageClasses.ForgetPasswordPage;
import PageClasses.LoginPage;
import PageClasses.SignUpPage;
import Utilities.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StepDefinition1 extends BaseClass {

	WebDriver driver = BaseClass.initializeDriver();

	String ActualMessage = "Thank you! Your data has been submitted.";
	SignUpPage signp;
	LoginPage login;
	ForgetPasswordPage fp;
	AccountDetailPage ADP;
	ContactUsPage CUP;

	// ----------------------Initialization---------------------------//
	@Before //beforehook
	public void initializeSetup() {
		signp = new SignUpPage(driver);
		login = new LoginPage(driver);
		fp = new ForgetPasswordPage(driver);
		ADP = new AccountDetailPage(driver);
		CUP = new ContactUsPage(driver);

	}

	// --------------------------------Tear Down----------------------------------------//
	@After // after hook
	public void tearDown() throws InterruptedException {
		addHardcodedWait();
		driver.close();
	}

//------------Common Method----------------------------------------------//

	@Given("user open the url for banking application")
	public void user_open_the_url_for_banking_application() {

		System.out.println("Application launched");
		// System.out.println(getPageTitle());
		String title = getPageTitle();
		Assert.assertEquals(title, "Home");

	}

	/*--------------------------------------SignUp -------------------------------------------------------*/

	@Given("user clicks on SignUp button in WebPage")
	public void user_clicks_on_sign_up_button_in_web_page() {

		signp.clickOnSignUp();
	}

	@Given("user enters the firstname as {string}")
	public void user_enters_the_firstname_as(String firstname) {

		signp.enterFirstName(firstname);

	}

	@Given("user enters the lastname as {string}")
	public void user_enters_the_lastname_as(String lastname) {

		signp.enterLastName(lastname);

	}

	@Given("user enters the phonenumber as {string}")
	public void user_enters_the_phonenumber_as(String phonenumber) {

		signp.enterPhone(phonenumber);
		scrollDown();

	}

	@Given("user enters the dateofBirth as {string}")
	public void user_enters_the_dateof_birth_as(String DOB) throws InterruptedException {

		// addHardcodedWait();
		signp.enterDOB(DOB);
		addHardcodedWait();

	}

	@Given("user selects the gender")
	public void user_selects_the_gender() {

		signp.selectGender(2);

	}

	@Given("user enters the cityname as {string}")
	public void user_enters_the_cityname_as(String City) {

		signp.enterCityName(City);
	}

	@Given("user enters the userid as {string}")
	public void user_enters_the_userid_as(String userId) {

		signp.enterUserId(userId);

	}

	@Given("user enters the password as {string}")
	public void user_enters_the_password_as(String PassWord) {

		signp.enterPassword(PassWord);

	}

	@When("user clicks on Submit button")
	public void user_clicks_on_submit_button() {

		scrollDown();
		signp.clickonSubmit();
	}

	@Then("validate that user is getting proper response from site")
	public void validate_that_user_is_getting_proper_response_from_site() throws InterruptedException {

		// String msg= signp.validateMessage();
		// Assert.assertEquals(ActualMessage, msg);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		// xpath matching the element that contains the success message
		By SuccessMsgLocator = By.xpath("//div[@class='js-successbox t-form__successbox t-text t-text_md']");

		// Wait until success message appears and contains expected text
		wait.until(ExpectedConditions.textToBePresentInElementLocated(SuccessMsgLocator, "Thank you!"));

		WebElement SuccessMsgElement = driver.findElement(SuccessMsgLocator);
		String actualMessage = SuccessMsgElement.getText();

		System.out.println("Actual message: " + actualMessage);

		// Assertion
		Assert.assertEquals(ActualMessage.trim(), "Thank you! Your data has been submitted.");

	}

	@Then("also verify that the Title of the page is showing correct value")
	public void also_verify_that_the_title_of_the_page_is_showing_correct_value() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		By.xpath("//div[@class='js-successbox t-form__successbox t-text t-text_md']");

		// Wait for title contain Registration
		wait.until(ExpectedConditions.titleContains("Registration"));

		String title = driver.getTitle();
		System.out.println("Page Title " + title);

		// Assertion
		Assert.assertEquals(title, "Registration");
	}

	/*----------------------------Login--------------------------------------------------------------------------------*/

	@Given("user open url of banking application")
	public void user_open_url_of_banking_application() {
		System.out.println(getPageTitle());
	}

	@Given("user click on login button")
	public void user_click_on_login_button() {

		login.clickonLogin();

	}

	@Given("user enter username as {string}")
	public void user_enter_username_as(String userName) {

		login.enterUid(userName);

	}

	@Given("user enter password as {string}")
	public void user_enter_password_as(String Passwd) throws InterruptedException {

		// addHardcodedWait();
		login.enterPassword(Passwd);
	}

	@When("user click on submit button")
	public void user_click_on_submit_button() throws InterruptedException {
		login.clickOnSubmit();
		addHardcodedWait();
	}

	/*@Then("Validate that user able to login successfully")
	public void validate_that_user_able_to_login_successfully() {

		//addExplicitWait(By.xpath("//div[@class='js-successbox t-form__successboxt-text t-text_md']"));
		String msg = login.VerifyMessage();
		Assert.assertEquals(ActualMessage, msg);

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		 * 
		 * // xpath matching the element that contains the success message By
		 * SuccessMsgLocator =
		 * By.xpath("//div[@class='js-successbox t-form__successbox t-text t-text_md']"
		 * );
		 * 
		 * // Wait until success message appears and contains expected text
		 * wait.until(ExpectedConditions.textToBePresentInElementLocated(
		 * SuccessMsgLocator, "Thank you!"));
		 * 
		 * WebElement SuccessMsgElement = driver.findElement(SuccessMsgLocator); String
		 * actualMessage = SuccessMsgElement.getText();
		 * 
		 * System.out.println("Actual message: " + actualMessage);
		 * 
		 * // Assertion Assert.assertEquals(ActualMessage.trim(),
		 * "Thank you! Your data has been submitted.");
		 

	}*/

	/*@Then("also verify that the Title of the Login page is shown proper")
	public void also_verify_that_the_title_of_the_login_page_is_shown_proper() {

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		// By.xpath("//div[@class='js-successbox t-form__successbox t-text
		// t-text_md']");

		// Wait for title contain Login
		// wait.until(ExpectedConditions.titleContains("Login"));

		String actualaTitle = driver.getTitle();
		System.out.println("Page Title " + actualaTitle);

		// Assertion
		Assert.assertEquals(actualaTitle, ":Login");

	

	}*/

	/*
	 * _____________________________________Forget
	 * Password-___---------------------------------------------------
	 */

	/*
	 * @Given("user open url of banking application") public void
	 * user_open_url_of_banking_application1() { System.out.println(getPageTitle());
	 * }
	 */

	@Given("user click on forget password link")
	public void user_click_on_forget_password_link() {

		fp.forgetPasswordLink();

	}

	@Given("user enter email id as {string}")
	public void user_enter_email_id_as(String emailid) {

		fp.enterEmailId(emailid);

	}

	@Given("user enter mobile number as {string}")
	public void user_enter_mobile_number_as(String mobnum) {

		fp.enterMobileNumber(mobnum);

	}

	@When("user click on reset password button")
	public void user_click_on_reset_password_button() {

		fp.clickOnResetBtn();
	}

	@Then("validate the confirmation message for resetting password")
	public void validate_the_confirmation_message_for_resetting_password() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		// xpath matching the element that contains the success message
		By SuccessMsgLocator = By.xpath("//div[@class='js-successbox t-form__successbox t-text t-text_md']");

		// Wait until success message appears and contains expected text
		wait.until(ExpectedConditions.textToBePresentInElementLocated(SuccessMsgLocator, "Thank you!"));

		WebElement SuccessMsgElement = driver.findElement(SuccessMsgLocator);
		String actualMessage = SuccessMsgElement.getText();

		System.out.println("Actual message: " + actualMessage);

		// Assertion
		Assert.assertEquals(ActualMessage.trim(), "Thank you! Your data has been submitted.");

	}

	@Then("Also verify the title of the page showing proper")
	public void also_verify_the_title_of_the_page_showing_proper() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		//
		wait.until(ExpectedConditions.titleContains("Forget Password"));

		String actualTitle = driver.getTitle();
		System.out.println("Page title: " + actualTitle);

		// Assertion
		Assert.assertEquals(actualTitle, "Forget Password");
	}

	/*----------------------------------------------AmountDetails cucumber shells----------------------------------------*/

	/*
	 * @Given("User open the url of banking  application") public void
	 * user_open_the_url_of_banking_application() {
	 * 
	 * System.out.println("Application launched");
	 * //System.out.println(getPageTitle()); String title = getPageTitle();
	 * Assert.assertEquals(title, "Home");
	 * 
	 * 
	 * }
	 */


	@Given("user clicks on AccountDetail button in WebPage")
	public void user_clicks_on_account_detail_button_in_web_page() 
	{
		ADP.clickonAccountDetails();
	}

	@Given("user navigated to the AccountDetails Page")
	public void user_navigated_to_the_account_details_page()
	{
		getWindowHandle();
		System.out.println(getPageTitle());
	}




	@Given("Select Account  from DropDown")
	public void select_account_from_drop_down() throws InterruptedException, AWTException
	{
//		addExplicitWait(By.xpath("//div[@id='menuitem-0']"));
	ADP.selectAccount();
	}

	@Given("click on Login button")
	public void click_on_login_button() throws InterruptedException
	{
		ADP.Login();
	}

	@Given("click on Deposit")
	public void click_on_deposit() throws InterruptedException 
	{
		addHardcodedWait();
		ADP.clickonDepositTab();
	}

	@Given("enter the amount to be deposited as {string}")
	public void enter_the_amount_to_be_deposited_as(String depositAmount)
	{
		ADP.enterDepositAmount(depositAmount);
	}

	@When("click on Deposit button")
	public void click_on_deposit_button()
	{
		ADP.clickonDepositButton();
	}

	@Then("balance is updated")
	public void balance_is_updated() 
	{
		
	}

	@Then("click on withdrawl")
	public void click_on_withdrawl() throws InterruptedException 
	{
		addHardcodedWait();
		ADP.clickonWithdrawlTab();
	}

	@Then("enter amount to be withdrawn as {string}")
	public void enter_amount_to_be_withdrawn_as(String withdrawlAmount)
	{
		ADP.enterWithdrawAmount(withdrawlAmount);
	}

	@When("click on withdraw button")
	public void click_on_withdraw_button() 
	{
		ADP.clickonWithdrawlButton();
	}

	@Then("balance will be updated")
	public void balance_will_be_updated()
	{
		
	}
	

	/*-------------------------------------Contact Us Page------------------------------------------------*/

	@Given("user click on contact us link")
	public void user_click_on_contact_us_link() {

		CUP.ClickOnContactUs();

	}

	@Given("user enter first name in the name field as name {string}")
	public void user_enter_first_name_in_the_name_field_as_name(String name) {

		CUP.enterName(name);

	}

	@Given("user enter email in the email field as {string}")
	public void user_enter_email_in_the_email_field_as(String emailId) {

		CUP.enterEmail(emailId);

	}

	@Given("user enter phone number in phone number field as {string}")
	public void user_enter_phone_number_in_phone_number_field_as(String phoneNum) {

		CUP.enterPhoneNumber(phoneNum);
	}

	@Given("user enter address in the address field as {string}")
	public void user_enter_address_in_the_address_field_as(String address) {

		CUP.enterAddress(address);

	}

	@Given("user enetr the country in the country field  as {string}")
	public void user_enetr_the_country_in_the_country_field_as(String country) {

		CUP.enterCountry(country);
	}

	@Then("user enter pin code in the field of zipcode as {string}")
	public void user_enter_pin_code_in_the_field_of_zipcode_as(String pinCode) {

		CUP.enterZipCode(pinCode);
	}

	@When("User Click on submit button of Contact Us Page")
	public void user_click_on_submit_button_of_contact_us_page() {

		CUP.ClickOnSubmitBtn();

	}

	@Then("Validate that user get success message after clicking on button")
	public void validate_that_user_get_success_message_after_clicking_on_button() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		// xpath matching the element that contains the success message
		By SuccessMsgLocator = By.xpath("//div[@class='js-successbox t-form__successbox t-text t-text_md']");

		// Wait until success message appears and contains expected text
		wait.until(ExpectedConditions.textToBePresentInElementLocated(SuccessMsgLocator, "Thank you!"));

		WebElement SuccessMsgElement = driver.findElement(SuccessMsgLocator);
		String actualMessage = SuccessMsgElement.getText();

		System.out.println("Actual message: " + actualMessage);

		// Assertion
		Assert.assertEquals(ActualMessage.trim(), "Thank you! Your data has been submitted.");

	}

}
