package day13_excelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void test01() throws IOException {

        // ilgili ayarlari yapip worbook'u olusturun

        String dosyaYolu="src/test/java/day13_excelOtomasyon/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);


        // 2.sayfaya gidin

        Sheet sayfa2=workbook.getSheet("Sayfa2");


        // kullanilan en son satirin 24.satir oldugunu test edin

        int expectedSonSatirNo=24;
        int actualSonSatirNo=sayfa2.getLastRowNum()+1;
        // getLastRowNum = indeksi getiriyor.

        System.out.println("Gelen Deger :"+actualSonSatirNo);

        Assert.assertEquals(expectedSonSatirNo,actualSonSatirNo);

        // fiziki kullanilan satir sayisinin 8 oldugunu test edin

        int expectedFizikiSatirSayisi=8;
        int actualFizikiSatirSayisi=sayfa2.getPhysicalNumberOfRows();

        System.out.println("Gelen Deger :"+actualFizikiSatirSayisi);

        Assert.assertEquals(expectedFizikiSatirSayisi,actualFizikiSatirSayisi);

        // olmayan satır veya sutun numarası yazdirmaya calissak

        //System.out.println(sayfa2.getRow(30).getCell(1)); // NullPointException

        //System.out.println(sayfa2.getRow(5).getCell(10)); //null

    }
}
