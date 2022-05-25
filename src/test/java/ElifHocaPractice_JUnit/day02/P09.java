package ElifHocaPractice_JUnit.day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class P09 extends TestBase {
    @Test
    public void test01() {
        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");
        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("(//a[@class='analystic'])[1]")).click();
        driver.findElement(By.xpath("(//button[@class='btn btn-danger'])")).click();
        //    accept Alert(I am an alert box!) and print alert on console
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        //    cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();
        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();

        //    finally print on console this message "Hello TechProEducation How are you today"
        String expectedMessage = "Hello TechProEducation How are you today";
        String actualMessage = driver.findElement(By.xpath("//p[@id='demo1']")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
        System.out.println("actualMessage = " + actualMessage);

    }
}
//    go to url :http://demo.automationtesting.in/Alerts.html
//    click  "Alert with OK" and click 'click the button to display an alert box:'
//    accept Alert(I am an alert box!) and print alert on console
//    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
//    cancel Alert  (Press a Button !)
//    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
//    and then sendKeys 'TechProEducation' (Please enter your name)
//    finally print on console this message "Hello TechproEducation How are you today"
