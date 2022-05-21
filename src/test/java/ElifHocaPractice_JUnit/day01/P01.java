package ElifHocaPractice_JUnit.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {
    /*
   ...Exercise1...
   BeforeClass ile driver ı olusturun ve class icinde static yapin
   Maximize edin, 15 sn bekletin
   http://www.google.com adresine gidin
   arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
   arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
   arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
   AfterClass ile kapatın

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
        //driver.quit();
    }
    @Before
    public  void testtenOnce() {
        driver.get("http://www.google.com");
    }
    @Test
    public void test1() {
        //arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
        WebElement searchBox = driver.findElement(By.xpath("//input[@title='Ara']"));
        searchBox.sendKeys("Green Mile");
        searchBox.submit();    //Keys.ENTER    // searchButton.click()  //submit()

    }
    // arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test2() {
        WebElement searchBox = driver.findElement(By.xpath("//input[@title='Ara']"));
        searchBox.sendKeys("Premonition" + Keys.ENTER);


    }
    //arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test3() {
        WebElement searchBox = driver.findElement(By.xpath("//input[@title='Ara']"));
        searchBox.sendKeys("The Curious Case of Benjamin Button" + Keys.ENTER);

    }

    @After
    public void testtenSonra() {
        WebElement searchResults = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("searchResults.getText() = " + searchResults.getText());
    }




}
