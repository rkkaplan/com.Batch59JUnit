package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class HomeWork extends TestBase {
    @Test
    public void test01() {
        //Bir Class olusturun D19_WebtablesHomework
        //1.
        //https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //2. Headers da bulunan department isimlerini yazdirin
        List<WebElement> headersList = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println(headersList.size());
        int departmentsNo = 0;
        for (int i = 0 ; i<headersList.size() ; i++ ){
            if (headersList.get(i).getText().equals("Department")){
                departmentsNo = i;
            }
        }


        List<WebElement> departmentNames =
                driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td']["+(departmentsNo + 1) +"]"));
        for (WebElement e:departmentNames
             ) {
            System.out.println(e.getText());
        }


        //3. sutunun basligini yazdirin
        System.out.println("3.sutunun basligi: ");
        System.out.println(headersList.get(2).getText());
        //4. Tablodaki tum datalari yazdirin
        WebElement tumDatalar = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        System.out.println("Tum Datalar: ");
        System.out.println(tumDatalar.getText());
        //5. Tabloda kac cell (data) oldugunu yazdirin
        List<WebElement> tablodakiCellList = driver.
                findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']//div[@class='rt-td']"));
        System.out.println("Tablodaki Cell Sayisi : " + tablodakiCellList.size());
        //6. Tablodaki satir sayisini yazdirin
        List<WebElement> tumSatirlar = driver.findElements(By.xpath("(//div[@class='rt-tr-group'])"));
        System.out.println("Table'daki satır sayısı : " + tumSatirlar.size());
        //7. Tablodaki sutun sayisini yazdirin
        List<WebElement> ilkSatirBilgileriList = driver.findElements(By.xpath("(//div[@class='rt-tr-group'])[1]//div[@class='rt-td']")); // bir satirdaki rt-td sayisi
        System.out.println("Sutun sayisi : " + ilkSatirBilgileriList.size());
        //8. Tablodaki 3.kolonu yazdirin
        System.out.println("TASK 8: ");
        //(//div[@class='rt-tr-group'])[1]//div[3]
        int tableSatirSayisi = driver.findElements(By.xpath("(//div[@class='rt-tr-group'])")).size();
        for (int i = 1; i <= tableSatirSayisi; i++) {
            if (!driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[" + i + "]//div[3]")).getText().equals(" ")) {
                System.out.print(i + ". satir 3. sutun : ");
                System.out.println(driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[" + i + "]//div[3]")).getText() + " ");
            }
        }
        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println("TASK 9 : ");
        System.out.print("Kierra Salary : ");
        for (int i = 1; i <= tableSatirSayisi; i++) {
            if (driver.findElement(By.xpath("((//div[@class='rt-tr-group'])[" + i + "]//div[1])[2]")).getText().equals("Kierra")) {
                System.out.println(driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[" + i + "]//div[5]")).getText());
            }
        }
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini
        //girdigimde bana datayi yazdirsin
        System.out.println("TASK 10 : ");
        int satir = 2;
        int sutun = 2;
        satirSutunYazdir(satir, sutun);

    }

    private void satirSutunYazdir(int satir, int sutun) {
        System.out.println("10. task: ");
        WebElement istenenHucre = driver.findElement(By.xpath("(//div[@class='rt-tr-group'][" + satir + "]//div[@class='rt-td'])[" + sutun + "]"));
        System.out.print("satir. " + satir + " sutun. " + sutun + " : " + istenenHucre.getText() + "      ");
    }
}
