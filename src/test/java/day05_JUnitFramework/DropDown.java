package day05_JUnitFramework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class DropDown {

    @Test
    public void DropDownTest() throws InterruptedException {

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://zero.webappsecurity.com/");
        WebElement signButon= driver.findElement(By.id("signin_button"));
        signButon.click();

        driver.findElement(By.name("user_login")).sendKeys("username");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        Thread.sleep(5000);
        WebElement signButtonOnay=driver.findElement(By.name("submit"));
        signButtonOnay.click();
        driver.navigate().back();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//a[@id='online-banking']")).click();
        driver.findElement(By.xpath("//span[@id='account_summary_link']")).click();

        driver.findElement(By.xpath("//*[@id='pay_bills_tab']")).click();

        //driver.findElement(By.xpath("//*[@class='ui-state-default ui-corner-top ui-tabs-selected ui-state-active']")).click();

        driver.findElement(By.partialLinkText("Purchase Foreign Currency")).click();
        Thread.sleep(5000);

    }
}
