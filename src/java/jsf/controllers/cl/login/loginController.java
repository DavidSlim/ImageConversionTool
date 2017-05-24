package jsf.controllers.cl.login;

import Nav.Cl.Navigation;
import java.time.LocalDate;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.time.LocalDateTime;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import jsf.getters.cl.getset_login;

@Named(value = "loginController")
@SessionScoped
public class loginController implements java.io.Serializable {

    private getset_login login_gs = new getset_login();
    private @Inject
    Navigation nav_;
    private List<getset_login> list_login;
    private List<LocalDate> list_date;
    private List<LocalDate> list_date_found;

    @PostConstruct
    private void loadLoginList() {

        list_login = new ArrayList<>();
        list_login.add(new getset_login("admin", "admin", "Admin"));
        list_login.add(new getset_login("super", "1234", "SuperAdmin"));
        list_login.add(new getset_login("slim", "slim", "TaxPayer"));
        list_login.add(new getset_login("david", "murimi", "Admin"));
        list_date = new ArrayList<>();
        list_date.add(LocalDate.parse("2016-06-12"));
        list_date.add(LocalDate.parse("2017-05-12"));
        list_date.add(LocalDate.parse("2016-10-14"));
        list_date.add(LocalDate.parse("2016-11-23"));
        list_date.add(LocalDate.parse("2016-06-02"));
        list_date.add(LocalDate.parse("2016-12-31"));
        list_date.add(LocalDate.parse("2015-05-26"));
        list_date.add(LocalDate.parse("2016-03-09"));
        list_date.add(LocalDate.parse("2017-01-02"));
        list_date.add(LocalDate.parse("2016-12-31"));
        list_date.add(LocalDate.parse("2017-04-14"));
        list_date.add(LocalDate.parse("2017-03-02"));
        list_date.add(LocalDate.parse("2017-12-25"));
        list_date.add(LocalDate.parse("2017-03-02"));
        list_date.add(LocalDate.parse("2016-12-31"));
        list_date.add(LocalDate.parse("2017-01-01"));
        list_date.add(LocalDate.parse("2017-02-02"));
        list_date.add(LocalDate.parse("2017-03-11"));
        list_date.add(LocalDate.parse("2016-12-31"));
        list_date.add(LocalDate.parse("2017-12-30"));
        list_date_found = new ArrayList<>();
        list_date.stream().forEach((LocalDate e) -> {
            if (e.isAfter(LocalDate.parse("2016-12-31").minusDays(1)) && e.isBefore(LocalDate.parse("2017-05-09"))) {
                list_date_found.add(e);
            }
        });
    }

    public String login() {

        list_login.stream().filter((getset_login e)
                -> e.getLogin_name().equalsIgnoreCase(login_gs.getLogin_name())
                && e.getLogin_password().equalsIgnoreCase(login_gs.getLogin_password())
        ).forEach((getset_login xx) -> {
            List<getset_login> login_list = Arrays.asList(xx);
            if (login_list.size() == 1) {
                login_list.stream().forEach((getset_login e) -> login_gs.setLogin_level(e.getLogin_level()));
                login_gs.setLogged_in(true);
                login_gs.setLogin_time(LocalDateTime.now());
                System.out.println("Name = " + login_gs.getLogin_name() + "Level = " + login_gs.getLogin_level());
            } else {
                login_gs = new getset_login();
                System.out.println("Name = " + login_gs.getLogin_name() + "Level = " + login_gs.getLogin_level());
            }
        });

        if (login_gs.isLogged_in()) {
            return nav_.getVatRedirect();
        } else {
            return nav_.getIndexRedirect();
        }

    }

    public getset_login getLogin_gs() {
        return login_gs;
    }

    public void setLogin_gs(getset_login login_gs) {
        this.login_gs = login_gs;
    }

    public List<getset_login> getList_login() {
        return list_login;
    }

    public void setList_login(List<getset_login> list_login) {
        this.list_login = list_login;
    }

    public List<LocalDate> getList_date_found() {
        return list_date_found;
    }

    public void setList_date_found(List<LocalDate> list_date_found) {
        this.list_date_found = list_date_found;
    }

}
