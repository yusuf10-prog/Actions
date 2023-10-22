package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {
    @Test
    public void test01(){
      //2- https://html.com/tags/iframe/ sayfasina gidin

        driver.get("https://html.com/tags/iframe/ ");

      //3- video'yu gorecek kadar asagıya inin

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);



      //4- videoyu izlemek icin play tusuna basin

        WebElement iframe=driver.findElement(By.xpath("//div[@class='render']//iframe"));
        driver.switchTo().frame(iframe);
        bekle(1);

        WebElement playTusu=driver.findElement(By.xpath("//button[@title='Oynat']"));
        playTusu.click();

        bekle(3);


      //5- videoyu calistirdiginizi test edin

        WebElement youtubeLogosu=driver.findElement(By.xpath("//div[@aria-label='YouTube Video Oynatıcısı']"));
        Assert.assertTrue(youtubeLogosu.isDisplayed());
    }
}
