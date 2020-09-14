package com.techproed.tests;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ornek_HotelRoomCreation extends TestBase {

    @BeforeMethod
    public void beforeMethod(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelRoomAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ Keys.ENTER);
    }
    @Test
    public void test(){
        WebElement idHotelRoom = driver.findElement(By.id("IDHotel"));
        WebElement codeBox = driver.findElement(By.id("Code"));
        WebElement nameBox = driver.findElement(By.id("Name"));
        WebElement location = driver.findElement(By.id("Location"));
        WebElement textArea = driver.findElement(By.xpath("//textarea[@dir='ltr']"));
        WebElement priceBox = driver.findElement(By.id("Price"));
        WebElement fiyat500 = driver.findElement(By.linkText("500"));
        WebElement roomTypeDrop = driver.findElement(By.id("IDGroupRoomType"));
        WebElement maxAdult = driver.findElement(By.id("MaxAdultCount"));
        WebElement maxChild = driver.findElement(By.id("MaxChildCount"));
        //WebElement approve = driver.findElement(By.id("IsAvailable"));
        WebElement save = driver.findElement(By.id("btnSubmit"));

        Select hotelDropdown = new Select(idHotelRoom);
        hotelDropdown.selectByIndex(2);

        codeBox.sendKeys("1234");
        nameBox.sendKeys("ishak sengul");
        location.sendKeys("Liege");
        textArea.sendKeys("bu oda review dersinde olusturuldu");

        //dragAndDrop - actions
        Actions actions = new Actions(driver);
        actions.dragAndDrop(fiyat500,priceBox).perform();
        Select roomType = new Select(roomTypeDrop);
        roomType.selectByIndex(3);
        maxAdult.sendKeys("2");
        maxChild.sendKeys("2");
        save.click();


    }

}
