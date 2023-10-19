package day07_assertions_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_RadioButtons {

    //Gerekli yapıyı olusturun ve aşağıdaki görevi tamamlayın
    // a. verilen web sayfasina gidin
    //    https://facebook.com
    // b. Cookies'i kabul edin
    // c. Create an accoun buton'una basin
    // d. Radio button elementlerini locate edin ve size uygun olani secin
    // e. Seçtiğiniz radio button'un secili, ötekilerin secili olmadiğini test edin


    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.close();
    }

    @Test
    public void radiButtonTest(){

        // a. verilen web sayfasina gidin
        //    https://facebook.com
        driver.get("https://facebook.com");

        // b. Cookies'i kabul edin
        //bizde cookies çıkmadığı için yapmadım.

        // c. Create an accoun buton'una basin

        driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();

        // d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement femaleRadioB= driver.findElement(By.xpath("(//input[@*='_8esa'])[1]"));
        WebElement maleRadioB=driver.findElement(By.xpath("(//input[@*='_8esa'])[2]"));
        WebElement customRadioB=driver.findElement(By.xpath("(//input[@*='_8esa'])[3]"));
        maleRadioB.click();
        // e. Seçtiğiniz radio button'un secili, ötekilerin secili olmadiğini test edin

        Assert.assertTrue(maleRadioB.isSelected() &&
                !femaleRadioB.isSelected()
                && !customRadioB.isSelected());





    }
}
