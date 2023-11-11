package day12_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.stylesheets.LinkStyle;
import utilities.TestBase;

import java.util.List;

public class C10_ProjedenOrnek extends TestBase {

    @Test
    public void test01(){
        driver.get("https://qa.smartcardlink.com/login");

        WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
        email.click();
        email.sendKeys("admin04@smartcardlink.com");

        WebElement posword= driver.findElement(By.xpath("//input[@id='password']"));
        posword.click();
        posword.sendKeys("123123123");

        bekle(2);

        driver.findElement(By.xpath("//button[text()='Login']")).click();

        bekle(2);

        driver.findElement(By.xpath("//span[text()='Users']")).click();

        bekle(2);

        WebElement tumTablo=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumTablo.getText());

        List<WebElement> satirlarListesi=driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSayisi=10;
        int actualSatirSayisi=satirlarListesi.size();
        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        // tüm satirları yazdirma işlemi yapıcaz

        System.out.println("======= Satirlarin Yazildigi Ekran==============");

        for (int i = 0; i <satirlarListesi.size() ; i++) {
            System.out.println((i+1) +".ci satir : " +satirlarListesi.get(i).getText());
        }

        WebElement element=driver.findElement(By.xpath("//select[@id='perPage']"));

        Select select=new Select(element);
        select.selectByValue("50");
        bekle(2);

        System.out.println("=======  Selecten Sonraki Ekran ==============");

        List<WebElement> satirlarListesi1=driver.findElements(By.xpath("//tbody/tr"));

        for (int i = 0; i <satirlarListesi1.size() ; i++) {
            System.out.println((i+1) +".ci satir : " +satirlarListesi1.get(i).getText());

        }


        WebElement result=
                driver.findElement(By.xpath("//*[@class='text-muted ms-sm-3 pagination-record']"));

        System.out.println("sayfanın en altındaki alan :"+result.getText());

        bekle(2);

        WebElement search= driver.findElement(By.xpath("//input[@type='search']"));
        search.sendKeys("Yusuf");

        bekle(2);

        WebElement editButonu=driver.findElement(By.xpath("//*[@title='Edit']"));
        bekle(2);
        editButonu.click();

        bekle(2);


       //WebElement combobox = driver.findElement(By.className("//div[@class='iti__flag-container']"));
       bekle(2);

       //combobox.findElement(By.className("iti__selected-dial-code"));

        //driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//a[@class='btn btn-outline-primary float-end']")).click();
        driver.findElement(By.xpath("(//*[@class='btn btn-sm btn-info user-impersonate'])[1]")).click();
        // admin sayfasında kullanıcı sayfasına dön
        bekle(1);
        driver.findElement(By.xpath("//*[@data-icon='user-check']")).click();

        driver.findElement(By.xpath("(//*[@class='svg-inline--fa fa-key'])[1]")).click();
        bekle(1);
     //   WebElement password=driver.findElement(By.xpath("//input[@id='current_password']"));
     //   password.sendKeys("K135298k.k");

      //  WebElement confirmPassword=driver.findElement(By.xpath("(//input[@id='confirm_password'])[1]"));
      //  confirmPassword.click();
      //  confirmPassword.sendKeys("K135298k.k");

      //  WebElement tumList=driver.findElement(By.xpath("//*[@class='iti__selected-flag']"));
       // Select select1=new Select(tumList);

        //List<WebElement> optionsList=select1.getOptions();
       // System.out.println(optionsList.size());

        bekle(3);

    }
}
