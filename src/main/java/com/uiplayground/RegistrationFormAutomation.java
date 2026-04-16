package com.uiplayground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationFormAutomation {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();
		wd.get("http://uiplayground.techwithjatin.com/");
		wd.manage().window().maximize();

		By firstnameTextboxLocator = By.xpath("//input[@data-testid='input-first-name']");
		WebElement firstNameTextbox = wd.findElement(firstnameTextboxLocator);
		firstNameTextbox.sendKeys("Anika");
		By lastnameTextboxLocator = By.xpath("//input[@data-testid='input-last-name']");
		WebElement lastNameTextbox = wd.findElement(lastnameTextboxLocator);
		lastNameTextbox.sendKeys("Naik");
		By emailTextboxLocator = By.xpath("//input[@data-testid='input-email-reg']");
		WebElement emailTextbox = wd.findElement(emailTextboxLocator);
		emailTextbox.sendKeys("anika@gmail.com");
		By passwordTextboxLocator = By.xpath("//input[@data-testid='input-password']");
		WebElement passwordTextbox = wd.findElement(passwordTextboxLocator);
		passwordTextbox.sendKeys("anika@gmail.com");
		By phoneTextboxLocator = By.xpath("//input[@data-testid='input-phone']");
		WebElement phoneTextbox = wd.findElement(phoneTextboxLocator);
		phoneTextbox.sendKeys("9999999999");
		By femaleradioButtonLocator = By.xpath("//input[@value='Female']");
		WebElement femaleradioButton = wd.findElement(femaleradioButtonLocator);
		femaleradioButton.click();
		By termsAndConditionsCheckboxLocator = By.xpath("//input[@type='checkbox']");
		WebElement termsAndConditionsCheckbox = wd.findElement(termsAndConditionsCheckboxLocator);
		termsAndConditionsCheckbox.click();
		By calendertextboxLocator = By.xpath("//input[@type='date']");
		WebElement calendertextbox = wd.findElement(calendertextboxLocator);
		calendertextbox.sendKeys("28");
		calendertextbox.sendKeys("03");
		calendertextbox.sendKeys("2019");
		By countrySelectdropdownLocator = By.xpath("//select[@data-testid='input-country']");
		WebElement countrySelectdropdown = wd.findElement(countrySelectdropdownLocator);
		Select select = new Select(countrySelectdropdown);
		select.selectByContainsVisibleText("Sing");
		By registerButtonLocator = By.tagName("button");
		WebElement registerButton = wd.findElement(registerButtonLocator);
		registerButton.click();
		By registrationMessageLocator = By.xpath("//div[@data-testid='registration-success']/div[2]");
		WebElement registrationMessage = wd.findElement(registrationMessageLocator);
		System.out.println(registrationMessage.getText());
		By successNameLocator = By.xpath("//strong[@data-testid='success-name']");
		WebElement successName = wd.findElement(successNameLocator);
		System.out.println(successName.getText());
		
		
	}

}
