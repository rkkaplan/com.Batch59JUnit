package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
    //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
public class pratik1 extends TestBase {
    //2. Iki tane metod oluşturun :isExist() ve downloadTest ()
    //3- downloadTest () metodunun icinde aşağıdaki testi yap alim
    @Test
    public void downloadTest() {
        //https://the internet.herokuapp.com/download adresine gid elim
        //-
        //sample.pdf dosyasını indir elim
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement samplePdf = driver.findElement(By.xpath("//*[text()='sample.pdf']"));
        samplePdf.click();

    }
    @Test
    public void isExist() {
        //4. Ardından isExist() methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String filePath = System.getProperty("user.home") + "\\Downloads\\sample.pdf";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }

    //File D ownload /E xist C lass W ork
    //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    //2. Iki tane metod oluşturun :isExist() ve downloadTest ()
    //3- downloadTest () metodunun icinde aşağıdaki testi yap alim

    //https://the internet.herokuapp.com/download adresine gid elim
    //-
    //sample.pdf dosyasını indir elim
    //4. Ardından isExist() methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
}
