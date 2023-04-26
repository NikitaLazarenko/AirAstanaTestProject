package AirAstana.pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static AirAstana.config.BaseSettings.pageurl;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;
import static AirAstana.config.BaseSettings.pause;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.not;

public class TicketBooking {
    public void CheckBody() {
        DepartureFromAndTo();
        Booking();
    }

    @Step("Выбор направления и даты вылета")
    public void DepartureFromAndTo() {
        //Astana (departure)
        $(byXpath("//*[@id=\"flights\"]/div[1]/div[1]/div[1]/button/span[1]")).click();
        pause(2000);
        $(byXpath("//*[@id=\"flights\"]/div[1]/div[1]/div[1]/div/div/input")).sendKeys("Астана");
        $(byXpath("//*[@id=\"flights\"]/div[1]/div[1]/div[1]/div/ul/li[12]/a/span[1]")).click();


        //Almaty (Arrival)
        $(byXpath("//*[@id=\"flights\"]/div[1]/div[1]/div[2]/button/span[1]")).click();
        $(byXpath("//*[@id=\"flights\"]/div[1]/div[1]/div[2]/div/div/input")).sendKeys("Алматы");
        $(byXpath("//*[@id=\"flights\"]/div[1]/div[1]/div[2]/div/ul/li[7]/a/span[1]")).click();

        // Задать дату вылета
//        departureDateInput.click();
        $(byId("date1")).click();

        ElementsCollection FirstDate = $$("div.day.toMonth.valid");
        ElementsCollection SecondDate = $$("div.day.toMonth.valid");

        if (FirstDate.filterBy(text("31")).get(0).is(visible)) {
            FirstDate.filterBy(text("31")).get(0).click();
            SecondDate.filterBy(text("5")).get(0).click();
        } else {
            FirstDate.filterBy(text("26")).get(0).click();
            SecondDate.filterBy(text("30")).get(0).click();
            FirstDate = $$("div.day.toMonth.valid");
            SecondDate = $$("div.day.toMonth.valid");
        }


        $$(byId("main-booking-search-desktop-btn")).first().click();
        $$(byId("main-booking-search-desktop-btn")).first().click();

//        Configuration.baseUrl = "https://bookings.airastana.com/";
    }
        @Step("Переход на bookings.airastana и выбор билетов")
        public void Booking(){

        SelenideElement AirAstanaLogoForWait = $(byXpath("//img[@src='assets/img/web/logo.svg']"));

        SelenideElement TableCase = $(byText("Выберите дату и цену"));
        SelenideElement ContinueButtonInCaseWithTable = $(byXpath("//*[@id=\"scroll\"]/main/vex-flex-calendar/div/div[2]/div[2]/button"));
        SelenideElement TicketButtonFlightFromAstana = $(byXpath("//*[@id=\"mat-expansion-panel-header-0\"]"));

        Selenide.Wait().until(ExpectedConditions.urlContains("bookings"));
        AirAstanaLogoForWait.shouldBe(visible);

        if (AirAstanaLogoForWait.is(visible)){
            TableCase.shouldBe(visible);
        }

        if (TableCase.isDisplayed()) {
            ContinueButtonInCaseWithTable.shouldBe(visible).click();
        }
        else {

        }
        TicketButtonFlightFromAstana.click();

        $(By.xpath("//*[@id=\"cdk-accordion-child-0\"]/div/vex-details-header/div/div/div/vex-flights-rates/div/carousel/div[1]/div/div[1]/mat-card/mat-card-actions/button")).click();
        $(byXpath("//*[@id=\"mat-expansion-panel-header-6\"]")).click();
        $(byXpath("//*[@id=\"cdk-accordion-child-6\"]/div/vex-details-header/div/div/div/vex-flights-rates/div/carousel/div/div/div[1]/mat-card/mat-card-actions/button")).click();
        $$(byXpath("//*[@id=\"scrollMe\"]/div/button")).first().click();
        $(byClassName("headline-XL")).shouldBe(visible);
    }
}






