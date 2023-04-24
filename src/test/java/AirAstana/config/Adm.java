package AirAstana.config;

import AirAstana.pages.AcceptCookies;
import AirAstana.pages.AirAstanaMainPage;
import AirAstana.pages.LangChange;

public class Adm extends BaseSettings {

    public AcceptCookies acceptCookies() {
        AcceptCookies acceptCookies = new AcceptCookies();
        return acceptCookies;
    }

    public AirAstanaMainPage airAstanaMainPage() {
        AirAstanaMainPage airAstanaMainPage = new AirAstanaMainPage();
        return airAstanaMainPage;
    }

    public LangChange langChange() {
        LangChange langChange = new LangChange();
        return langChange;
    }
}