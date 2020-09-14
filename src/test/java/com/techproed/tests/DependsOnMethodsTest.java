package com.techproed.tests;

import org.testng.annotations.Test;

public class DependsOnMethodsTest {

    @Test (priority = 2)
    public void test01(){  // sisteme giriş testiniz
        System.out.println("test01");
    }
    @Test (priority = 1, dependsOnMethods = "test01")
    public void test02(){ // sisteme giriş yaptıktan sonraki işlemler
        System.out.println("test02");
    }
    @Test (priority = 0)
    public void test03(){
        System.out.println("test03");
    }
}
