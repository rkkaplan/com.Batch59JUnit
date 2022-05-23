package day12_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class sundayTask extends TestBase {
    @Test
    public void test01() {
        //Notes: It may also be necessary to write code to accept the accept cookies warning.

        //1. Go to 'https://www.amazon.com.tr/'
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.xpath("//input[@name='accept']")).click(); // We accepted cookies warning
        //2. Search iPhone13 512
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iPhone13 512" + Keys.ENTER);

        //3. Check that the results are listed
        WebElement searchResultsLists = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedWord = "iPhone13 512";
        String actualList = searchResultsLists.getText();
        Assert.assertTrue(actualList.contains(expectedWord));
        //4. Click iPhone13 at the top of the list
        WebElement topOfTheList = driver.findElement(By.xpath("//img[@data-image-index='1']"));
        topOfTheList.click();
        //5. Log the following values for each size
        //.Size information .Price .Color .Stock status


        WebElement size = driver.findElement(By.xpath("//span[@id='inline-twister-expanded-dimension-text-size_name']"));
        System.out.println("size.getText() = " + size.getText());
    }

}

/*
Notes: It may also be necessary to write code to accept the accept cookies warning.
1. Go to 'https://www.amazon.com.tr/'
2. Search iPhone13 512
3. Check that the results are listed
4. Click iPhone13 at the top of the list
5. Log the following values for each size
.Size information .Price .Color .Stock status

 */
