package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    /*
    amazon'a gidip
    dropdown'dan books secenegini secip
    Java aratalim
    ve arama sonuclarinin Java icerdigini test edelim
     */
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com");
        //1.adim dropDown'i locate edelim
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        //2.adim select objesi olustur ve paramaetre olarak locate edilen dropdown elementini belirt
        Select select = new Select(dropDownMenu);
        //3.adim options'lardan istedigimiz bir tanesini secelim
        select.selectByVisibleText("Books");
        //select.selectByIndex();
        //select.selectByValue();

        //arama kutusuna Java yazdiralim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java" + Keys.ENTER);
        Thread.sleep(3000);
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisiStr = sonucYazisiElementi.getText();

        System.out.println("sonucYazisiStr = " + sonucYazisiStr);
        String arananKelime = "java";

        Assert.assertTrue(sonucYazisiStr.contains(arananKelime));



    }
}
