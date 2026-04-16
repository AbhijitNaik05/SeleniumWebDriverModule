package com.uiplayground;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitScenarios {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();
		wd.get("http://uiplayground.techwithjatin.com/");
		wd.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
		By expliciteWaitMenuLocator = By.xpath("//span[text()='Explicit Waits']/..");
		WebElement explicitWaitMenu = wait.until(ExpectedConditions.elementToBeClickable(expliciteWaitMenuLocator));
		explicitWaitMenu.click();
		long startTime = System.currentTimeMillis();
		By task1triggerButtonLoactor = By.xpath("//button[@data-testid='btn-trigger-visible']");
		WebElement task1triggerButton = wait.until(ExpectedConditions.elementToBeClickable(task1triggerButtonLoactor));
		task1triggerButton.click();
		By task1VisibleTextLocator = By.xpath("//div[@data-testid='wait-visibility-target']");
		WebElement task1VisibleText = wait
				.until(ExpectedConditions.visibilityOfElementLocated(task1VisibleTextLocator));
		System.out.println(task1VisibleText.getText());
		long endTime = System.currentTimeMillis();
		System.out.println("Duration " + (endTime - startTime) / 1000);

		// task2
		By task2disabledButtonLocator = By.xpath("//button[@data-testid='wait-clickable-target']");
		WebElement task2disabledButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(task2disabledButtonLocator));
		String status = task2disabledButton.getAttribute("disabled");
		System.out.println(status);
		By task2triggerbuttonLocator = By.xpath("//button[@data-testid='btn-trigger-clickable']");
		WebElement task2triggerbutton = wait.until(ExpectedConditions.elementToBeClickable(task2triggerbuttonLocator));
		task2triggerbutton.click();
		By nowClickableButtonLoactor = By.xpath("//button[@data-testid='wait-clickable-target']");
		WebElement nowClickableButton = wait.until(ExpectedConditions.elementToBeClickable(nowClickableButtonLoactor));
		status = nowClickableButton.getAttribute("disabled");
		nowClickableButton.click();
		System.out.println(status);

		// task 3
		By divTextBoxLocator = By.xpath("//div[@data-testid='wait-text-target']");
		WebElement divTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(divTextBoxLocator));
		System.out.println(divTextBox.getText());
		By triggerButtonLocator = By.xpath("//button[@data-testid='btn-trigger-text']");
		WebElement triggerButton = wait.until(ExpectedConditions.elementToBeClickable(triggerButtonLocator));
		triggerButton.click();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(divTextBoxLocator, "Text has been injected into this element!"));
		System.out.println(divTextBox.getText());
	}

}
