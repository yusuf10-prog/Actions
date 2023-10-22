package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_fileDownload extends TestBase {
    @Test
    public void test01(){

        // /Users/yusuf/Desktop/logo.jpg


        //https://the-internet.herokuapp.com/ adresine gidelim

        driver.get("https://the-internet.herokuapp.com/download");

        //3- logo.jpg dosyasını indirin

        driver.findElement(By.xpath("//*[text()='Jpeg_with_exif.jpeg']")).click();
        bekle(1);


        //4. Dosyanın basarıyla indirilip indirilmedigini test edelim
        bekle(5);

        String dosyaYolu="/Users/yusuf/Desktop/Jpeg_with_exif.jpeg";

        bekle(2);

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        bekle(2);
    }
}
