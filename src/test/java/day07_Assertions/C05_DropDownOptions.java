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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptions {
    /*
    Amazon anasayfaya gidip dropdown menuden books'u secelim
    sectigimiz option 'u yazdiralim

    dropdowndaki opsiyonlarin toplam sayisinin 28 oldugunu test edin
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        WebElement ddm = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Books");
        System.out.println(select.getFirstSelectedOption().getText());


       // System.out.println("select.getOptions().size() = " + select.getOptions().size());
        List<WebElement> liste = select.getOptions();
        int actualOptionSayisi = liste.size();
        int expectedOptionSayisi = 28;
        Assert.assertEquals(actualOptionSayisi,expectedOptionSayisi);
    }
}
