/**
 * 
 */
package com.JSON.demotest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * @author venkateshwara.d
 *
 */
public class PaginationInSelenium {
	public static String path = System.getProperty("user.dir");
	public static WebDriver driver;
	
	public static void HighlightMyElement(WebElement element) throws InterruptedException {
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
				"color: yellow; border: 4px solid yellow;");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
	}
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hackerrank.com/leaderboard");
		Thread.sleep(1000);
			int i=1;
		do
		{
			Thread.sleep(3000);
			i++;
						
			if(driver.findElements(By.xpath("//p[@class='emptyState_container blank-reason mlA text-center']")).size()==1)
			{
				System.out.println("There are records available upto page"+i+"");
				break;
			}
			else
			{
				int row = driver.findElements(By.xpath(".//*[@id='content']/div/div[3]/div/div[4]/div/div/div[2]/section/div[1]/div/div[1]/div/div")).size();
				System.out.println("rows in each page "+row);
				for(int r =1;r<=row;r++) {
		
				HighlightMyElement(driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div["+r+"]/div[3]")));	
				String values = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div["+r+"]/div[3]")).getText().trim();
				
				HighlightMyElement(driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div["+r+"]/div[4]/img[1]")));	
				String flagname = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div["+r+"]/div[4]/img[1]")).getAttribute("data-tip");
				
				String output = String.format("Flag Name is: %1$s and its points %2$s", flagname, values);
		 
		        System.out.println(output);
				}
			}
			HighlightMyElement(driver.findElement(By.xpath("//a[@class='next-page-link']")));
			driver.findElement(By.xpath("//a[@class='next-page-link']")).click();
			
		}while(driver.findElements(By.cssSelector(".next-page")).size()!=0);	
	
		driver.close();
	}
}
