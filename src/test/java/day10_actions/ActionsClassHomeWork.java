package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
        //Yeni Class olusturun:  ActionsClassHomeWork
public class ActionsClassHomeWork extends TestBase {
    @Test
    public void name() {

        //1 "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2  Hover over Me First" kutusunun ustune gelin
        WebElement hover = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hover).
        //3  Link 1" e tiklayin
                moveToElement(driver.findElement(By.xpath("//*[text()='Link 1']"))).click().perform();

        //4 Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5 Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6 --“Click and hold" kutusuna basili tutun
        actions.clickAndHold(driver.findElement(By.xpath("//*[text()='Click and Hold!']"))).perform();
        //7 --“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//*[text()='Well done! keep holding that click now.....']")).getText());
        //8 --“Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.xpath("//*[text()='Double Click Me!']"))).perform();
    }
}
