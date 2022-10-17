package testng.parallel;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Phase5Project {

	public static void main(String[] args) throws InterruptedException {
		
		//setting chrome driver
		System.setProperty("webdriver.chrome.driver", "D:\\Mphasis\\Phase5\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		//capture time before page load
	     long s = System.currentTimeMillis();
		
	     //launch website
		 driver.get("https://www.flipkart.com/");
		 driver.manage().window().maximize();
		 System.out.println("Website open!!");
		
	      //capture time after page load
	     long e = System.currentTimeMillis();
	      
	      //compute time
	     long r = e-s;
	     System.out.println("Page load time in milliseconds: " + r);
		 System.out.println("=====================================");
		 Thread.sleep(2000);
		 
		 //website operations
		 driver.findElement(By.className("_3704LK")).sendKeys("iPhone 13");
		 driver.findElement(By.cssSelector("#container > div > div._1kfTjk > div._1rH5Jn > div._2Xfa2_ > div._1cmsER > form > div > button > svg")).click();
		 Thread.sleep(3000);
		 
		 Thread.sleep(3000);
		 
		 driver.findElement(By.partialLinkText("APPLE iPhone 13 (Midnight, 128 GB)")).click();
		 System.out.println("Mobile selected!!");
		 System.out.println("======================");
		 Thread.sleep(6000);
		 
		 //checking for scrollbar
		 String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 Boolean test = (Boolean) (js.executeScript(execScript));
			if (test == true) {
				System.out.println("Scrollbar is present.");
				System.out.println("======================");
			} else if (test == false){
				System.out.println("Scrollbar is not present.");
				System.out.println("======================");
			} 
			
		 //Refresh 	
		 driver.navigate().refresh();
		 System.out.println("Refresh done!!");
		 System.out.println("======================");
		 Thread.sleep(3000);
		 
		 //applying wait
		 driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		 System.out.println("wait check!!");
		 System.out.println("======================");
			
		 //Scroll down 
		 Set<String> Handles = driver.getWindowHandles();
		    
		 for(String actual: Handles)
		 {
		    	driver.switchTo().window(actual);
		 }
		 
		 
		    
		 //scrolling down
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 
		 System.out.println("Scroll down done!!");
		 System.out.println("======================");
		 Thread.sleep(6000);
		 
		 	 
		 //scrolling up
		 js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		 System.out.println("Scroll up done!!");
		 System.out.println("======================");
		 Thread.sleep(6000);
		 
		 
		 driver.quit();

	}

}
