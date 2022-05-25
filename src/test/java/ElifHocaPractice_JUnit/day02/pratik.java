package ElifHocaPractice_JUnit.day02;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class pratik extends TestBase {
    @Test
    public void test01() {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
// web sitesini maximize yapin
// ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        WebElement secondEmoji =
                driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        secondEmoji.click();
// tüm ikinci emoji öğelerini tıklayın
        List<WebElement> emojiList = driver.findElements(By.xpath("//div[@id='nature']//div//img"));
        emojiList.stream().forEach(t->t.click());
       // for (int i = 0; i<emojiList.size();i++){
       //     emojiList.get(i).click();
       // }
// parent iframe e geri donun
        driver.switchTo().parentFrame();
// formu doldurun,(Formu istediğiniz metinlerle doldurun)
        WebElement form =
                driver.findElement(By.xpath("(//div[@class='mdl-textfield mdl-js-textfield mdl-textfield--floating-label is-upgraded'])[1]"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        actions.click(form).sendKeys(faker.name().firstName() + Keys.TAB +
                faker.name().firstName() + Keys.TAB +faker.name().firstName() + Keys.TAB +faker.name().firstName() +
                Keys.TAB +faker.name().firstName() + Keys.TAB +faker.name().firstName() + Keys.TAB +
                faker.name().firstName() + Keys.TAB +faker.name().firstName() + Keys.TAB +faker.name().firstName()  + Keys.ENTER).perform();

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
