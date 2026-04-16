package com.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhoenixLoginAutomation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new ChromeDriver();
		wd.get("http://phoenix.techwithjatin.com/sign-in");
		Thread.sleep(5000);
		By usernameTextboxLocator = By.id("username");
		WebElement userNameTextBox = wd.findElement(usernameTextboxLocator);
		userNameTextBox.clear();
		userNameTextBox.sendKeys("iamsup");
		By passwordTextboxLocator =By.id("password");
		WebElement passwordTextBox =	wd.findElement(passwordTextboxLocator);
		passwordTextBox.clear();
		passwordTextBox.sendKeys("password");
		By signinButtonLocator = By.xpath("//span[contains(text(), 'Sign in')]/../..");
		WebElement signInButton=wd.findElement(signinButtonLocator);
		signInButton.click();
	}

}
