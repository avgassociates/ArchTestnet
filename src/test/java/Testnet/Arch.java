package Testnet;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.auto.common.Visibility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Arch {

	public static void main(String[] args)  {
	
		
		EdgeOptions options = new EdgeOptions();
		File extensionFile = new File("C:\\Users\\assoc\\eclipse-workspace\\ArchTestnet\\crx\\PPBIBELPCJMHBDIHAKFLKDCOCCBGBKPO_1_5_2_0.crx");
		 options.addExtensions(extensionFile);
		 options.addArguments("start-maximized");
		 
        
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver(options);
      String parent = driver.getWindowHandle();
        Set<String> child = driver.getWindowHandles();
        for (String x : child) {
			if(!parent.equals(x)) {
				driver.switchTo().window(x);
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				
			}
			
		}
        
        driver.findElement(By.xpath("(//*[@class='row-container']//following::div)[6]")).click();
	}

}

