package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    @Test
    public void test() throws IOException {
        String dosyaAdresi = "src/test/resources/ULKELER.xlsx";
        // JAVA da herhangi bir dosyanin acilabilmesi icin ; FileIputStream class'indan birtane obje uretilir
        // parametre olarak dosyanin adresi eklenir
        FileInputStream fileInputStream = new FileInputStream(dosyaAdresi);

        //Excel dosyasini okumak icin workbook kullaniyoruz
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // dosyaya yeni bir bilgi ekleyebilmek icin :
        FileOutputStream fileOutputStream = new FileOutputStream(dosyaAdresi);

        // 0. indextedeki satirda 3. indexte hucre olusturduk ve icerisine NUFUS yazdirdik
        workbook.getSheetAt(0).getRow(0).createCell(3).setCellValue("NUFUS");
        // 1. indextedeki satirda 3. indexte hucre olusturduk ve icerisine 83 Milyon yazdirdik
        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("83 Milyon");

        //istedigimiz satiri tamamiyle silmek icin bu kodu kullaniyoruz
        Row onuncuSatir = workbook.getSheetAt(0).getRow(10);
        workbook.getSheetAt(0).removeRow(onuncuSatir);

        // istedigimiz hucreyi silmke icin bu kodu kullaniyoruz
        Cell almanyaNufus = workbook.getSheetAt(0).getRow(1).getCell(3);
        workbook.getSheetAt(0).getRow(1).removeCell(almanyaNufus);




        // yapilan degisiklikelri excel dosyasina uygular ve kaydeder.
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        workbook.close();
        fileInputStream.close();
    }
}
