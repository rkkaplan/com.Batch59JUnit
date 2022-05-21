package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

import static org.apache.commons.lang3.text.translate.NumericEntityEscaper.below;
import static sun.security.krb5.internal.KDCOptions.with;

public class pratikGenelTekrarTesti extends TestBase {
    //Genel Tekrar Testi
    //Test01:
    //1 -amazon'a gidin
    //2 -Arama kutusunun solundaki drop down menuyu handle edip listesini ekrana yazdırın
    //3 -drop down menude 40 eleman olduğunu doğrulayın
    //Test02:
    //1 -dropdown menuden elektronik bölümü seçin
    //2 -arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
    //3 -sonuc sayisi bildiren yazinin iphone icerdigini test edin
    //4 -ikinci ürün'e relative locater kullanarak tıklayin
    //5 -ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
    //Test03:
    //1 -yeni bir sekme açarak amazon anasayfaya gidin
    //2 -dropdown’dan bebek bölümüne secin
    //3 -"bebek puset" aratıp bulunan sonuç sayısını yazdırın
    //4 -sonuç yazısının "puset" içerdiğini test edin
    //5 -üçüncü ürüne relative locater kullanarak tıklayin
    //6 -title ve fiyat bilgilerini assign edin ve ürünü sepete ekleyin
    //Test 4:
    // 1 -sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    @Test
    public void test01() {
        //Test01:
        //1 -amazon'a gidin
        driver.get("https://www.amazon.com");

        //2 -Arama kutusunun solundaki drop down menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select select = new Select(ddm);

        List<WebElement> ddmOptions = select.getOptions();
        for (WebElement e:ddmOptions
        ) {
            System.out.println(e.getText());
        }
        //3 -drop down menude 40 eleman olduğunu doğrulayın
        int expectedSize = 40;
        int actualSize = select.getOptions().size();
        Assert.assertEquals(expectedSize,actualSize);
    }

    @Test
    public void test02() {
        driver.get("https://www.amazon.com");
        String windowHandleHomepage = driver.getWindowHandle();
        //Test02:
        //1 -dropdown menuden elektronik bölümü seçin
        WebElement ddm = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Electronics");
        //2 -arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone" + Keys.ENTER);
        String textOfResults = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        System.out.println(textOfResults);

        //3 -sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expectedWord = "iphone";
        Assert.assertTrue(textOfResults.contains(expectedWord));

        //4 -ikinci ürün'e relative locater kullanarak tıklayin
        WebElement image1 = driver.findElement(By.xpath("(//img[@data-image-index='1'])[1]"));
        WebElement image3 = driver.findElement(By.xpath("(//img[@data-image-index='3'])[1]"));
        WebElement image2 = driver.findElement(RelativeLocator.with(By.tagName("img")).above(image3).below(image1));
        image2.click();


        //5 -ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String image2Title = driver.getTitle();
        System.out.println("image2Title = " + image2Title);
        /*
        urun stokta olmadigi icin fiyat yazdiralamadi stok durumu bilgisi yazdirildi
         */
        String stokFiyatDurumu  = driver.findElement(By.xpath("//div[@id='availability']")).getText();
        System.out.println("stokFiyatDurumu = " + stokFiyatDurumu);

        //Test03:
        //1 -yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        //2 -dropdown’dan bebek bölümüne secin
        WebElement ddm2 = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select select2 = new Select(ddm2);
        select2.selectByVisibleText("Baby");
        WebElement searchBox2 = driver.findElement(By.id("twotabsearchtextbox"));

        //3 -"bebek puset" aratıp bulunan sonuç sayısını yazdırın
        searchBox2.sendKeys("bebek puset" + Keys.ENTER);

        //4 -sonuç yazısının "puset" içerdiğini test edin
        //5 -üçüncü ürüne relative locater kullanarak tıklayin
        //6 -title ve fiyat bilgilerini assign edin ve ürünü sepete ekleyin


    }


}



