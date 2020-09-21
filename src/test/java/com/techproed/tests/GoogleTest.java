package com.techproed.tests;

import com.techproed.pages.GooglePage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends TestBaseFinal {

        //1. Örnek : Google Arama
        //	- pages paketinin altında GooglePage adlı class oluşturalım.
        //	- aramaKutusu webelementini bulalım. (@FindBy)
        //	- tumLinkler List<WebElement>, sonuç sayfasındaki tüm linkleri liste şeklinde bulalım.
        //	- aramaKutusu 'a techproeducation yazalım ve arama işlemi yapalım.
        //	- tumLinkler 'e bakalım ve bu testlerin içerisinde techproeducation.com adlı websitesi var mı kontrol edelim.
        //	- varsa testimiz BAŞARILI, yoksa BAŞARISIZ olsun.

    @Test
    public void test01() throws InterruptedException {

        extentTest = extentReports.createTest("Techproeducation Arama",
                "Google sonuclarinda techproeducation.com'u aradik");

        extentTest.info("google.com'a gidiyoruz");
        Driver.getDriver().get(ConfigurationReader.getProperty("google"));
        GooglePage googlePage = new GooglePage();

        extentTest.info("techproeducation aramasi yapiyoruz");
        googlePage.searchBox.sendKeys("techproeducation"+ Keys.ENTER);
        Thread.sleep(3000);

        boolean testSonucu = false;
        for (WebElement w:googlePage.linkler) {
            if(w.getText().contains("techproeducation.com")){
                testSonucu = true;
                break;
            }
        }

        extentTest.info("Assert islemi yapiyoruz");
        Assert.assertTrue(testSonucu);

        extentTest.pass("Testimiz Passed oldu!!");




    }

}
