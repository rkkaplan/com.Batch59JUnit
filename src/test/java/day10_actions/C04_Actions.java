package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions extends TestBase {
    //Yeni bir class olusturalim: MouseActions2
    //1 https://demoqa.com/droppable adresine gidelim
    //2  --“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3  --“Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test01(){
        //1 https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2  --“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement dragMe = driver.findElement(By.id("draggable"));
        WebElement dragHere = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(dragMe,dragHere).perform();


        //3  --“Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement sonucYzisiElementi = driver.findElement(By.xpath("//*[text()='Dropped!']"));

        String expectedExp3 = "Dropped!";
        String actualExp3 = sonucYzisiElementi.getText();

        Assert.assertEquals(expectedExp3,actualExp3);



    }
}
