package com.techproed.smoketests;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import com.techproed.pages.FHCTripHotelCreatePage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FhcTripHotelCreateTest extends TestBase {

    // her test methodundan once calisir
    @BeforeMethod
    public void beforeMethod(){
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ Keys.ENTER);
    }

    @Test
    public void test() throws InterruptedException {
        // Tüm webelementlere veri göndermeniz gerekiyor.
        // Save butonuna tıklamanız gerekiyor.
        // Assert işlemi ile "Hotel was inserted successfully" yazısını doğrulayın

        FHCTripHotelCreatePage createPage = new FHCTripHotelCreatePage(driver);

        createPage.code.sendKeys("1001");
        createPage.name.sendKeys("ishak");
        createPage.address.sendKeys("rue d'avroy");
        createPage.email.sendKeys("ihvh@hotmail.com");
        createPage.phone.sendKeys("0987456234");
        Select select = new Select(createPage.idGroupDropDown);
        select.selectByIndex(1);
        createPage.saveButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        // 2. yontem
        //WebElement messages = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='bootbox-body']")));
        //Assert.assertTrue(messages.isDisplayed());

        // 3. yontem
        boolean esitMi = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class ='bootbox-body']"), "Hotel was inserted successfully"));
        Assert.assertTrue(esitMi);

        // 1. yontem
        //Thread.sleep(3000);
        //String message = createPage.mesaj.getText();
        //Assert.assertEquals(message, "Hotel was inserted successfully");

    }

}
