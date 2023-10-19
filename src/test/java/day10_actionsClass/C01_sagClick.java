package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class C01_sagClick extends TestBase {

    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        bekle(2);

        //3- Cizili alan uzerinde sag click yapin

        WebElement ciziliAlanElementi= driver.findElement(By.id("hot-spot"));

        bekle(2);

        Actions actions=new Actions(driver);
        actions.contextClick(ciziliAlanElementi).perform();

        //4- Alert'te cikan yazinin "You selected a context menu" oldugunu test edin.

        String expectedAlertYazi="You selected a context menu";
        String actualAlertYazisi=driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazi,actualAlertYazisi);


        //5- Tamam diyerek alert'i kapatalim

        driver.switchTo().alert().accept();
        bekle(2);


        //6- Elementral Selenium linkine tiklayalim

        String ilkSayfaWhd=driver.getWindowHandle();

        System.out.println("ilk sayfanın Hendil değeri "+ilkSayfaWhd);

        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        String ikinciSayfaWhd="";
        Set<String> whdSeti=driver.getWindowHandles();

        System.out.println("Burda hangi değeri getiriyor :"+whdSeti);
        bekle(2);

        for (String each:whdSeti
             ) {

            if (!each.equals(ilkSayfaWhd)){
                ikinciSayfaWhd=each;
                System.out.println("Bu ekranda ikinci hendil değerini getiriyor :"+each);
            }
        }


        //7- Acilan sayfada h1 taginda "Make sure your code lands" yazdigini test edelim

        driver.switchTo().window(ikinciSayfaWhd);

        String ekranaGelenYazi="Make sure your code lands";
        String expectedYazi4= driver.findElement(By.tagName("h1")).getText();


        Assert.assertEquals(ekranaGelenYazi,expectedYazi4);
    }
}
