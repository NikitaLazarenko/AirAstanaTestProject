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

public class LangChange {
    public void CheckBody(){
        LangKK();
        LangEN();
    }

    @Step("Переход на казахский язык")
    public void LangKK(){
        $$(byXpath("//img[@src='/Portals/_default/Skins/AirAstana7/svg/globe.svg']")).last().click();
        $$(byText("Қазақ")).first().click();
    }

    @Step("Переход на английский язык")
    public void LangEN(){
        $$(byXpath("//img[@src='/Portals/_default/Skins/AirAstana7/svg/globe.svg']")).last().click();
        $(byXpath("//*[@id=\"aa-navbar\"]/ul[2]/li[2]/ul/li/div/div[2]/div[16]/a/span")).click();
    }
}
