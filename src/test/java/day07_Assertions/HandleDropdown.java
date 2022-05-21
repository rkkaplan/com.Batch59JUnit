package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HandleDropdown {
    /*
1.http://zero.webappsecurity.com/ Adresine gidin
2. Sign in butonuna basin
3. Login kutusuna “username” yazin
4. Password kutusuna “password.” yazin
5. Sign in tusuna basin
6. Pay Bills sayfasina gidin
7. “Purchase Foreign Currency” tusuna basin
8. “Currency” drop down menusunden Eurozone’u secin
9. “amount” kutusuna bir sayi girin
10. “US Dollars” in secilmedigini test edin
11. “Selected currency” butonunu secin
12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test(){
        //1. http ://zero.webappsecurity .com Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        //3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        //4. Password kutusuna “password” yazin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        //6. Pay Bills sayfasina gidin
        //site guvenlik protokolunden dolayi asagidaki islemi yaptik
        driver.navigate().back();
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin
       WebElement ddm = driver.findElement(By.xpath("//*[@name='currency']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");

        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("50");
        //10. “US Dollars” in secilmedigini test edin
        WebElement usDollars = driver.findElement(By.xpath("//*[@id='pc_inDollars_true']"));
       Assert.assertFalse(usDollars.isSelected());
        //11. “Selected currency” butonunu secin
        driver.findElement(By.xpath("//*[@id='pc_inDollars_false']")).click();

        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//*[@value='Calculate Costs']")).click();
        driver.findElement(By.xpath("//*[@value='Purchase']")).click();

        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        String expectedAlert = "Foreign currency cash was successfully purchased.";
        WebElement alertContent = driver.findElement(By.xpath("//*[text()='Foreign currency cash was successfully purchased.']"));
        String actualAlert = alertContent.getText();

        Assert.assertEquals("alert test FAILED",expectedAlert,actualAlert);


    }

}
