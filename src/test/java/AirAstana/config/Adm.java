package AirAstana.config;

import AirAstana.pages.AcceptCookies;
import AirAstana.pages.AirAstanaMainPage;
import AirAstana.pages.LangChange;
import AirAstana.pages.TicketBooking;

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

    public TicketBooking ticketBooking() {
        TicketBooking ticketBooking = new TicketBooking();
        return ticketBooking;
    }
}