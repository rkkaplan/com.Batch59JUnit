package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Actions extends TestBase {
    /*
    1- Yeni bir class olusturalim: MouseActions1
2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
3- Cizili alan uzerinde sag click yapalim
4- Alert’te cikan yazinin “You selected a context menu” oldugunu
    test edelim.
5- Tamam diyerek alert’i kapatalim
6- Elemental Selenium linkine tiklayalim
7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

     */
    @Test
    public void test01(){
        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("hot-spot"));
        actions.contextClick(element).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.

        String expectedExp = "You selected a context menu";
        String actualExp = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedExp,actualExp);


        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWindowHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        Set<String> handleSeti = driver.getWindowHandles();
        String ikinciSayfaWindowHandle = "";
        for (String each : handleSeti){
            if (!each.equals(ilkSayfaWindowHandle)){
                ikinciSayfaWindowHandle = each;
            }
        }
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        driver.switchTo().window(ikinciSayfaWindowHandle);
        WebElement yaziElementi = driver.findElement(By.tagName("h1"));
        String expectedExp2 ="Elemental Selenium";
        String actualExp2 = yaziElementi.getText();
        Assert.assertEquals(expectedExp2,actualExp2);
    }

}
