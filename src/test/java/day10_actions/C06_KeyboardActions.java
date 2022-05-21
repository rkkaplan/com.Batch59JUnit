package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // facebook anasayfaya gidip
        driver.get("https://www.facebook.com");
        // yeni kayit olustur butonuna basin
        WebElement yeniKayit = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        yeniKayit.click();
        // isim kutusunu locate edip,
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name='firstname']"));
        // geriye kalan alanlari TAB ile dolasarak
        // formu doldurun
        Actions actions = new Actions(driver);
        actions.click(isimKutusu).
                sendKeys("ali" +Keys.TAB + "veli" + Keys.TAB + "alivelibrasil@gmail.com" + Keys.TAB + "alivelibrasil@gmail.com").
                sendKeys(Keys.TAB + "145698qq" + Keys.TAB + Keys.TAB).
                sendKeys("12"+Keys.TAB + "May"+Keys.TAB + "1987"+Keys.TAB+Keys.TAB).
                sendKeys(Keys.RIGHT).moveToElement(driver.findElement(By.xpath("(//button[@type='submit'])[2]"))).click().


                perform();
        // facebook anasayfaya gidip
        // yeni kayit olustur butonuna basin
        // isim kutusunu locate edip,
        // geriye kalan alanlari TAB ile dolasarak
        // formu doldurun



        Thread.sleep(3000);


    }
}
