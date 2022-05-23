package day12_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class mondayPratic extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");


        //2. “Our Products” butonuna basin
        Actions actions = new Actions(driver);
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iFrame);
        WebElement ourProd = driver.findElement(By.xpath("//a[@href='products.html']"));
        actions.moveToElement(ourProd).click().perform();


        //3. “Cameras product”i tiklayin

        WebElement camera = driver.findElement(By.xpath("//*[text()='Cameras']"));
        camera.click();
        Thread.sleep(4000);

        //4. Popup mesajini yazdirin


        String popUpText = driver.findElement(By.xpath("//div[@class='modal-content']")).getText();
        System.out.println("popUpText = " + popUpText);

        //5. “close” butonuna basin
        driver.findElement(By.xpath("//button[text()='Close']")).click();

        Thread.sleep(3000);

        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        Actions action = new Actions(driver);
        WebElement iframeLink=driver.findElement(By.xpath("(//a[@id='nav-title'])[1]"));
        action.moveToElement(iframeLink).doubleClick().perform();



        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl = "http://webdriveruniversity.com/index.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }
}

//1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin


//2. “Our Products” butonuna basin


//3. “Cameras product”i tiklayin

//4. Popup mesajini yazdirin

//5. “close” butonuna basin

//6. "WebdriverUniversity.com (IFrame)" linkini tiklayin

//7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin

