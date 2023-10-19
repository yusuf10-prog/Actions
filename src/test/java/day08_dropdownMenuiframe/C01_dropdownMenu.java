package day08_dropdownMenuiframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.awt.*;
import java.util.List;

public class C01_dropdownMenu extends TestBase {

    @Test
    public void dropdownMenu(){
        // https://the-internet.herokuapp.com

        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownElementi= driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select=new Select(dropdownElementi);

        // 1.Index kullanarak secenek 1'i (Option 1 ) seçin ve yazdırın

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        bekle(2);

        // 2. Value kullanarak Secenek 2'yi (option 2) seçin ve yazdırın

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        bekle(2);

        // 3.Visible Text(Görünen metin) kullanarak Secenek 1'i (option 1 ) secin ve yazdirin

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        bekle(2);

        //  4.Tüm dropdown degerleri (value) yazdirin

        System.out.println("======Tum Opsiyonlar=========");

        List<WebElement> optionsList=select.getOptions();
        for (WebElement each:optionsList
             ) {
            System.out.println(each.getText());

            // 5. Dropdown'un boyutunun 4 oldugunu test edin

        }
        int expectedBoyut=4;
        int actualBoyut=optionsList.size();

        Assert.assertEquals("Dropdown Menu Boyutu 4 Değil:"+expectedBoyut,actualBoyut);

    }
}
