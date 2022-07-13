package MyTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectModel.LoginPagePage_Object;
 
import resource.BaseClass;
import resource.Constants;

public class VerifyLoginPage extends BaseClass  {

	//public WebDriver driver;
	
	
	@Test(dataProvider="testData")
	public void loginVerification(String username, String password) throws IOException, InterruptedException
	{
		// this driver has scope .driver has declared in BaseClass
		// this code open the Browser
		//driver = driverInitialization(); 
	// driverInitialization(); //this also works
		
		//url hit here
		//driver.get("https://login.salesforce.com/");
		
		System.out.println(driver.getCurrentUrl());	//optional line , i wrote
		
		LoginPagePage_Object lpObject= new LoginPagePage_Object(driver);// we have created object directly.
	
		System.out.println("driver data--->"+driver);//optional line , i wrote for checking driver data
		
		 lpObject.enterUserName().sendKeys(username);		// we are calling here methods of the LoginPagePage_Object class.
		 lpObject.enterPassword().sendKeys(password);
		 lpObject.login().click();
		 
		Thread.sleep(4000);
		 String actualString= driver.findElement(By.xpath("//div[@id='error']")).getText();
		 String expectedText="Pleas check your username and password. If you still can't log in, contact your Salesforce administrator.";
		
		 Assert.assertEquals(actualString,expectedText);
		 
		 
	}
	
	@DataProvider
	public Object[][] testData()
	{
		Object[][] data=new Object[2][2];
		// here we are passing data from Constants class.accessing values from class
		data[0][0]=Constants.userName1;
		data[0][1]=Constants.passWord1;
		data[1][0]=Constants.userName2;
		data[1][1]=Constants.passWord2;
		
		/*
		 // here we have provided data directly
		 * data[0][0]="testuser1";
		data[0][1]="pass123";
		data[1][0]="testuser2";
		data[1][1]="pass456";	
			
		*/
		return data;
		}
	
	 
} 


