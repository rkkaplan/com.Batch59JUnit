package ElifHocaPractice_JUnit.day02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class P10 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // web sitesini maximize yapin
        // ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        // tüm ikinci emoji öğelerini tıklayın
        WebElement secondEmoji = driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        secondEmoji.click();
        List<WebElement> emojiOgeler = driver.findElements(By.xpath("//div[@id='nature']//div//img"));

        for (WebElement e:emojiOgeler
             ) {
            e.click();
            Thread.sleep(1000);

        }


        // parent iframe e geri donun
        driver.switchTo().parentFrame();
        // formu doldurun,(Formu istediğiniz metinlerle doldurun)

        //  apply button a basin

    }
}
// https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
// web sitesini maximize yapin
// ikinci emojiye tıklayın
// tüm ikinci emoji öğelerini tıklayın
// parent iframe e geri donun
// formu doldurun,(Formu istediğiniz metinlerle doldurun)
//  apply button a basin
