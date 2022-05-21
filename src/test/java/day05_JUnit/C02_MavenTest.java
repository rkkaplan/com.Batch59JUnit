package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) {
        /*
        1.http://zero.webappsecurity.com sayfasina gidin
        2. Signin buttonuna tiklayin
        3. Login alanina "username" yazdirin
        4. Password alanine "password" yazdirin
        5. Sign in buttonuna tiklayin
        6. Pay Bills sayfasina gidin
        7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        8.  tarih kismina “2020-09-10" yazdirin
        9. Pay buttonuna tiklayin
        10. “The payment was successfully submitted.” mesajinin ciktigini control edin
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1.http://zero.webappsecurity.com sayfasina gidin

        driver.get("http://zero.webappsecurity.com");

        // 2. Signin buttonuna tiklayin

        WebElement signInButton = driver.findElement(By.xpath("//button[@id='signin_button']"));
        signInButton.click();

        //3. Login alanina "username" yazdirin
        WebElement login = driver.findElement(By.xpath("//input[@id='user_login']"));
        login.sendKeys("username");

        //4. Password alanine "password" yazdirin
        WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");

        // 5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna basin)
        WebElement signIn = driver.findElement(By.xpath("//input[@value='Sign in']"));
        signIn.click();
        driver.navigate().back();

        //6. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amount.sendKeys("100");

        //8.  tarih kismina “2020-09-10" yazdirin
        WebElement date = driver.findElement(By.xpath("//input[@id='sp_date']"));
        date.sendKeys("2020-09-10");

        //9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//div[@id='alert_content']"));

        if (sonucYazisiElementi.isDisplayed()){
            System.out.println("test PASSED");
        }else {
            System.out.println("test FAILED");
        }
        driver.close();








    }
}
