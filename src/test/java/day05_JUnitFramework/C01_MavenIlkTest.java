package day05_JUnitFramework;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import utilities.ReusableMethods;

import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {

        /*
            13.satiri yazmamiz mecburi degildir.
            Selenium 4.8 versiyonundan itibaren kendi Webdriver'ini olusturmustur.
            biz 13.satirdaki gibi disardan bir WebDriver tanimlamazsak
            Selenium otomatik olarak kendi WebDriver'ini devreye sokar.

         */
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://www.amazon.com");
        ReusableMethods.bekle(5);
        //2- arama kutusunu locate edelim

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);

        //4- Bulunan sonuc sayisini yazdiralim  (//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]

        WebElement sonucYaziElementi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYaziElementi.getText());


        //5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();


        //6- Bir önceki sayfaya dönüp Sayfadaki tum basliklari yazdiralim

        driver.navigate().back();

        List<WebElement> baslikElementleri=driver.findElements(By.xpath("//a[@class='a-link-normal s-navigation-item']"));

        for (int i = 0; i < baslikElementleri.size(); i++) {
            System.out.println(i + "-" +baslikElementleri.get(i).getText());

        }

        ReusableMethods.bekle(5);

        driver.close();
    }
}
