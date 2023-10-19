package day07_assertions_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Driver;
import java.time.Duration;

public class C01_Assertions {
    static WebDriver driver;

    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");

    }

    @AfterClass
    public static void teardown(){

       // Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin

    }
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
    // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    // ○ logoTest => BestBuy logosunun görüntülendigini test edin
    // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    @Test
    public void urlTest(){
        //Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin

        String expectedUrl="https://www.bestbuy.com/";
        String actuarlUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actuarlUrl);


    }
    @Test
    public void titleTesti(){

        // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String unexpectedIcerik="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(unexpectedIcerik));

    }
    @Test
    public void logoTesti(){
        // ○ logoTest => BestBuy logosunun görüntülendigini test edin

        WebElement logoElement= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

        Assert.assertTrue(logoElement.isDisplayed());

    }
    @Test
    public void francaisTesti(){

        // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francaisLinkElementi= driver.findElement(By.xpath("//*[text()='Français']"));

        Assert.assertTrue(francaisLinkElementi.isDisplayed());
    }

}
