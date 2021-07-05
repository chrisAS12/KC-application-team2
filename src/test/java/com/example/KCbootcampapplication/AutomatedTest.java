package com.example.KCbootcampapplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutomatedTest {

    public static void main(String[] args){
        System.setProperty("webdriver.gecko.driver","src/test/java/com/example/KCbootcampapplication/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        
    }

}
