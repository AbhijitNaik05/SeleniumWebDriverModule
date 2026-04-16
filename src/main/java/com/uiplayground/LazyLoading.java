package com.uiplayground;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LazyLoading {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();
		wd.get("http://uiplayground.techwithjatin.com/");
		wd.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(20));
		By lazyLoadMenuLocator = By.xpath("//span[text()='Lazy Load Images']/..");
		WebElement lazyLoadMenu = wait.until(ExpectedConditions.elementToBeClickable(lazyLoadMenuLocator));
		lazyLoadMenu.click();
		By lazyCountLocator = By.xpath("//div[@data-testid='lazy-count']");
		String lazyCount = wait.until(ExpectedConditions.visibilityOfElementLocated(lazyCountLocator)).getText();
		System.out.println(lazyCount);
		By lazyimagesLocator = By.xpath("//div[starts-with(@data-testid,'img-placeholder-')]");
		List<WebElement> imageplaceholderlist = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lazyimagesLocator));
		System.out.println(imageplaceholderlist.size());
		// task 2
		JavascriptExecutor js = (JavascriptExecutor) wd;
		for (int i = 0; i <= 11; i++) {
			By containerLocator = By.xpath("//div[@data-testid='img-container-" + i + "']");
			WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(containerLocator));
			js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'})", container);
			By placeholderlocator = By.xpath("//div[@data-testid='img-placeholder-\"+i+\"']");
			boolean status = wait.until(ExpectedConditions.invisibilityOfElementLocated(placeholderlocator));
			System.out.println("placeholder is invisible " + i + " " + status);
			By imagelocator = By.xpath("//img[@data-testid='img-" + i + "']");
			WebElement image = wait.until(ExpectedConditions.visibilityOfElementLocated(imagelocator));
			System.out.println("Image is displayed " + image.isDisplayed());
			System.out.println(image.getAttribute("data-testid"));
			System.out.println(image.getAttribute("alt"));
			WebElement captionElement = container.findElement(By.xpath(".//div[@class='img-caption']"));
			System.out.println("Caption " + captionElement.getText());
			System.out.println("Image loaded class " + image.getAttribute("class"));
			lazyCount = wait.until(ExpectedConditions.visibilityOfElementLocated(lazyCountLocator)).getText();
			System.out.println(lazyCount);
			System.out.println("--------------------------------------");

		}

		// task 4
		By imageloadedlocator = By.cssSelector("img.img-loaded");
		List<WebElement> imageloadedlist = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(imageloadedlocator));
		System.out.println(imageloadedlist.size());
		System.out.println(wd.findElements(lazyimagesLocator).size());

	}

}
