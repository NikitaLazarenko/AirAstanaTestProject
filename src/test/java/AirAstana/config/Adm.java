package AirAstana.config;

import AirAstana.config.BaseSettings;
import AirAstana.pages.AcceptCookies;
import AirAstana.pages.AirAstanaMainPage;
import AirAstana.pages.MainPage;

public class Adm extends BaseSettings {

    public MainPage mainPage() {
        MainPage mainPage = new MainPage();
        return mainPage;
    }

    public AcceptCookies acceptCookies() {
        AcceptCookies acceptCookies = new AcceptCookies();
        return acceptCookies;
    }

    public AirAstanaMainPage airAstanaMainPage() {
        AirAstanaMainPage airAstanaMainPage = new AirAstanaMainPage();
        return airAstanaMainPage;
    }
}