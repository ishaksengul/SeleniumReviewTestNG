package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitTest extends TestBase {

    @Test
    public void implicitlyWaitTest(){
    // implicitly wait : sayfadaki findElement islemi gerceklesirken belirlenen sureye kadar bekliyor. oncesinde bulursa
        // beklemeyi bitirip islemlere devam ediyor.
        driver.get("http://google.com");
        //WebElement ishakLink = driver.findElement(By.id("ishakSengul"));
        WebElement searchBox = driver.findElement(By.name("q"));
    }

    @Test
    public void explicitWaitTest(){
        // WebDriverWait class'indan nesne ureterek kullanabiliyoruz
        // implicitlyWaitten en onemli farki burada herhangi bir WebElement icin bekleme yapiyoruz
        // Explicit wait icin en onemli durum , bir kosul belirtiyoruz
        //ornek: aradigimiz web Element tiklanabiliyor olsun

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        // explicitWait kullanabilmek icin obje uretmek zorundayiz
        WebDriverWait wait = new WebDriverWait(driver, 20);
        //WebElement message = driver.findElement(By.id("message"));
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        System.out.println(message.getText());

    }
}
