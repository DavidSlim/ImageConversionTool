package Nav.Cl;

import java.util.*;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class LoginLevel implements java.io.Serializable {

    public LoginLevel() {

    }

    public enum Hierachy_level {
        Administrator, TaxPayer, Supervisor, ReturnProcessing
    }

    public Hierachy_level[] getHierachy_level() {
        return Hierachy_level.values();
    }

    public TreeSet<String> getLevel_list() {
        TreeSet<String> level_list = new TreeSet<>();
        level_list.add("Administrator");
        level_list.add("TaxPayer");
        level_list.add("Supervisor");
        level_list.add("ReturnProcessing");
        level_list.add("SuperAdministrator");
        return level_list;
    }

    public Map<String, String> getLevel_map() {
        Map<String, String> level_map = new TreeMap<>();
        level_map.put("Admin", "Administrator");
        level_map.put("Tax payer", "TaxPayer");
        level_map.put("Supervisor", "Supervisor");
        level_map.put("Return processing", "ReturnProcessing");
        level_map.put("Super admin", "SuperAdministrator");
        return level_map;
    }

    /*
                <!--<h:selectOneMenu value="#{loginController.login_gs.login_level}">
                <f:selectItem itemValue="#{null}" itemLabel="--Select One--"/>
                <f:selectItems value="#{loginLevel.level_map.entrySet()}" var="level" itemLabel="#{level.key}" itemValue="#{level.value}"/>
                <f:ajax render="login_level"/>
            </h:selectOneMenu><br/>
            <h:outputText id="login_level" value="#{loginController.login_gs.login_level}"/>-->
            <br>

            </br>
     */
}
