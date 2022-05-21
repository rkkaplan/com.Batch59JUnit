package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.util.Assertions;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Practice_GroupMidDay_YouTubeAssertions {
    /*
    Arkadaslar Gunaydın
Bugun  saat 13'de zoom açacağız.
Yapacağımız zoom ile ilgili aşağıdaki başlıkları çalışalım diyorum.
her başlığı bir arkadaş alıp orada sunumunu yapabilirse çok iyi olur.

1. En son dersin genel bir tekrarı
2. chechBox ve radioButton ile ornek soru cozumu
3. Assertions ile ilgili asagıdaki soruların çözümlerinin yapılması
    1)
Bir class oluşturun: Youtube Assertions
    2)
https://www.youtube.com adresine gidin
    3)
Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
○ titleTest => Sayfa başlığının " YouTube ” oldugunu test edin
○ imageTest => YouTube resminin görüntülendiğini isDisplayed()) test edin
○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */


   static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    //2) https://www.youtube.com adresine gidin

    @Test
    public void titleTest() {
        driver.get("https://www.youtube.com");

        // titleTest => Sayfa başlığının "YouTube" tr oldugunu test edin
        String pageTitle = driver.getTitle();
        String expectedTitle = "YouTube";

        Assert.assertEquals("title test FAILED",pageTitle,expectedTitle);




    }

    @Test
    public void imageTest() {
        driver.get("https://www.youtube.com");

        // imageTest => YouTube resminin görüntülendiğini isDisplayed()) test edin
       WebElement image = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
       Assert.assertTrue(image.isDisplayed());

    }

    @Test
    public void searcBoxTest() {
        driver.get("https://www.youtube.com");
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement logo = driver.findElement(By.xpath("(//input[@name='search_query'])[1]"));
                Assert.assertTrue("logo test FAILED",logo.isEnabled());

    }

    @Test
    public void test4(){
        driver.get("https://www.youtube.com");
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

        String pageTitle = driver.getTitle();
        String expected = "youtube";

        Assert.assertFalse("test FAILED",pageTitle.equals(expected));
    }

}
