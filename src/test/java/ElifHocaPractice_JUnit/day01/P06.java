package ElifHocaPractice_JUnit.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class P06 {
     /*
      ...Exercise6...
   // 1. Amazon.com'a gidelim.
   // 2. DropDown üzerinde Books secelim.(All yazan yerde)
   //    kategorilerin hepsini konsola yazdiralim
   // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
   // 4. Sonuc sayisini ekrana yazdiralim.
   // 5. Sonucların Les Miserables i icerdigini assert edelim
   */
     WebDriver driver;
    @Before
    public  void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After
    public  void tearDown() {
        driver.close();
    }
    @Test
    public void test(){
        // 1. Amazon.com'a gidelim.
        driver.get("https://www.amazon.com");
        // 2. DropDown üzerinde Books secelim.(All yazan yerde)
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Books");
        //    kategorilerin hepsini konsola yazdiralim
        List<WebElement> options = select.getOptions();
        for (WebElement e:options
             ) {
            System.out.println(e.getText());
        }
        // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Les Miserables"+ Keys.ENTER);
        // 4. Sonuc sayisini ekrana yazdiralim.
        String [] sonucSayisi = driver.findElement(By.xpath("//span[normalize-space()='1-16 of over 5,000 results for']")).getText().split(" ");
        System.out.println("Les Miserables icin sonuc sayisi = "+sonucSayisi[3]);
        // 5. Sonucların Les Miserables i icerdigini assert edelim
        WebElement lesMiserables = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(lesMiserables.getText().contains("Les Miserables"));

    }
}
