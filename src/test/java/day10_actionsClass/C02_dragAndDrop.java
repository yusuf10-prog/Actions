package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_dragAndDrop extends TestBase {
    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim

        driver.get("https://demoqa.com/droppable ");

        //2- "Drag me" butonunu tutup "Drop here" kutusunun ustune birakalim
        WebElement sururklenecekElement= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement suruklenecekHedefAlan= driver.findElement(By.xpath("(//*[@id='draggable'])[1]"));

        Actions actions=new Actions(driver);
        bekle(3);
        actions.dragAndDrop(sururklenecekElement,suruklenecekHedefAlan).perform();

        
        //3- "Drop here" yazisi yerine "Dropped!"

        String expectedYazi="Dropped!";
        String actualYazi;
        actualYazi = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
        bekle(3);

        Assert.assertEquals(expectedYazi,actualYazi);
    }
}
