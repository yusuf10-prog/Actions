package day08_dropdownMenuiframe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
import utilities.TestBase_BeforeClass;

import java.util.List;

public class C02_dropdownMenu extends TestBase {

    WebElement kategoriDropdownElementi;
    Select select;

    @Before

    public void amazonaGiris(){

        // https://www.amazon.com/ adresine gidin

        driver.get("https://www.amazon.com/");

        kategoriDropdownElementi= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select=new Select(kategoriDropdownElementi);

    }

    @Test
    public void dropdownTesti(){
        // Test 1

        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

        List<WebElement> optionsList=select.getOptions();

        int expectedKategoriSayisi=45;
        int actualKategoriListesi=optionsList.size();

        Assert.assertEquals("Kategori dropdown menusünde 45 opsiyon yok "+expectedKategoriSayisi,actualKategoriListesi);
    }

    @Test
    public void javaAramaTesti(){


        // Test 2
        // 1. Kategori menusunden BookS secenegini secin

        select.selectByVisibleText("Books");
        // 2. Arama kutusuna Java yazin ve aratin

        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.click();
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        // 3. Bulunan sonuc sayisini yazdirin

        WebElement aramaSonucElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(aramaSonucElementi.getText());
        // 4. Sonucun Java kelimesini icerdigini test edin

        String expectedIcerik="Java";
        String actualSonucYazisi=aramaSonucElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
    }
}

