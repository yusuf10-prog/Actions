package day07_assertions_checkBox;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.sql.ResultSet;
import java.time.Duration;

public class C03_CheckBox {
    //a. Verilen web sayfasına gidin.
    //     https://the-internet.herokuapp.com/checkboxes
    // b. Checkbox1 ve checkbox2 elementlerini locate edin.
    // c. Checkbox1 seçili değilse onay kutusunu tıklayın
    // d. Checkbox2 seçili değilse onay kutusunu tıklayın
    // e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin

    static WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/checkboxes");


    }

    @After
    public void teardown() {
        driver.close();

    }

    @Test
    public void checkBoxTest() {

        // b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        ReusableMethods.bekle(2);

        // c. Checkbox1 seçili değilse onay kutusunu tıklayın

        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }
        ReusableMethods.bekle(2);

        // d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }
        ReusableMethods.bekle(2);

        // e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin

        Assert.assertTrue(checkBox1.isSelected() && checkBox2.isSelected());
    }
}
