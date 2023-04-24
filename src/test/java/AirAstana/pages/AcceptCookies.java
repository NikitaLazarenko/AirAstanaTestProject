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

public class AcceptCookies {
    public void CheckBody(){
        Accept();
    }

    public void Accept(){
        $$(byId("accept-cookies")).last().click();
    }


}
