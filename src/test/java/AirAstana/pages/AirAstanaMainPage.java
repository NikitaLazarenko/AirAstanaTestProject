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
        CheckMain();
    }

    public void CheckMain(){
       $$(byXpath("//img[@src='/Portals/_default/Skins/AirAstana7/svg/logo-full.svg']")).first().shouldBe(visible);
    }
}
