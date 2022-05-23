package day12_synchronization;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class windowHandleHomework extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //Window Handle Home Work
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String windowHandleFirstPage = driver.getWindowHandle();
        //2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        WebElement loginPortal = driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //3."Login Portal" a tiklayin
        loginPortal.click();
        //4.Diger window'a gecin
        Set<String> wHandleSet = driver.getWindowHandles();
        String windowHandleSecondPage = "";

        for (String e :wHandleSet
             ) {
            if (!e.equals(windowHandleFirstPage)){
                windowHandleSecondPage = e;
            }
        }
        driver.switchTo().window(windowHandleSecondPage);


        //5."username" ve "password" kutularina deger yazdirin
       WebElement username= driver.findElement(By.xpath("//input[@id='text']"));
       Faker fake = new Faker();
        username.sendKeys(fake.name().firstName() + Keys.TAB);
        Thread.sleep(2000);
        actions.sendKeys(fake.internet().password()).perform();
        Thread.sleep(2000);
        //6."login" butonuna basin
        actions.sendKeys(Keys.TAB ).sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedText = "validation failed";
        String actualText = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedText,actualText);
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        //9.Ilk sayfaya geri donun
        driver.switchTo().window(windowHandleFirstPage);
        //10.Ilk sayfaya donuldugunu test edin
        String expectedUrl = "http://webdriveruniversity.com/";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,currentUrl);
    }
}
//Window Handle Home Work
//1."http://webdriveruniversity.com/" adresine gidin
//2."Login Portal" a kadar asagi inin
//3."Login Portal" a tiklayin
//4.Diger window'a gecin
//5."username" ve "password" kutularina deger yazdirin
//6."login" butonuna basin
//7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
//8.Ok diyerek Popup'i kapatin
//9.Ilk sayfaya geri donun
//10.Ilk sayfaya donuldugunu test edin
