package day05_JUnitFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RelativeXpath {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.amazon.com.tr/");

        ///driver.findElement(By.xpath("//input"));

        //driver.findElement(By.xpath("//*[@type='text']"));

        driver.findElement(By.xpath("//input[@type]"));
        driver.quit();
    }
}
