package day13_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void cookiesTesti() {
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSet = driver.manage().getCookies();
       int sayac = 1;
        for (Cookie e:cookiesSet
             ) {
            System.out.println(sayac + ". cookie: " + e);
            System.out.println("name: " + e.getName());
            System.out.println("value: " + e.getValue());
            sayac++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi = cookiesSet.size();
        Assert.assertTrue(cookieSayisi>5);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie e :cookiesSet
             ) {
            if (e.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD", e.getValue());
            }
        }

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(cookie);
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Set<Cookie> cookiesSet2 = driver.manage().getCookies();
        sayac = 1;
        for (Cookie e:cookiesSet2
        ) {
            System.out.println(sayac + ". cookie: " + e);

            sayac++;
        }

        Assert.assertTrue(cookiesSet2.contains(cookie));
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookiesSet2.contains("skin"));

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSet2 = driver.manage().getCookies();
        Assert.assertTrue(cookiesSet2.isEmpty());
    }
}
