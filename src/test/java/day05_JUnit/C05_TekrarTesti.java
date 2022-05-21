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
import java.util.Arrays;

public class C05_TekrarTesti {
    //1 C01_TekrarTesti isimli bir class olusturun
    //2 https://www.google.com/ adresine gidin
    //3 cookies uyarisini kabul ederek kapatin
    //4 Sayfa basliginin “Google” ifadesi icerdigini test edin
    //5 Arama cubuguna “Nutella” yazip aratin
    //6 Bulunan sonuc sayisini yazdirin
    //7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    //8 Sayfayi kapatin
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
       driver.close();
    }

    @Test
    public void test01() {
        //2 https://www.google.com/ adresine gidin
        driver.get("https://www.google.com");

        //3 cookies uyarisini kabul ederek kapatin  (cookies cikmadi)
        //4 Sayfa basliginin “Google” ifadesi icerdigini test edin
        String baslik = driver.getTitle();
        String aranacakDeger = "Google";
        if (baslik.contains(aranacakDeger)){
            System.out.println("baslik testi PASSED");
        }else {
            System.out.println("baslik testi FAILED");
        }

        //5 Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@title='Ara']")).sendKeys("Nutella" + Keys.ENTER);
        //6 Bulunan sonuc sayisini yazdirin
        WebElement resultStats = driver.findElement(By.id("result-stats"));
        System.out.println("resultStats.getText() = " + resultStats.getText());
        String arr [] = resultStats.getText().split(" ");
        int resultSearch =Integer.parseInt(arr[1].replaceAll("\\D", ""));

        //7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        if (resultSearch>10000000){
            System.out.println("result search test PASSED");
        }else {
            System.out.println("result search test FAILED");
        }

        //8 Sayfayi kapatin


    }



}
