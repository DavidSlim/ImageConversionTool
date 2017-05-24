package jsf.getters.cl;

import java.time.LocalDateTime;

public class getset_login {

    private String login_name, login_password, login_level;
    private LocalDateTime login_time;
    private boolean logged_in;

    public getset_login(String login_name, String login_password, String login_level) {
        this.login_name = login_name;
        this.login_password = login_password;
        this.login_level = login_level;
    }

    public getset_login() {
        this.logged_in = false;
    }

    public LocalDateTime getLogin_time() {
        return login_time;
    }

    public void setLogin_time(LocalDateTime login_time) {
        this.login_time = login_time;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getLogin_level() {
        return login_level;
    }

    public void setLogin_level(String login_level) {
        this.login_level = login_level;
    }

    public String getLogin_password() {
        return login_password;
    }

    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }

    public boolean isLogged_in() {
        return logged_in;
    }

    public void setLogged_in(boolean logged_in) {
        this.logged_in = logged_in;
    }

}
