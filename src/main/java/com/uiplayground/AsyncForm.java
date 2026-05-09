package com.uiplayground;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AsyncForm {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();
		wd.get("http://uiplayground.techwithjatin.com/");
		wd.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(20));
		By asyncformmenuLocator = By.xpath("//span[text()='Async Form']/..");
		WebElement asyncformmenu = wait.until(ExpectedConditions.elementToBeClickable(asyncformmenuLocator));
		asyncformmenu.click();
		By fullnameLocator = By.xpath("//input[@data-testid='input-name']");
		WebElement fullname = wait.until(ExpectedConditions.visibilityOfElementLocated(fullnameLocator));
		fullname.sendKeys("Anika");
		By emailLocator = By.xpath("//input[@data-testid='input-email']");
		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(emailLocator));
		email.sendKeys("Anika@gmail.com");
		By dropdownLocator = By.xpath("//select[@data-testid='select-role']");
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownLocator));
		Select select = new Select(dropdown);
		select.selectByVisibleText("SDET");
		By submitButtonLocator = By.xpath("//button[@data-testid='btn-submit-form']");
		WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
		submitButton.click();
		By formStateLocator = By.xpath("//span[@data-testid='form-state']");
		wait.until(ExpectedConditions.textToBePresentInElementLocated(formStateLocator, "validating"));
		System.out.println(wd.findElement(formStateLocator).getText());
		wait.until(ExpectedConditions.textToBePresentInElementLocated(formStateLocator, "submitting"));
		System.out.println(wd.findElement(formStateLocator).getText());
		By successLocator = By.xpath("//div[@data-testid='form-success']");
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(successLocator),
				ExpectedConditions.textToBePresentInElementLocated(formStateLocator, "error")));
		boolean status = !wd.findElements(successLocator).isEmpty();
		if (status) {
			String message = wait.until(ExpectedConditions.visibilityOfElementLocated(successLocator)).getText();
			System.out.println(message);
		}
		else {
			By errorMessageLocator = By.xpath("//div[@data-testid='form-error']");
			System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator)).getText());
			System.out.println(wd.findElement(formStateLocator).getText());
		}

	}
}
