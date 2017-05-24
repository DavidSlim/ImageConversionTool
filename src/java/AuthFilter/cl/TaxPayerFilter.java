/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuthFilter.cl;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import jsf.controllers.cl.login.loginController;

/**
 *
 * @author DEAdMEAt
 */
@WebFilter(filterName = "TaxPayerFilter", urlPatterns = {"/taxpayers/*"})
public class TaxPayerFilter implements Filter {

    private @Inject
    loginController login_ctrlr;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (login_ctrlr != null) {
            if (login_ctrlr.getLogin_gs().isLogged_in() && login_ctrlr.getLogin_gs().getLogin_level().equalsIgnoreCase("taxpayer")) {
                chain.doFilter(request, response);
            } else {
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Wrong authentication credentials provided");
            }
        } else {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication is required to access page");
        }
    }

    @Override
    public void destroy() {
    }

}
