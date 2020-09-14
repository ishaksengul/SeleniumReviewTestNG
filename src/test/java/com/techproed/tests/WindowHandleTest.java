package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleTest extends TestBase {

    /*
    1. Adım : the-internet.herokuapp.com/windows bu sayfaya gittiğimizde,
              sayfanın WindowHandle'ını alalım.
    2. Adım : Click Here linkine tıklayalım.
    3. Adım : Gittiğimiz sayfadan, the-internet.herokuapp.com/windows sayfasına
              window handle'ını kullanarak geçiş yapalım.
    */

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        String firstWindow = driver.getWindowHandle();
        //System.out.println(firstWindow);
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(5000);

        //Windowhandle kullanarak istedigimiz pencereye su sekilde gecis yapiyoruz
        driver.switchTo().window(firstWindow);

        //acik olan tum pecerelerin windowhandle larini almak icin
        Set<String> tumHandlelar = driver.getWindowHandles();
        String secondWindow = "";
        for (String handle : tumHandlelar){
            if(!handle.equals(firstWindow)){
                secondWindow = handle;
            }
            System.out.println(handle);
        }
        System.out.println(tumHandlelar);
        Thread.sleep(5000);
        driver.switchTo().window(secondWindow);



    }

}
