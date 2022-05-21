package ElifHocaPractice_JUnit.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class iframe {
    /*
    ● Bir class olusturun: IframeTest 02
            1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
            2) sayfadaki iframe sayısını bulunuz.
            3)
    ilk iframe'deki (Youtube) play butonuna tıklayınız.
            4)
    ilk iframe'den çıkıp ana sayfaya dönünüz
            5)
    ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live selenium project.html)
    tıklayınız

     */
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
        //driver.close();
    }
    //         1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz

    @Test
    public void test() {
        driver.get("http://demo.guru99.com/test/guru99home/");
        //         2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> frame=driver.findElements(By.xpath("//iframe"));
        System.out.println("frame.size() = " + frame.size());
        System.out.println("frame.get(1) = " + frame.get(1).getText());

        //         3)
        // ilk iframe'deki (Youtube) play butonuna tıklayınız.


    }

}
