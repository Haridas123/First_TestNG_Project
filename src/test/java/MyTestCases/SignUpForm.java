package MyTestCases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import PageObjectModel.SignUpPage_Object;
import resource.BaseClass;
import resource.Constants;

public class SignUpForm extends BaseClass{

	@Test
	public void signUp() throws IOException, InterruptedException
	{
		//this line open the Browser
		driverInitialization();
		//url hit here
		driver.get("https://login.salesforce.com/");
		
		SignUpPage_Object sign_Object= new SignUpPage_Object(driver);
		
		sign_Object.ClickSignUpButton().click();
		
		Thread.sleep(7000);				// if we remove this line we will face Error like "unable to locate element".let the page load entirely
		sign_Object.firstUserName().sendKeys(Constants.firstName);
		sign_Object.lastUserName().sendKeys(Constants.lastName);
		sign_Object.userEmailId().sendKeys(Constants.userEmail);
		sign_Object.userPhoneNo().sendKeys(Constants.userPhone);// here we are Accessing data from Constants class
		sign_Object.userCompanyName().clear();
		sign_Object.userCompanyName().sendKeys(Constants.company);

		//sign_Object.userCompanyName().sendKeys("google");// here we are passing data directly
		
		
		//No error in code .website fault.jobTitle is not getting select 
		   // static dropDown 
		 Thread.sleep(5000);
		  Select s = new Select(sign_Object.selectJobTitle());
	      s.selectByIndex(3);
	      //s.selectByValue("IT Manager");
		

		
		 
	 
	    // static dropDown .
		 Select s2= new Select(sign_Object.companyEmployee());
		 s2.selectByIndex(2);
		 Thread.sleep(5000);
		 // static dropDown 
		 Select country = new  Select(sign_Object.country());
		 
		 //country.selectByValue("Iceland");
		 country.selectByIndex(4);
		
	}
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		SignUpForm object= new SignUpForm();
		object.signUp();

	}

}
