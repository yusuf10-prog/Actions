package day14_writeExcel_screenShot_JsExecutor;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {
    @Test
    public void excelTest() throws IOException {

        //3) Adimlari takip ederek 1. sayfa 1.satira kadar gidelim

        String dosyaYolu="src/test/java/day13_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        Sheet sayfa1=workbook.getSheet("Sayfa1");

        //4) 4.hucreye yeni bir cell olusturalim
        sayfa1.getRow(0).createCell(4);

        // 5. Hucreye yeni bir cell olusturalim
        sayfa1.getRow(0).createCell(5);

        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        sayfa1.getRow(0).getCell(4).setCellValue("Nufus");

        // Olusturduğumuz hucreye "Nufus Müdürlügü" yazdiralim
        sayfa1.getRow(0).getCell(5).setCellValue("Nufus Mudurlugu");

        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(2).createCell(4).setCellValue("1500000");

        // 3.satir nufus müdürlügü kolonuna 160000 yazdiralim
        sayfa1.getRow(2).createCell(5).setCellValue("16000000");

        //7) 10.satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(10).createCell(4).setCellValue("2500000");

        // 11.satir nufus müdürlüğü kolununa 2600000 yazdiralim
        sayfa1.getRow(11).createCell(5).setCellValue("2600000");

        //8) 15.satir nufus kolonuna 54000 yazdiralim
        sayfa1.getRow(15).createCell(4).setCellValue("5400");

        // 16. satir nüfüs müdürlüğü kolununa 550000 yazdiralim

        sayfa1.getRow(16).createCell(5).setCellValue("550000");

        //9) Dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        //10)Dosyayi kapatalim

    }
}
