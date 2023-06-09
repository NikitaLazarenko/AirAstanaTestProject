package AirAstana.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
//import com.sun.tools.javac.util.Log;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StatusDetails;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.http.util.Asserts;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class BaseSettings {

    public static String pageurl= "";


    public static final Boolean CLEAR_REPORTS_DIR = false;

    @Before
    public void setUp() {
//        Configuration.browserSize = "1300x1080";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

    }


    @After
    @Step("Завершение теста")
    public void tearDown(){
        screenshot("123");
        try {
            screenshot1("Скрин последней страницы");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(webdriver().driver().url());
        pageurl= webdriver().driver().url();
        info("URL последней страницы: "+pageurl);
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Configuration.browserSize = "1300x1080";
        Selenide.closeWebDriver();

    }




    static {

        Configuration.browser = "chrome"; //firefox, edge,opera, ie
        Configuration.baseUrl = "https://airastana.com/kaz/";
        Configuration.timeout= 20000;
        Configuration.pageLoadTimeout=20000;
        Configuration.browserSize = "1300x1080";

        Configuration.headless = false;
        Configuration.holdBrowserOpen = false;


        if (CLEAR_REPORTS_DIR) {
            File allureScreenShots = new File("build/reports/tests");
            for (File item : Objects.requireNonNull(allureScreenShots.listFiles()))
                item.delete();
        }
    }


    /*Генерация случайной строки русских букв*/
    protected static Random sRandom = new Random();
    protected static char[] sAlphabet = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя".toCharArray();

    protected static int sLength = sAlphabet.length;

    protected static char getRandomChar() {
        return sAlphabet[sRandom.nextInt(sLength)];
    }

    protected static String str() {
        String str = "";
        for (int i=0; i<5; i++) {
            str= str + getRandomChar();
        }
        return str;
    }

    protected static String date(){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    protected static String date1(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    @Attachment(value = "Снимок текущей страницы", type = "image/png")
    public static byte[] screenshot1(String str) throws IOException, NullPointerException {
        File screenshot = Screenshots.getLastScreenshot();

//        close();
        return Files.toByteArray(screenshot);
    }




    @Step("{0}")
    public void info(String info) {
        System.out.print(info);

    }
    public static void pause(long sec) {
        if (sec > 3000) {
            System.out.println("pause - " + sec + "\n");
        }
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
