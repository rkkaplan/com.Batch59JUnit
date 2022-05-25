package day14_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String filePath = "src/Resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(filePath);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //                  WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        //11. Sheet objesi olusturun
                        //workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1");
        //12. Row objesi olusturun
        Row row = sheet.getRow(3);
        //sheet.getRow(index)
        //13. Cell objesi olusturun
        Cell cell = row.getCell(3);
        //row.getCell(index)

        System.out.println(cell);

        // 3.index'deki satirin 3.index'indeki datanin Cezayir oldugunu test edin

        String expectedData="Cezayir";
        String actualData=cell.toString();
        Assert.assertEquals(expectedData,actualData);
        Assert.assertEquals(expectedData,cell.getStringCellValue());

    }
}
