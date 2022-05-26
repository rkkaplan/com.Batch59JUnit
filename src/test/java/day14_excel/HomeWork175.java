package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HomeWork175 {
    @Test
    public void readExcel2() throws IOException {
        //Yeni bir test method olusturalim readExcel2( )
        //1.satirdaki 2.hucreye gidelim ve yazdiralim
        String dosyaYolu = "src/Resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString());
        //1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String satir1Hucre2 = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(satir1Hucre2);
        //2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        System.out.println("satir2Hucre4: " + workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString());
        //Satir sayisini bulalim
        int satirSayisi = (workbook.getSheet("Sayfa1").getLastRowNum())+1;
        System.out.println("satirSayisi = " + satirSayisi);
        //Fiziki olarak kullanilan satir sayisini bulun
        int fizikiSatirSayisi = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("fizikiSatirSayisi = " + fizikiSatirSayisi);
        //Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String,String> countriesAndCapitals = new HashMap<>();
        int sonSatirIndexi = workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 0; i <=sonSatirIndexi ; i++) {
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();

            countriesAndCapitals.put(key,value);

        }
       // System.out.println(countriesAndCapitals);
    }
}
