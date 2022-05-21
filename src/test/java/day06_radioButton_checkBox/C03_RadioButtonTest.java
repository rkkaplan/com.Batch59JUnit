package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButtonTest {
    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
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
        driver.close();
    }


    @Test
    public void radioButtonTest() throws InterruptedException {

        //-  https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //-Cookies’i kabul edin (ulkeye gore degisebilir---> cookies alert acilmadi)
        //-“Create an Account” button’una basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        //-“radio buttons” elementlerini locate edin
        WebElement kadin = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement erkek = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement ozel = driver.findElement(By.xpath("//input[@value='-1']"));

        Thread.sleep(3000);



        //-Secili degilse cinsiyet butonundan size uygun olani secin

       if (!erkek.isSelected()){
           erkek.click();
       }
        Thread.sleep(3000);

       kadin.click();
        Thread.sleep(3000);
        ozel.click();
        Thread.sleep(3000);









    }




}
