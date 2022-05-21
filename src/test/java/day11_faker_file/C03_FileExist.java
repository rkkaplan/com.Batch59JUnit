package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test01() {

        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir")); // C:\Users\RK\IdeaProjects\com.Batch59JUnit
                            // bize icinde oldugumuz projenin dosya yolunu path2ini verir
        System.out.println("System.getProperty(\"user.home\") = " + System.getProperty("user.home")); //C:\Users\RK
                        //bilgisayarimin bana ozel kismini verdi
        //    "C:\Users\RK\Downloads"
        //      "C:\Users\RK\Desktop"
        // homePath + "\Downloads"


        //masaustundeki text dosyasinin varligini test edin
        // "C:\Users\RK\Desktop\text.txt"
        String textPath = System.getProperty("user.home") + "\\Desktop\\text.txt" ;
        System.out.println("textPath = " + textPath);

        /*
        bilgisayarimizdai bir dosyanin varligini test etmek icin once o dosyaya ulasmamiz gerekir.
         Javada dosyaya ulasim icin dosya yoluna yani pat' ihtiyac vardir.her bilgisayarin
         kullanic aidi farkli olacagindan masaustu dosya yolu da birbirinden farkli olacaktir testlerimizin tum
         bilgisayarlarda calismsi icin dosya yolunu dinamik yapmak zorundayiz
         bunun icin her bilgisayarin birbirinden farkli olan yolunu bulmak icin

         String farkliKisim = System.getProperty("user.home);

         herkesin bilgisayarinda ortak olan kisim ise soyledir:
         String ortakIsim = "\\Desktop\\text.txt";

          String masaustuDosyaYolu = farkliKisim + ortakKisim;
         */

        System.out.println(Files.exists(Paths.get(textPath)));
        Assert.assertTrue(Files.exists(Paths.get(textPath)));


    }
}
