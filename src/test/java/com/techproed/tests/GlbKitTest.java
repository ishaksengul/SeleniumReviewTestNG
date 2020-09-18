package com.techproed.tests;

import com.techproed.pages.GlbKitPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class GlbKitTest {

    //2. ÖRNEK : Yazldızlı Çay Bardağı
    //a ) https://www.glbtrader.com/listing/Home-Garden-Kitchen--Dining-Bar/60/67
    //	Bu sayfaya gidelim. Bu sayfaya gitmek için;
    //	1- Driver class'ını kullanın.
    //	2- Sayfa adresini properties dosyasına ekleyin ve oradan alın.
    //		glb_kitchen = https://www.glbtr...
    //b ) Pages paketinin altında GlbKitPage isminde bir tane class oluşturun.
    //	İçerisinde "Yaldızlı Çay Bardağı" ürününü webelemtent şeklinde bulun.
    //		@FindBy (partialLinkText = "..")
    //	ürünün başlığını webelement şeklinde bulun.
    //	ürünün fiyatını webelement şeklinde bulun.
    //	ürünün açıklamasını webelement şeklinde bulun.
    //c ) Bu webelementlerin içerdiği yazıları ekrana yazdırın.

    @Test (groups = "glbtest")
    public void homeGarden(){

        Driver.getDriver().get(ConfigurationReader.getProperty("home_garden"));
        GlbKitPage glbKitPage = new GlbKitPage();

        glbKitPage.yaldizliCayBardagi.click();

        System.out.println("baslik: "+glbKitPage.baslik.getText());
        System.out.println("text: "+ glbKitPage.text.getText());
        System.out.println("price: "+glbKitPage.fiyat.getText());

    }
}
