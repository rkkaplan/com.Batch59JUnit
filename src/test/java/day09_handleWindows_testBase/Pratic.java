package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Pratic {
    /*
    ●Y eni bir class olusturun: WindowHandle
●Amazon anasayfa adresine gidin.
●Sayfa’nin window handle degerini String bir degiskene atayin
●Sayfa title’nin “Amazon” icerdigini test edin
●Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
●Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
●Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
●Sayfa title’nin “Walmart” icerdigini test edin
●Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

     */
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {
        //●Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        String firstPageUrl = driver.getCurrentUrl();

        //●Sayfa’nin window handle degerini String bir degiskene atayin
        String firstPageWindowHandle = driver.getWindowHandle();
        //●Sayfa title’nin “Amazon” icerdigini test edin
        String expectedWord = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedWord));
        //●Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");
        //●Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String expectedWord2 = "TECHPROEDUCATION";
        String actualTitle2 = driver.getTitle();
        Assert.assertFalse(actualTitle2.contains(expectedWord2));
        //●Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        //●Sayfa title’nin “Walmart” icerdigini test edin
        String expectedWord3 = "Walmart";
        String actualTitle3 = driver.getTitle();

        //●Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(firstPageWindowHandle);
        String currentUrlAmazon = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlAmazon,firstPageUrl);
    }
}
