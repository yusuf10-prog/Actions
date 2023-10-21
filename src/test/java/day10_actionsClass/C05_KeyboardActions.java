package day10_actionsClass;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {

    @Test
    public void test01(){
        //1- https://www.facebook.com adresine gidelim

        driver.get("https://www.facebook.com");

        //2- Cookies kabul edin (bende çıkmıyor)
        //3- Yeni hesap olustur butonuna basalim

        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isimKutusu= driver.findElement(By.name("firstname"));

        Actions actions=new Actions(driver);
        Faker faker=new Faker();

        String email=faker.internet().emailAddress();
        actions.click(isimKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("5")
                .sendKeys(Keys.TAB)
                .sendKeys("Oct")
                .sendKeys(Keys.TAB)
                .sendKeys("2001")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();

        //5- Kaydol tusuna basalim

        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

        bekle(10);

    }
}
