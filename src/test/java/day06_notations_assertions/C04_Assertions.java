package day06_notations_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {

    /*
        JUnit test method'lari icinde yapılan testlerin
        failed veya passed oldugunu bize raporlar

        Ancak bu raporlama
        kodlar sorunsuz calisip bittiyse PASSED
        exception ile karsilasilirsa FAILED olarak gerçeklesir.


        Ayrica JUnit test method'lari icinde yapilan testleri degil
        method'lari raporlar

        JUnit bu is icin ASSERTİONS


                            ONCEKİ DERSTEN AKLİMİZDA KALANLAR



    1- Framework'ler calisma ortamini duzenlemenin yaninda bizim icin faydali ve kolaylik
       saglayici islevler saglarlar.
   2- Junit ile hayatimiza giren en buyuk yenilik notasyonlardir.@ ile baslayan notasyonlar
      framework'in isleyisine mudahale edecek kucuk bilgilere sahiptirler.
   3- @Test : siradan bir method cagrilmadan calismaz. @Test notasyonu eklenen method'lar
      ise bagimsiz olarak calistirabilir.  Bu da bizi main method bagimliligindan kurtarir.
   4- @Igneore : yazildigi test notasyonunun ignore edilmesini saglar.
   5- @Before ve @After : Her test method'undan once calismasini istedigimiz siradan bir method
     varsa @Before ile, her test method'undan sonra calismasini istedigimiz
     siradan bir method varsa da @After ile isaretleriz

   6- @BeforeClass ve @AfterClass : eger her test method'undan önce ve sona değil de
      class ilk calismaya basladiginda ve class calismayi bitirdiginde devreye girmesini
      istedimiz siradan method'lar varsa kullanilir.
   7- Assertions : JUnit test method'larinin PASSED ve FAILED olduklarina o test method'una
      ait kodlarin sorunsuz calisip calismadigina bakarak karar verir.
      ıf-Else ile yapilan testlerde testimiz FAILED olsa bile de kod sorunsuz calistigi icin
      JUnit testi PASSED olarak isaretler. JUnit'in bu ozelliginin saglikli calismasi icin assertions
      kullanilmali.

     */


    // Amazon anasayfaya gidin
    // 3 farkli test method'u olusturarak asagidaki gorevleri yapin
    // 1- Title'in Amazon icerdigini test edin
    // 2- Arama kutusuna "Nutella" yazip aratin ve sonucun Nutella icerdigini test edin
    // 3- Arama kutusuna "Java" yazip aratin ve sonucun Java icerdigini test edin

    /*
        Bize verilen gorevde
        olusturulacak farkli test method'lari
        ayni web sayfasinda oluyorsa
        her test method'unda yeniden driver olusturup, sonunda kapatmak yerine

        Tum @Test method'larindan once 1 kere driver olusturup
        tum @Test method'larini calistirip
        en son driver'i kapatmak daha mantikli olur

       @BeforeClass ve @AfterClass notasyonlari kullanildiginda
       DİKKAT etmemiz gereken konu
       bu notasyonlari kullanan method'larin
       static olarak isaretlenmesinin ZORUNLU olmasidir.

     */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void titleTest(){

        // 2- Title'in Amazon icerdiğini test edin
        String expectedTitleIcerik="Amazon";
        String actualTitle=driver.getTitle();

        Assert.assertTrue("Title Amazon İçermiyor",actualTitle.contains(expectedTitleIcerik));
        System.out.println("Bu satir test passed olursa çalişir, failed olursa çalismaz");

    }
    @Test
    public void nutellaTest(){
        // 3- Arama kutusuna "Java" yazip aratin ve sonucun Java icerdigini test edin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucYaziElement= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        String expectedSonucIcerik="Kutella";
        String actualSonucYazisi=sonucYaziElement.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucIcerik));

    }
    @Test
    public void javaTest(){

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        WebElement sonucYaziElement= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        String expectedSonucIcerik="Hava";
        String actualSonucYazisi=sonucYaziElement.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucIcerik));

    }
}

