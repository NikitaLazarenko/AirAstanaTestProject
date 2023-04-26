package AirAstana.run;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import AirAstana.config.Adm;
import AirAstana.config.BaseSettings;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class run extends BaseSettings {

    @Test
    @DisplayName("Доступность сайта")
    public void airAstanaMainPage() {
        Adm adm = new Adm();
        open("ru-ru/");
        adm.acceptCookies().CheckBody();
        adm.airAstanaMainPage().CheckBody();
    }

    @Test
    @DisplayName("Смена языка")
    public void langChange() {
        Adm adm = new Adm();
        open("ru-ru/");
        adm.acceptCookies().CheckBody();
        adm.langChange().LangKK();
        Selenide.Wait().until(ExpectedConditions.urlContains("kk-kz"));
        adm.langChange().LangEN();
        Selenide.Wait().until(ExpectedConditions.urlContains("en-us"));
    }

    @Test
    @DisplayName("Бронирование билета")
    public void ticketBooking(){
        Adm adm = new Adm();
        open("ru-ru/");
        adm.acceptCookies().CheckBody();
        adm.ticketBooking().CheckBody();
    }


}
