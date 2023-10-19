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
            driver.get("https://demoqa.com/droppable");
            //2- "Drag me" butonunu tutup "Drop here" kutusunun üzerine bırakalım
            WebElement suruklenecekElement = driver.findElement(By.id("draggable"));
            WebElement suruklenecekHedefAlan = driver.findElement(By.id("droppable"));


            Actions actions = new Actions(driver);
            bekle(3);
            actions.dragAndDrop(suruklenecekElement, suruklenecekHedefAlan).perform();
            //3- "Drop here" yazısı yerine "Dropped!"
            String expectedYazi = "Dropped!";
            String actualYazi;
            bekle(2);
            actualYazi = driver.findElement(By.id("droppable")).getText();
            bekle(3);
            Assert.assertEquals(expectedYazi, actualYazi);
        }
    }
