package ElifHocaPractice_JUnit.day02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class P08 extends TestBase {
    @Test
    public void test01() {
    //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");

    //maximize the window
        //maximize yapildi
    //click on action dialog button
        driver.findElement(By.xpath("//button[@id='action']")).click();
    //if need use explicitly wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='modal-body']"))));
    //click on the ok button
        driver.findElement(By.xpath("//button[@id='dialog-mycodemyway-action']")).click();
    //accept the alert message
        driver.switchTo().alert().accept();


    }
}
/*
    //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
    //maximize the window
    //click on action dialog button
    //if need use explicitly wait
    //click on the ok button
    //accept the alert message
 */