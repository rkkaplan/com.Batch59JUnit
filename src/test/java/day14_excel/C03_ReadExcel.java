package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcel() throws IOException {
        // input olarak verilen
        // satırNo,sutunNo değerlerini parametre olarak alıp
        // o cell deki datayı String olarak bana dondurren bir method oluşturun

        int satırNo=12;
        int sutunNo=2;

        // dönen String'in cezayir olduğunu test edin
        String expectedData = "Baku";


       String actualData = banaDataGetir(satırNo-1,sutunNo-1); //cunku excel index ile calisir
        Assert.assertEquals(expectedData,actualData);
    }

    public static String banaDataGetir(int satırIndex, int sutunIndex) throws IOException {
        String istenenData ="";
        String dosyaYolu = "src/Resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook wb = WorkbookFactory.create(fis);
        istenenData = wb.
                getSheet("Sayfa1")
                .getRow(satırIndex)
                .getCell(sutunIndex)
                .toString();
        return istenenData;

    }
}
