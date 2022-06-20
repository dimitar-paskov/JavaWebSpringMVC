package softuni.bg.heroes.web.controllers.base;

import javax.servlet.http.HttpSession;

import softuni.bg.heroes.services.models.LoginUserServiceModel;

public class BaseController {
    protected boolean isAuthenticated(HttpSession session) {
        return session.getAttribute("user") != null;
    }

    protected String getUsername(HttpSession session) {
        return ((LoginUserServiceModel) session.getAttribute("user")).getUsername();
    }
}