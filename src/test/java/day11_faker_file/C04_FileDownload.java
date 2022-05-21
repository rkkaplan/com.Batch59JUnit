package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1. Tests packagenin altina bir class oluşturalim
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. dummy.txt dosyasını indirelim
        WebElement dummy = driver.findElement(By.xpath("//*[text()='dummy.txt']"));
        dummy.click();

        Thread.sleep(5000);
        //4. dosyanın başarıyla indirilip indirilmediğini test edelim
        String path = System.getProperty("user.home") + "\\Downloads\\dummy.txt";

        Assert.assertTrue(Files.exists(Paths.get(path)));
        System.out.println("github");
    }




}
