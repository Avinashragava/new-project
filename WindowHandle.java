package task;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.snapdeal.com/");
		WebElement search = driver.findElement(By.id("inputValEnter"));
		search.sendKeys("iphone7",Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//p[@class='product-title'])[1]")).click();
		//parent window id
		String parid = driver.getWindowHandle();
		System.out.println("parid-"+parid);
		
		//all windows id
		Set<String> windowHandles = driver.getWindowHandles();
		for (String allid : windowHandles) {
			System.out.println("all windows id"+allid);
			
		}
		List<String> li=new LinkedList<String>();
		li.addAll(windowHandles);
		driver.switchTo().window(li.get(1));
		System.out.println("switched to window");
	}

}
