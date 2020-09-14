package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest extends TestBase {

    // her test methodundan once calisir
    @BeforeMethod
    public void beforeMethod(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ Keys.ENTER);
    }

    @Test
    public void basliklar(){
        // sayfadaki basliklar : //thead//th
        List<WebElement> basliklar = driver.findElements(By.xpath("//thead//th"));
        for (WebElement w: basliklar) {
            System.out.println(w.getText());
        }
    }

    @Test
    public void tumSatirlar(){
        List<WebElement> tumSatirlar = driver.findElements(By.xpath("//tbody/tr"));
        for (WebElement w: tumSatirlar) {
            System.out.println(w.getText());
        }
    }

    @Test
    public void sutun5(){
        List<WebElement> sutun = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (WebElement w: sutun) {
            System.out.println(w.getText());
        }
    }

    @Test
    public void istenilenHucre(){
        WebElement cell = driver.findElement(By.xpath("//tbody/tr[2]/td[5]"));
        System.out.println(cell.getText());

    }

    // her test methodundan sonra calisir
    @AfterMethod
    public void afterMethod(){

    }
}
