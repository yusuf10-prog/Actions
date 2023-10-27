package day12_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void test01(){
        //1- Amazon anasayfaya gidin

        driver.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
        Set<Cookie>cookieSet=driver.manage().getCookies();
        System.out.println(cookieSet);
        
        // bu şekilde yazdirinca kaç cookie olduğu ve bunlarin neler olduğu anlasilmiyor.

        int siraNo=1;
        for (Cookie each:cookieSet
             ) {
            System.out.println(siraNo + " - " + each);
            siraNo++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int expectedMinCookieSayisi=5;
        int actualCookieSayisi=cookieSet.size();
        bekle(10);

        Assert.assertTrue(expectedMinCookieSayisi>actualCookieSayisi);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        String expectedCookieValue="USD";
        String actualCookieValue=driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(expectedCookieValue,actualCookieValue);



        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan
        // bir cookie olusturun ve sayfaya ekleyin

        Cookie yeniCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(yeniCookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin

        System.out.println("==========Yeni cookie eklendikten sonra================");

        cookieSet=driver.manage().getCookies();

        siraNo=1;

        for (Cookie each:cookieSet
             ) {
            System.out.println(siraNo + " - " + each);
            siraNo++;
        }

        boolean yeniCookieEklendiMi=false;

        for (Cookie each: cookieSet
             ) {
            if (each.getName().equals("en sevdigim cookie")){
                yeniCookieEklendiMi=true;
            }
        }

        // yeni cookie eklenmişse yeniCookieEklendiMi'nin değeri true olmali

        Assert.assertTrue(yeniCookieEklendiMi);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin

        driver.manage().getCookieNamed("skin");


        System.out.println("==========skin silindikten sonra================");

        cookieSet=driver.manage().getCookies();

        siraNo=1;

        for (Cookie each:cookieSet
        ) {
            System.out.println(siraNo + " - " + each);
            siraNo++;
        }

        boolean skinsilindiMi=true;

        for (Cookie each: cookieSet
             ) {
            if (each.getName().equals("skin")){
                skinsilindiMi=false;
            }
        }

        // en sonda testin passed olmasi icin skinSilindiMi ==> true olmali

        Assert.assertTrue(skinsilindiMi);

        //8- tum cookie’leri silin ve silindigini test edin

        driver.manage().deleteAllCookies();

        cookieSet=driver.manage().getCookies();
        int expectedCookieSetiSize=0;
        int actualCookieSetiSize=cookieSet.size();

        Assert.assertEquals(expectedCookieSetiSize,actualCookieSetiSize);

        bekle(2);
    }
}
