package com.uiplayground;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DateTimePicker {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();
		wd.get("http://uiplayground.techwithjatin.com/");
		wd.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
		By datepickerMenuLocator = By.xpath("//span[text()='Date Picker']/..");
		WebElement datepickerMenu = wait.until(ExpectedConditions.elementToBeClickable(datepickerMenuLocator));
		datepickerMenu.click();
		By singleDateLocator = By.xpath("//input[@data-testid='date-single']");
		WebElement singleDate = wait.until(ExpectedConditions.visibilityOfElementLocated(singleDateLocator));
		singleDate.sendKeys("10-04-2026");
		By selectedDateLocator = By.xpath("//div[@data-testid='date-selected']");
		WebElement selectedDate = wait.until(ExpectedConditions.visibilityOfElementLocated(selectedDateLocator));
		System.out.println(selectedDate.getText());
		By fromDateLocator =By.xpath("//input[@data-testid='date-from']");
		WebElement fromDate = wait.until(ExpectedConditions.visibilityOfElementLocated(fromDateLocator));
		fromDate.sendKeys("01-04-2026");
		By toDateLocator =By.xpath("//input[@data-testid='date-to']");
		WebElement toDate = wait.until(ExpectedConditions.visibilityOfElementLocated(toDateLocator));
		toDate.sendKeys("11-04-2026");
		By dateRangeLocator = By.xpath("//div[@data-testid='range-result']");
		WebElement dateRange = wait.until(ExpectedConditions.visibilityOfElementLocated(dateRangeLocator));
		System.out.println(dateRange.getText());
		By timePickerLocator = By.xpath("//input[@data-testid='time-picker']");
		WebElement timePicker = wait.until(ExpectedConditions.visibilityOfElementLocated(timePickerLocator));
		timePicker.sendKeys("11:30");
		By selectedTimeLocator = By.xpath("//div[@data-testid='range-result']");
		WebElement selectedTime = wait.until(ExpectedConditions.visibilityOfElementLocated(selectedTimeLocator));
		System.out.println(selectedTime.getText());
		By disableDateLocator = By.xpath("//div[@class='disabled-dates']/span[4]");
		WebElement disableDate = wait.until(ExpectedConditions.visibilityOfElementLocated(disableDateLocator));
		System.out.println(disableDate.getText());
		
	}

}
