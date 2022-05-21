package ElifHocaPractice_JUnit.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05 {
    /*
       ...Exercise5...
      @BeforeClass ın icerisinde driver i kuralim
      maximize edip tum web elementler yuklenene kadar 10 sn bekletelim
      Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
      Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
      @AfterClass ta driver ı kapatalim
       */

    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test(){
        //Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
        driver.get("https://www.google.com");
        String expectedWord ="Google";
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains(expectedWord));

        //      Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
        driver.get("https://www.amazon.com");
        String expectedUrl ="www.amazon.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));



    }
}
