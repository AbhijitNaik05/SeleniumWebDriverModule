package com.uiplayground;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DyanamicElementsAutomation_ExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new ChromeDriver();
		wd.get("http://uiplayground.techwithjatin.com/");
		wd.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(20));

		By dynamicElementMenuLinkLocator = By.xpath("//span[text()='Dynamic Elements']/..");
		// WebElement dynamicElementMenuLink =
		// wd.findElement(dynamicElementMenuLinkLocator);
		WebElement dynamicElementMenuLink = wait
				.until(ExpectedConditions.elementToBeClickable(dynamicElementMenuLinkLocator));
		dynamicElementMenuLink.click();
		By addMenuItemButtonLocator = By.xpath("//button[@data-testid='btn-add-item']");
		// WebElement addMenuItemButton = wd.findElement(addMenuItemButtonLocator);
		WebElement addMenuItemButton = wait.until(ExpectedConditions.elementToBeClickable(addMenuItemButtonLocator));
		addMenuItemButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(addMenuItemButtonLocator)).click();
		wait.until(ExpectedConditions.elementToBeClickable(addMenuItemButtonLocator)).click();
		By swiggyCardLocator = By.xpath("//div[@class='swiggy-card']");
		wait.until(ExpectedConditions.numberOfElementsToBe(swiggyCardLocator, 3));
		List<WebElement> foodItemList = wd.findElements(swiggyCardLocator);
		for (WebElement foodItem : foodItemList) {
			By foodItemNameLocator = By.xpath(".//div[@class='swiggy-name']");
			By foodItemPriceLocator = By.xpath(".//span[@class='swiggy-price']");
			WebElement foodItemName = foodItem.findElement(foodItemNameLocator);
			WebElement foodItemPrice = foodItem.findElement(foodItemPriceLocator);
			System.out.println(foodItemName.getText());
			System.out.println(foodItemPrice.getText());
		}

		By livecounterLocator = By.className("counter-badge");
		WebElement liveCounter = wait.until(ExpectedConditions.visibilityOfElementLocated(livecounterLocator));
		System.out.println(liveCounter.getText());
		By toggleVisiblityButtonLocator = By.xpath("//button[@data-testid='btn-toggle-visibility']");
		WebElement toggleVisiblityButton = wait.until(ExpectedConditions.elementToBeClickable(toggleVisiblityButtonLocator));
		toggleVisiblityButton.click();
		By visiblityTextLoactor = By.xpath("//span[@data-testid='visibility-state']");
		WebElement visiblityText =  wait.until(ExpectedConditions.visibilityOfElementLocated(visiblityTextLoactor));
		System.out.println("Menu Visiblity state " + visiblityText.getText());

	}

}
