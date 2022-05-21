package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Practice_BestBuyAssertions {
    /*
    1) Bir class oluşturun: BestBuy Assertions
    2) https://www.bestbuy.com/ Adresine gidin
    farkli test method’lari olusturarak asagidaki testleri yapin
○   Sayfa URL’inin https://www.bestbuy.com/ com/‘a esit oldugunu test edin
○   titleTest => Sayfa başlığının “ Rest” içer me diğini(contains) test edin
○   logoTest => BestBuy logosunun görüntülendigini test edin
○   Francais LinkTest => Fransizca Linkin görüntülendiğini test edin
     */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public  void urlTest(){
        // 2) https://www.bestbuy.com/ Adresine gidin
        driver.get("https://www.bestbuy.com/");

        //Sayfa URL’inin https://www.bestbuy.com/ com/‘a esit oldugunu test edin
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.bestbuy.com/";

        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test
    public  void titleTest(){
        // titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        driver.get("https://www.bestbuy.com/");
        String pageTitle = driver.getTitle();
        String expectedWord = "Rest";

        Assert.assertFalse(pageTitle.contains(expectedWord));

    }

    @Test
    public void logoTest(){
        driver.get("https://www.bestbuy.com/");
        //logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));


        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void linkTest(){
        driver.get("https://www.bestbuy.com/");

        //Francais LinkTest => Fransizca Linkin görüntülendiğini test edin

        WebElement francaisLink = driver.findElement(By.xpath("//button[@lang='fr']"));

        Assert.assertTrue(francaisLink.isDisplayed());

    }
}
