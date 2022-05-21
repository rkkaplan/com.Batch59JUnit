package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class pratikFacebook extends TestBase {

    @Test
    public void test1() {
        // facebook anasayfaya gidip
        driver.get("https://www.facebook.com");
        // yeni kayit olustur butonuna basin
        Actions actions = new Actions(driver);
        WebElement yeniKayit = driver.findElement(By.xpath("//*[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]"));


        yeniKayit.click();
        // isim kutusunu locate edip,

        WebElement isim = driver.findElement(By.xpath("//input[@name='firstname']"));
        // geriye kalan alanlari TAB ile dolasarak
        // formu doldurun
        actions.click(isim).sendKeys("ali" + Keys.TAB + "veli" + Keys.TAB + "aliveli@gmail.com"+ Keys.TAB + "aliveli@gmail.com"+
                                       Keys.TAB + "12345" + Keys.TAB + Keys.TAB + "1" + Keys.TAB + "May" + Keys.TAB).
                sendKeys("1991" + Keys.TAB + Keys.TAB + Keys.RIGHT + Keys.ENTER).

                perform();




    }
}
