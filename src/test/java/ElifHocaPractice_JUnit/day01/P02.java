package ElifHocaPractice_JUnit.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class P02 {
     /*
   ...Exercise2...
   http://www.bestbuy.com 'a gidin,
   Sayfa basliginin "Best" icerdigini(contains) dogrulayin
   Ayrica Relative Locator kullanarak;
       logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
       mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
*/  WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.bestbuy.com");
    }
    @After
    public void tearDown() {
        driver.close();
    }
    @Test
    public void test1(){
        Assert.assertTrue(driver.getTitle().contains("Best"));

    }
    @Test
    public void logoTest2(){
        WebElement helloHEading = driver.findElement(By.xpath("//div[@class ='heading']"));
        WebElement logoBestBuy = driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHEading));
        Assert.assertTrue(logoBestBuy.isDisplayed());


    }
    @Test
    public void test3() {
        WebElement abdBayragiElementi=driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement mexicoLinkElementi=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(abdBayragiElementi));
        Assert.assertTrue(mexicoLinkElementi.isDisplayed());

    }
}
