
package org.stepdefinition;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pageobject.JingleBidLogin;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JingleBid extends JingleBidLogin {
	
	
	
	@Given("launch the chrome browser")
	public void launch_the_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	
	}

	@When("Enter the URL")
	public void enter_the_URL() {
		loadUrl("https://qa.jinglebid.com/");
		windMax();
	}

	@When("Enter the valid username and valid password")
	public void Enter_the_valid_username_and_valid_password() {
		JingleBidLogin jb = new JingleBidLogin();
		btnclick(jb.getViewProfile());
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.elementToBeClickable(jb.getEmailLogin()));
		btnclick(jb.getEmailLogin());
		passValue(jb.getUsername(), "bharath4048@gmail.com");
		passValue(jb.getPassword(), "Bharath@123");
	    
	}

	@When("click login button")
	public void click_login_button() {
		JingleBidLogin jb = new JingleBidLogin();
	    btnclick(jb.getSignin());
	}

	


	
}