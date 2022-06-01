package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {


    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test(){
        /*herhangi bir web sitesine gidince veya
         bir web sitesinde herhangi bir islem yaptigimizda cikan  uyarilara
         allert deriz

         eger bir alert inspect yapilabiliyorsa, o alert otomasyon ile kullanilabilir
         bu tur alertlere html alert denir ve bunlar icin ekstra bir islem yapmaya gerek yoktur
         tum webelementler gibi locate edip istedigimiz islemleri yapabiliriz

         driver.get("https://www.facebook.com"); gibi...

         ancak web uygulamalarinda html alert yaninda java script alert de olabilir ve onlar locate edilemez
         selenium da js alert icin ozel yontemler gelistirilmistir


         */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        //allert de OK tusuna basin

        driver.switchTo().alert().accept();

        //result kisminda You successfully clicked an alert yazdigini test edin
        String expectedResult="You successfully clicked an alert";
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult=sonucYaziElementi.getText();
        Assert.assertEquals(expectedResult,actualResult);


    }
}
