package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_DinamikDosyaYoluOlusturma extends TestBase {

    @Test
    public void test01(){


        /*
            Testlerimizin farkli bilgisayarlarda calismasi gerekiyorsa
            file testleri icin gerekli olan DOSYA YOLU dinamik yapilmalidir.

            Java'da dosya yolunu kodun calistigi bilgisayardan
            otomatik olarak almak icin 2 secenek vardir.

            System.getProperty("user.home) ==> bilgisayarin ana dosya yolunu verir.

             System.getProperty("user.dir) ==>

         */

        // masausutumuzde bulunan logo.jpg dosyasinin varligini
        // dinamik dosya yolu kullanarak test edelim.

        //   //Users/yusuf/Desktop/Jpeg_with_exif.jpeg


        // /Users/yusuf" +"/Desktop/Jpeg_with_exif.jpeg"

        // Ana dosya yolu    Herkeste aynı olan kisim

        String dinamikDosyaYolu=System.getProperty("user.home")+"/Desktop/Jpeg_with_exif.jpeg";

        System.out.println(dinamikDosyaYolu);

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));

        System.out.println(System.getProperty("user.dir"));

        ///Users/yusuf/IdeaProjects/Team120_JUnit_Fall2023

        // projemizde var olan text.txt'nin varligini
        // dinamik dosya yolu ile test edelim

        ///Users/yusuf/IdeaProjects/Team120_JUnit_Fall2023
        // /src/test/java/day11_fileTestleri_Waits/text.txt

        String dinamikTextDosyaYolu=System.getProperty("user.dir") +
                "/src/test/java/day11_fileTestleri_Waits/text.txt";

        Assert.assertTrue(Files.exists(Paths.get(dinamikTextDosyaYolu)));

    }
}
