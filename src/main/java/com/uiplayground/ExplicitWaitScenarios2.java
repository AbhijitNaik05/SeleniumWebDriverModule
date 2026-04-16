package com.uiplayground;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitScenarios2 {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();
		wd.get("http://uiplayground.techwithjatin.com/");
		wd.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
		By expliciteWaitMenuLocator = By.xpath("//span[text()='Explicit Waits']/..");
		WebElement explicitWaitMenu = wait.until(ExpectedConditions.elementToBeClickable(expliciteWaitMenuLocator));
		explicitWaitMenu.click();
		// task 4
		By spinnerLocator = By.xpath("//div[@data-testid='wait-invisible-target']");
		WebElement spinner = wait.until(ExpectedConditions.visibilityOfElementLocated(spinnerLocator));
		System.out.println("Spinner is displayed" + spinner.isDisplayed());
		By taskfourtriggerButtonLocator = By.xpath("//button[@data-testid='btn-trigger-invisible']");
		WebElement taskfourtriggerButton = wait
				.until(ExpectedConditions.elementToBeClickable(taskfourtriggerButtonLocator));
		taskfourtriggerButton.click();
		boolean spinnerstatus = wait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerLocator));
		System.out.println(spinnerstatus);

		// task5
		By divtargetLocator = By.xpath("//div[@data-testid='wait-stale-target']");
		WebElement divTarget = wait.until(ExpectedConditions.visibilityOfElementLocated(divtargetLocator));
		System.out.println(divTarget.getAttribute("data-render-key"));
		By taskFiveTriggerbuttonLocator = By.xpath("//button[@data-testid='btn-trigger-stale']");
		WebElement taskFiveTriggerbutton = wait
				.until(ExpectedConditions.elementToBeClickable(taskFiveTriggerbuttonLocator));
		taskFiveTriggerbutton.click();
		boolean stalestatus = wait.until(ExpectedConditions.stalenessOf(divTarget));
		if (stalestatus) {
			WebElement divTargetNew = wait.until(ExpectedConditions.visibilityOfElementLocated(divtargetLocator));
			System.out.println(divTargetNew.getAttribute("data-render-key"));
		}

		// task 6
		By checkboxLocator = By.xpath("//input[@data-testid='wait-selected-target']");
		WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxLocator));
		System.out.println(checkbox.isSelected());
		By tasksixTriggerButtonLocator = By.xpath("//button[@data-testid='btn-trigger-selected']");
		WebElement tasksixTriggerButton = wait
				.until(ExpectedConditions.elementToBeClickable(tasksixTriggerButtonLocator));
		tasksixTriggerButton.click();
		boolean status = wait.until(ExpectedConditions.elementToBeSelected(checkboxLocator));
		System.out.println(status);
	}

}
