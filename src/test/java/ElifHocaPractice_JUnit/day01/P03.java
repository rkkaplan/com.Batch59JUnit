package ElifHocaPractice_JUnit.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {
    /*
     ...Exercise3...
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button given number of times,
    // and then validates that given number of buttons was deleted
    1. method: createButtons(100)
    2.method:  deleteButtonsAndValidate()
 */
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test01() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        int create = 100;
        createButtons(create);
        int delete = 85;
        if (create > delete) {
            deleteButtonsAndValidate(delete);
            WebElement deleteButton = driver.findElement(By.xpath("//div[@id='elements']"));
            System.out.println(deleteButton.getText());
            String[] deleteButtonArr = deleteButton.getText().split("ete");
            Assert.assertEquals(create - delete, deleteButtonArr.length);
            System.out.println(delete + " adet delete butonu silindiği dogrulandi");
        } else {

            System.out.println("Create Delete'den kucuk ve ya Delete'ye esit olamaz");

        }
    }
    public void createButtons(int a) {
        for (int i = 0; i < a; i++) {
            driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        }
    }
    public void deleteButtonsAndValidate(int a) {
        for (int i = 0; i < a; i++) {
            driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();
        }
    }
}
