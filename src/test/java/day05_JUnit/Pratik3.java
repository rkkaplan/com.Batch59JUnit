package day05_JUnit;

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

public class Pratik3 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
        // driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.youtube.com");
        Thread.sleep(3000);
        WebElement aramaBoslugu  = driver.findElement(By.xpath("//input[@name='search_query']"));
        aramaBoslugu.sendKeys("Suavi Tükenme");
        driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-searchbox'])[2]")).click();
        driver.findElement(By.xpath("(//*[text()='Suavi - Tükenme'])[1]")).click();



    }
}
