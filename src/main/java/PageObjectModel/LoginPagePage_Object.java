package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPagePage_Object {

// LoginPagePage_Object class contains all xpath of WebElements of the page.
	
	
	WebDriver driver;
	
	//driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
	By userName= By.xpath("//input[@id='username']");
	By passWord= By.xpath("//input[@id='password']");
	By login=By.xpath("//input[@id='Login']");
	
	
	public LoginPagePage_Object(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver2;		//here we have given driver2 scope to driver this.driver=driver2 
	}

	// method for login userName only
	public WebElement enterUserName()
	{
		return driver.findElement(userName);
	}
	
	// method for login userName only
	public WebElement enterPassword()
	{
		return driver.findElement(passWord);
	}
	
	// method for login button
	public WebElement login()
	{
		return driver.findElement(login);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
