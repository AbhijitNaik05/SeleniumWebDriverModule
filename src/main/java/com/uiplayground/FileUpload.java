package com.uiplayground;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new ChromeDriver();
		wd.get("http://uiplayground.techwithjatin.com/");
		wd.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
		By fileuploadMenuLocator = By.xpath("//span[text()='File Upload']/..");
		WebElement fileuploadMenu = wait.until(ExpectedConditions.elementToBeClickable(fileuploadMenuLocator));
		fileuploadMenu.click();
		By fileInputLocator = By.xpath("//input[@data-testid='file-input']");
		WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(fileInputLocator));
		fileInput.sendKeys("C:\\Users\\LENOVO\\Desktop\\Demo.txt");
		By fileListLocator = By.xpath("//div[@data-testid='file-list']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(fileListLocator));
		fileInput.sendKeys("C:\\Users\\LENOVO\\Desktop\\puppy.jpg");

		By fileInfoLocator = By.xpath("//div[@data-testid='file-list']/div");
		List<WebElement> fileInfolist = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(fileInfoLocator, 1));
		System.out.println(fileInfolist.size());
		int uploaded=0;
		int rejected=0;
		for (WebElement fileinfo : fileInfolist) {
			WebElement fileName = fileinfo.findElement(By.xpath(".//span[@class='file-name']"));
			WebElement fileSize = fileinfo.findElement(By.xpath(".//span[@class='file-size']"));
			WebElement fileStatus = fileinfo.findElement(By.xpath(".//span[@class='file-status']"));
			String status = fileStatus.getText();
			if(status.equalsIgnoreCase("uploaded")) {
				uploaded++;
			}
			else if (status.equalsIgnoreCase("rejected")) {
				rejected++;
			}
			System.out.print(fileName.getText()+" ");
			System.out.print(fileSize.getText()+" ");
			System.out.print(fileStatus.getText());
			System.out.println();
		}
		System.out.println("Uploaded "+uploaded);
		System.out.println("Rejected "+rejected);
	}

}
