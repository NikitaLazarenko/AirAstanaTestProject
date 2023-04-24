package AirAstana.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import AirAstana.config.BaseSettings;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByAttribute;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import AirAstana.config.BaseSettings;
//import sapasoft.reg.testconfigs.BaseSetings;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;
import static AirAstana.config.BaseSettings.pause;
import static com.codeborne.selenide.Configuration.baseUrl;

public class AirAstanaMainPage {
    public void CheckBody(){
        BookingAndManagementBlock();
        InformationBlock();
    }

    @Step("Проверка блока 'Бронирование и управление'")
    public void BookingAndManagementBlock(){
       $$(byXpath("//img[@src='/Portals/_default/Skins/AirAstana7/svg/logo-full.svg']")).first().shouldBe(visible); //проверяет наличие логотипа
       //проверяем корректность раздела "Бронирование и управление"
       $$(byText("Бронирование и управление")).first().click();
       $$(byText("Бронирование")).first().shouldBe(visible);
       $(byXpath("//*[@id=\"aa-navbar\"]/ul[1]/li[1]/ul/li/div/div/div[2]/div/div[2]/ul/li[1]/div/a")).shouldBe(visible);
       $$(byText("Наши услуги")).first().shouldBe(visible);
    }

    @Step("Проверка блока 'Информация'")
    public void InformationBlock(){
        //проверяем корректность раздела "информация"
        $(byXpath("//*[@id=\"aa-navbar\"]/ul[1]/li[2]/a")).click();
        $$(byText("Информация для путешествия")).first().shouldBe(visible);
        $$(byText("В аэропорту")).first().shouldBe(visible);
        $(byXpath("//a[@href='https://airastana.com/kaz/ru-ru/Nashi-uslugi/Na-bortu']")).should(exist);
    }
}
