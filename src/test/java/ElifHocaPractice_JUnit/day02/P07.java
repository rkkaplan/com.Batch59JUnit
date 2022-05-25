package ElifHocaPractice_JUnit.day02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class P07 extends TestBase {
    @Test
    public void test01() {
        // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        //-->Task1 Find Dropdown on Multi Selection
        WebElement ddm = driver.findElement(By.xpath("(//input[@placeholder='Select'])[1]"));
        Select select = new Select(ddm);
        //-->Task2 Find  all Dropdown Elements on page
        select.getAllSelectedOptions();
        //-->Task3 printout DropDown Elements' number
        System.out.println("select.getAllSelectedOptions().size() = " + select.getAllSelectedOptions().size());
        //-->Task4 choose dropdown elements and printout dropdown elements' name  until choise 6
    }

}
// go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
//-->Task1 Find Dropdown on Multi Selection
//-->Task2 Find  all Dropdown Elements on page
//-->Task3 printout DropDown Elements' number
//-->Task4 choose dropdown elements and printout dropdown elements' name  until choise 6
