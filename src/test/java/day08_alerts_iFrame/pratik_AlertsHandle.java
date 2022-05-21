package day08_alerts_iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class pratik_AlertsHandle {

    //● Bir class olusturun: Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //● Bir metod olusturun: acceptAlert
    //      ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //      “You successfully clicked an alert” oldugunu test edin.
    //● Bir metod olusturun: dismissAlert
    //      ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //      “successfuly” icermedigini test edin.
    //● Bir metod olusturun: sendKeysAlert
    //      ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    //      OK butonuna     tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void acceptAlert(){
        //Bir metod olusturun: acceptAlert
        //    //      ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //    //      “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        String excpectedMes = "You successfully clicked an alert";
        String actualMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(excpectedMes,actualMessage);

    }
    //● Bir metod olusturun: dismissAlert
    //      ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //      “successfuly” icermedigini test edin.
    @Test
    public void  dismissAlert(){
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String unexpectedMEs = "successfuly";
        String actualMes = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertFalse(actualMes.contains(unexpectedMEs));
    }
    //● Bir metod olusturun: sendKeysAlert
    //      ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    //      OK butonuna     tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    @Test
    public void sendKeysAlert(){
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("rid");
        driver.switchTo().alert().accept();
        String expMes ="rid";
        String actMes = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertTrue(actMes.contains(expMes));

    }

}
