package Nav.Cl;

import javax.inject.Named;
import java.io.Serializable;
import javax.ejb.Stateless;

@Named(value = "navigation")
@Stateless
public class Navigation implements Serializable {

    //private String vat, vatRedirect;
    public String getIndex() {
        return "/index";
    }

    public String getIndexRedirect() {
        return "/index?faces-redirect=true";
    }

    public String getLogin() {
        return "/login/login";
    }

    public String getLoginRedirect() {
        return "/login/login?faces-redirect=true";
    }

    public String getVat() {
        return "/taxpayers/vat/vat";
    }

    public String getVatRedirect() {
        return "/taxpayers/vat/vat?faces-redirect=true";
    }

}
