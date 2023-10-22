package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUploadTesti extends TestBase {

    @Test
    public void test01(){
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");


        //2.chooseFile butonuna basalim
        /*
        // insan olarak dosya secimi icin
        // chooseFile butonuna bastiktan sonra
        // acilan dosya penceresinden istedigimiz dosyayi secip yükleriz

        selenium 'da otomasyon ile bu islemi yapmak icin
        chooseFile (dosya sec) butonu locate edilip, bu webelement'e
        sendKeys(yuklenecekDosyaninDosyaYolu); yapilir.

         */

        //3.Yuklemek istediginiz dosyayi secelim.

        WebElement uploadButtonElementi= driver.findElement(By.xpath("//input[@id='file-upload']"));
        String dinamikDosyaYolu=System.getProperty("user.dir") +
                "/src/test/java/day11_fileTestleri_Waits/text.txt";

        uploadButtonElementi.sendKeys(dinamikDosyaYolu);


        //4.Upload butonuna basalim.

        driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        //5.“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement fileUpLoadedElemnti=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUpLoadedElemnti.isDisplayed());

        bekle(5);

    }
}
