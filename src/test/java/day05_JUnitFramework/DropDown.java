package day05_JUnitFramework;

import com.sun.nio.sctp.SendFailedNotification;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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


        driver.findElement(By.partialLinkText("Purchase Foreign Currency")).click();
        WebElement selectButton= driver.findElement(By.xpath("//select[@id='pc_currency']"));
        selectButton.click();

        Select select=new Select(selectButton);
        select.selectByVisibleText("Eurozone (euro)");
        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("23");
        driver.findElement(By.xpath("(//input[@name='inDollars'])[2]")).click();

        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("//input[@value='Purchase']")).click();



        String actual="Foreign currency cash was successfully purchased.";
        WebElement expected=driver.findElement(By.xpath("//div[@id='alert_content']"));
        String gelen=expected.getText();

        Assert.assertEquals(actual,gelen);

        Thread.sleep(5000);

    }
}
