package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class JSAlertTest {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement JSPrompt = driver.findElement(By.xpath("//*[@onclick='jsPrompt()']"));
        JSPrompt.click();
        String alertText = driver.switchTo().alert().getText();
        System.out.println("alert text : "+alertText);


        driver.switchTo().alert().sendKeys("Selamlar biz dostuz..=)");
        driver.switchTo().alert().accept();
        //driver.switchTo().alert().dismiss();
    }
}
