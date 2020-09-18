package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

    @Test
    public void test() throws IOException {
        String dosyaAdresi = "src/test/resources/ULKELER.xlsx";
        // JAVA da herhangi bir dosyanin acilabilmesi icin ; FileIputStream class'indan birtane obje uretilir
        // parametre olarak dosyanin adresi eklenir
        FileInputStream fileInputStream = new FileInputStream(dosyaAdresi);

        //Excel dosyasini okumak icin workbook kullaniyoruz
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Excel   == Workbook
        //Sayfa   == Sheet
        //Satır   == Row
        //Hücre   == Cell

        //sayfa sheet secimi (index 0 dan baslar)
        Sheet sayfa1 = workbook.getSheetAt(0);

        //Satir(Row) secimi (index 0 dan baslar)
        Row satir1 = workbook.getSheetAt(0).getRow(0); // = sayfa1.getRow(0)

        // hucre cell secimi (index 0 dan baslar
        Cell satir1Hucre1 = workbook.getSheetAt(0).getRow(2).getCell(1); // = satir1.getCell(0)

        System.out.println(satir1Hucre1);

        // belirlenen sutunu komple yazdirma
        int sonSatirIdex = workbook.getSheetAt(0).getLastRowNum();
        for (int i=0; i<=sonSatirIdex; i++){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));
        }

        //Tum baskentler sutununu ekrana ayzdir

        for (int i=0; i<=sonSatirIdex; i++){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(1));
        }


        // Belirtilen satiri komple almak icin
        int sonSutunIndex = workbook.getSheetAt(0).getRow(0).getLastCellNum();
        for (int k = 0; k<sonSutunIndex; k++){ // bir sutun fazla kabul ediyor o yuzden <= yapmaya gerek yok
            System.out.println(workbook.getSheetAt(0).getRow(3).getCell(k));
        }




        // excel dosyasini kapatmak icin bu kodlari kullanabiliriz
        workbook.close();
        fileInputStream.close();
    }
}
