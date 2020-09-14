package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadUploadTest extends TestBase {

    @Test
    public void dosyaVarMi(){
        // su anda buundugumuz clasor'un dosya yolunu veriyor (String olarak)
        System.out.println(System.getProperty("user.dir"));
        // Kullanicinin ana clasorunun dosya yolunu veriyor(String olarak)
        System.out.println(System.getProperty("user.home"));

        //Java ile belirtilen adreste aradigimiz dosyanin var olup olmadigni asagidaki code ile yapabiliriz
        //eger dosya varsa true yoksa false degerlerini verir
        // /Users/administrator/IdeaProjects/SeleniumReviewTestNG/pom.xml klasor'un ismi
        boolean varMi = Files.exists(Paths.get("/Users/administrator/IdeaProjects/SeleniumReviewTestNG/pom.xml"));
        Assert.assertTrue(varMi);
    }

    @Test
    public void dosyaUpload(){
        driver.get("http://the-internet.herokuapp.com/upload");

        // "diya sec" elementini locate ettik
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        // sendKeys ile indirmek istedigimiz dosyanin adresini gondermeliyiz
        dosyaSec.sendKeys("/Users/administrator/Desktop/logo.png");
        driver.findElement(By.id("file-submit")).click();
    }

    @Test
    public void dosyaIndirme() throws InterruptedException {
        //web sitesinden indirmek istedigimiz dosyayi indridikten sonra pc de indirme klasorunde o dosyanin olup ol,adigini
        // kontrol ediyurz.
        // indirme islemi uzun surebilir bu yuzden beklme kullanmakta yarar vardir

        driver.get("http://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("Penguins.jpg")).click();
        boolean dosyaVarMi = Files.exists(Paths.get("/Users/administrator/Downloads/Penguins.jpg"));
        Thread.sleep(3000);
        Assert.assertTrue(dosyaVarMi);

    }
}
