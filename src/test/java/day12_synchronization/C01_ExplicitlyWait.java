package day12_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {
    // 1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //   Iki metod icin de asagidaki adimlari test edin.


    @Test
    public void testImplicitliyWait() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement messageItsGone = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(messageItsGone.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement messageItsBack = driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(messageItsBack.isDisplayed());

    }

    @Test
    public void testExplicitlyWait() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
       /* WebElement messageItsGone = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(messageItsGone));
        Assert.assertTrue(messageItsGone.isDisplayed());

        yazinin yazilmasini beklerken yazinin locate ini kullanmak sorun olur
        cunku henuz gorunmeyen bir yazinin locate edilmesi de mumkun olmayabilir
        (HTML kodlari yazan developer farkli uygulamalar yapabilir)
        Bu durumda bekleme islemi ve locate i birlikte yapmaliyiz
        */
        WebElement messageItsGone = wait.until(ExpectedConditions.
                                                visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        Assert.assertTrue(messageItsGone.isDisplayed());




        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement messageItsBack = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));

        Assert.assertTrue(messageItsBack.isDisplayed());
    }
}
// 1. Bir class olusturun : WaitTest
//2. Iki tane metod olusturun : implicitWait() , explicitWait()
//   Iki metod icin de asagidaki adimlari test edin.
//3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
//4. Remove butonuna basin.
//5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
//6. Add buttonuna basin
//7. It’s back mesajinin gorundugunu test edin