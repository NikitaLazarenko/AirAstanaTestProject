package AirAstana.run;

import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import AirAstana.config.Adm;
import AirAstana.config.BaseSettings;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class run extends BaseSettings {

//    @Test
//    @DisplayName("Доступность портала")//
//    public void checMainPage() {
//        Adm adm = new Adm();
//        open("");
//        adm.mainPage().CheckHeaderRu();
//        adm.mainPage().CheckFooterRu();
//        adm.mainPage().CheckHeaderKk();
//        adm.mainPage().CheckFooterKk();
//    }

    @Test
    @DisplayName("Доступность сайта")
    public void airAstanaMainPage() {
        Adm adm = new Adm();
        open("");
        adm.acceptCookies().CheckBody();
        adm.airAstanaMainPage().CheckBody();
    }
}
