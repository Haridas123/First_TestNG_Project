package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage_Object {
	
	
	WebDriver driver;
	
	By signUp = By.xpath("//a[@id='signup_link']");
	By firstUserName = By.xpath("//input[@name='UserFirstName']");
	By lastUserName = By.xpath("//input[@name='UserLastName']");
	By userEmailId = By.xpath("//input[@name='UserEmail']");
	By companyName = By.xpath("//input[@name='CompanyName']");
	By userPhone = By.xpath("//input[@name='UserPhone']");
    By employee = By.xpath("//select[@name='CompanyEmployees']");
	By country = By.xpath("//select[@name='CompanyCountry']");
	By aggrement = By.xpath("//input[@id='SubscriptionAgreement']");
	
	By jobTitle = By.xpath("(//select[@name='UserTitle']");
	

	public SignUpPage_Object(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}


	public WebElement ClickSignUpButton()
	{
		 
		return driver.findElement(signUp);
	}
	
	public WebElement firstUserName()
	{
		return driver.findElement(firstUserName);
	}
	
	public WebElement lastUserName()
	{
		return driver.findElement(lastUserName);
	}
	
	public WebElement userEmailId()
	{
		return driver.findElement(userEmailId);
	}
	
	public WebElement userCompanyName()
	{
		return driver.findElement(companyName);
	}
	
	public WebElement userPhoneNo()
	{
		return driver.findElement(userPhone);
	}
	 public WebElement selectJobTitle()
	 {
		 return driver.findElement(jobTitle);
	 }
	 
	 public WebElement companyEmployee()
	 {
		 return driver.findElement(employee);
	 }
	 
	 public WebElement country()
	 {
		 return driver.findElement(country);
	 }
	 
	 public WebElement aggrement()
	 {
		 return driver.findElement(aggrement);
	 }
}
