package day13_excelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_readExcel {

    @Test
    public void readExcelTestleri() throws IOException {
        String dosyaYolu="src/test/java/day13_excelOtomasyon/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        // olusturdugumuz workbook, online olarak excel dosyasina erismez
        //18.satirda fileInputStream kullanarak excel'deki bilgileri aldik
        //20.satirda fis'in aldigi bilgileri kullanarak kodlarimiz icinde
        // fiziki excel dosyasinin bir kopyasini olusturmus olduk.

        Sheet sheet= workbook.getSheet("Sayfa1");
        Row row=sheet.getRow(3); // index
        Cell cell=row.getCell(3); // index

        System.out.println(cell); //cezayir

        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sheet.getRow(0).getCell(1));

        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim

        String istenenData=sheet.getRow(0).getCell(1).toString();
        System.out.println(istenenData);

        // 2.satir 4.cell'in afganistan'in baskenti Kabil oldugunu test edelim

        String expectedData="Kabil";
        String actualData=sheet.getRow(1).getCell(3).toString();

        Assert.assertEquals(expectedData,actualData);

        // - Satir sayisini bulalim

        System.out.println(sheet.getLastRowNum()+1); // method 190 yani son satirin index'ini verir
                                                    // biz satir sayisini bulmak icin 1 ekledik

        // - Fiziki olarak kullanilan satir sayisini bulun

        System.out.println(sheet.getPhysicalNumberOfRows()); // direk fiziki olarak kullanilan satir sayisini yazdirir.


        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        String isim;
        String baskent;

        Map<String, String> ulkelerMap=new TreeMap<>();

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            isim=sheet.getRow(i).getCell(0).toString();
            baskent=sheet.getRow(i).getCell(1).toString();

            ulkelerMap.put(isim,baskent);

        }

        // Ulkeler excel'inde Canada isimli bir ulke oldugunu test edin
        Assert.assertTrue(ulkelerMap.containsKey("Canada"));

        // Ulkeler excel'inde Cuba'nin baskentinin Havana oldugunu test edin


        String expectedBaskent="Havana";
        String actualBaskent=ulkelerMap.get("Cuba");

        Assert.assertEquals(expectedBaskent,actualBaskent);

    }
}
