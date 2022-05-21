package day08_alerts_iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class pratik_iframe {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
       // driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://html.com/tags/iframe/");
        WebElement iframeElements = driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        driver.switchTo().frame(iframeElements);
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();
        Thread.sleep(6000);
    }
}
