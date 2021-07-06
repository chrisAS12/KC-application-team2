package com.example.KCbootcampapplication;

import org.hibernate.mapping.Value;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class AdminSelenium {

    private static WebDriver driver;
    private static String url;

    @BeforeClass
    public static void setUp(){
        url ="http://localhost:8080/";
        System.setProperty("webdriver.gecko.driver","src/test/java/com/example/KCbootcampapplication/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        try {
            SpringApplication.run(KcBootcampApplication.class);
            driver.get(url);
            sleep();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void sleep(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01Login(){
        driver.get(url + "login");
        driver.findElement(By.name("email")).sendKeys("admin@test.com");
        driver.findElement(By.name("pwd")).sendKeys("test123");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        sleep();
        assertEquals("Didnt get transfered to tests","http://localhost:8080/admin/dashboard",driver.getCurrentUrl());
    }

    //getting whitelabel
    @Test
    public void test02createNewKC(){
        driver.findElement(By.xpath("//input[@value=\"Create new test\"]")).click();
        sleep();
        assertTrue(driver.getCurrentUrl().contains("create"));
        assertTrue(driver.getTitle().contains("Create"));
        driver.findElement(By.name("name")).sendKeys("test KC");
        driver.findElement(By.name("isShow")).click();
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        sleep();
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    //WIP
    @Test
    public void test03CreateUser(){
        driver.get(url + "admin/dashboard");
        sleep();
        driver.findElement(By.xpath("//input[@value=\"Create new user\"]")).click();
        sleep();
    }

    //WIP
    @Test
    public void test04CheckResults(){
        driver.get(url + "admin/dashboard");
        sleep();
        driver.findElement(By.xpath("//input[@value=\"Check results\"]")).click();
        sleep();
    }

    @AfterClass
    public static void tearDown(){
        if (driver != null)
            driver.quit();
    }
}
