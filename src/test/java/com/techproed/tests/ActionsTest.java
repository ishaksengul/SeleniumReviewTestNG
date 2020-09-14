package com.techproed.tests;


import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest extends TestBase {

    @Test
    public void sagTik(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions actions = new Actions(driver);
        WebElement rightClickMe = driver.findElement(By.xpath("//*[.='right click me']"));
        actions.contextClick(rightClickMe).perform();

    }

    @Test
    public void ciftTik(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions actions = new Actions(driver);
        WebElement doubleClick = driver.findElement(By.tagName("button"));
        actions.doubleClick(doubleClick).perform();
    }

    @Test
    public void hoverOver(){ //mouse u bir web elementinin uzerine goturme
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);

        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountList).perform();
    }

    @Test
    public void asagiYukariGitme() throws InterruptedException {
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);
        //Web sayfasinin en altina gitmek icin
        actions.sendKeys(Keys.END).perform();

        Thread.sleep(3000);
        //Web sayfasinda yukari cikmak icin
        //1. yontem -> PAGE_UP butonu
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        //2. yontem -> ARROW_UP
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(3000);

        // aşağı gitmek için kullanılıyor
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        // alt yön tuşunu kullanarak, aşağı gidebilirsiniz
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }

    @Test
    public void keyUpKeyDown(){
        //MERHABA nasilsiniz
        //shift'e basili tutup 'MERHABA', shift'ten kaldirip 'nasilsiniz' yazacagiz
        driver.get("http://www.google.com");
        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.name("q"));
        actions.moveToElement(searchBox)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("merhaba ")
                .keyUp(Keys.SHIFT)
                .sendKeys("nasilsiniz")
                .perform();
    }

    @Test
    public void ikiTusaAyniAndaTiklama(){ //calismiyor
        driver.get("http://www.google.com");
        Actions actions = new Actions(driver);

        //ALT + F4 sayfayi kapatir

        actions.keyDown(Keys.ALT)
                .keyDown(Keys.F4)
                .perform();

    }
}
