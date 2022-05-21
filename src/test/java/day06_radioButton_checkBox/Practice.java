package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Practice {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.youtube.com");
        WebElement arama = driver.findElement(By.xpath("//input[@name='search_query']"));
        arama.sendKeys("fenerbahce" );
        arama.submit();

        Thread.sleep(3000);
        driver.findElement(By.xpath("(//yt-icon[@id='guide-icon'])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Ana Sayfa']")).click();




    }
}
