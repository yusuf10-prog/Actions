package day06_notations_assertions;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.sql.Driver;
import java.time.Duration;

public class C01_BeforeAfterNotasyonlari {
    // 3 test method'u olusturup asagidaki gorevleri
    // bagimsiz olarak calisabilecek sekilde olusturun.
    // 1- Amazon anasayfaya gidip, url'in amazon icerdigini test edin, sayfayi kapatin
    // 2- WisaQuarter anasayfaya gidip, title'in Wise icerdigini test edin, sayfayi kapatin
    // 3- Youtube anasayfaya gidip, title'in "best" icermedigini test edin, sayfayi kapatin

    WebDriver driver;
    public void setup(){

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void amazonTest(){
      //  1-  Amazon anasayfaya gidip, url'in amazon icerdigini test edin, sayfayi kapatin
        setup();

        driver.get("https://www.amazon.com");

        String expectudIcerik="amazon";
        String acturalUrl=driver.getCurrentUrl();

        if (acturalUrl.contains(expectudIcerik)){
            System.out.println("Amazon testi PASSED");
        }else {
            System.out.println("Amazon testi FAILED");
        }

        ReusableMethods.bekle(2);
        driver.close();

    }

    @Test
    public void wiseTesti(){
        // 2- WisaQuarter anasayfaya gidip, title'in Wise icerdigini test edin, sayfayi kapatin
        setup();

        driver.get("https://www.wisequarter.com");
        String expectedTitleIcerik="Wise";
        String actualTitle= driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Wisequarter testi PASSED");
        }else {
            System.out.println("Wisequarter testi FAILED");
        }

        driver.close();
    }

    @Test
    public void youtubeTesti(){
        setup();
        // 3- Youtube anasayfaya gidip, title'in "best" icermedigini test edin, sayfayi kapatin


        driver.get("https://www.youtube.com");
        String unexceptedIcerik="best";
        String actualTitle= driver.getTitle();

        if (actualTitle.contains(unexceptedIcerik)){
            System.out.println("Youtube Testi FAILED");

            // best içeriyorsa test faıled olmalı
        }else {
            System.out.println("Youtube Testi PASSED");
        }

        driver.close();

    }

}
