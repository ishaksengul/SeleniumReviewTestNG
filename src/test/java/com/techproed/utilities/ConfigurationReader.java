package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;
    static{
        String dosyaYolu = "/Users/administrator/IdeaProjects/SeleniumReviewTestNG/configuration.properties";
        try{
            // okumak istedigimiz dosyayi okumak icin asgidaki class'tan bir obje uretmeli ve o dosyanin yolunu parametre olarak yazmaliyiz.
            FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
            properties = new Properties();
            properties.load(fileInputStream);

        }catch (Exception e){

        }
    }

    public static String getProperty(String key){
        String deger = properties.getProperty(key); // browserda ne yaziliysa onu getiriyor
        return deger;
    }
}
