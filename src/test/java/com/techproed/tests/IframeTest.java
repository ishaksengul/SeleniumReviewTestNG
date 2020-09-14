package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {

    // https://the-internet.herokuapp.com/iframe
    // 1. Adım : Sayfadaki iframe'i bulacağız.
    // 2. Adım : O iframe'in içerisindeki "p" tag name'ine sahip webelementi bulacağız.
    // 3. Adım : İçerisine "Selamlar IFRAME" yazdıracağız.
    // 4. Adım : Iframe'den çıkış yapıp, sayfamıza döneceğiz (defaultContent)
    // 5. Adım : "Elemental Selenium" linkini bulup, tıklayacağız.

    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iFrame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrame);
        WebElement textBox = driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Selamlar IFRAME");
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("Elemental Selenium")).click();

    }

}
