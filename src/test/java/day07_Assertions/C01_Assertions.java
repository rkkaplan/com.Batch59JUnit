package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
    amazon ana sayfaya gidin
    3 farkli test methodu olusturarak asagidaki gorevleri yapin
    1- Url'in amazon icerdigini test edin
    2- title'in facebook icermedigini test edin
    3- sol ust kosede amazon logosunun gorundugunu test edin
     */
    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
    @Test
    public void test1() {

        //1- Url'in amazon icerdigini test edin
        String arananKelime = "Amazon";
        String actualUrl = driver.getTitle();
        Assert.assertTrue(actualUrl.contains(arananKelime));
    }

    @Test
    public void test2() {

        // 2- title'in facebook icermedigini test edin
        String istenmeyenKelime2 = "facebook";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime2));
    }

    @Test
    public void test3() {

        // sol ust kosede amazon logosunun gorundugunu test edin

        WebElement logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        Assert.assertTrue(logo.isDisplayed());



    }


}
