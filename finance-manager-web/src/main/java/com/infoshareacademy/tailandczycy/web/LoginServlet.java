package com.infoshareacademy.tailandczycy.web;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.infoshareacademy.tailandczycy.cdi.IdTokenVerifier;
import com.infoshareacademy.tailandczycy.dao.UserDao;
import com.infoshareacademy.tailandczycy.freemarker.TemplateProvider;
import com.infoshareacademy.tailandczycy.model.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(LoginServlet.class);
    private static final String TEMPLATE_NAME_LOGIN = "welcome";
    private static final String TEMPLATE_NAME_LOGIN_OK = "userLogin";
    private static final String TEMPLATE_NAME_LOGIN_FAILED = "user-login-failed";
    private static final String TEMPLATE_NAME_LOGIN_ADMIN = "admin-login";
    private static final String SESSION_ATTRIBUTE_NAME = "userName";
    private static final String SESSION_ATTRIBUTE_EMAIL = "userEmail";

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private UserDao userDao;
    @Inject
    private IdTokenVerifier idTokenVerifier;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, Object> model = new HashMap<>();


        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME_LOGIN);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        final PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession(true);
        User user = new User();

        try {
            LOG.info("Login user with google api");

            String idToken = req.getParameter("id_token");

            GoogleIdToken.Payload payLoad = idTokenVerifier.getPayload(idToken);
            String nameGoogle = (String) payLoad.get("name");
            String emailGoogle = payLoad.getEmail();

            session.setAttribute(SESSION_ATTRIBUTE_NAME, nameGoogle);
            session.setAttribute(SESSION_ATTRIBUTE_EMAIL, emailGoogle);

        } catch (Exception e) {
            LOG.warn("Failed to login user in google api");
            LOG.info("Trying to log in using our user account");

            String email = req.getParameter("email");
            String password = req.getParameter("password");

            List<User> userList = userDao.findAll()
                    .stream()
                    .filter(u -> u.getEmail().equals(email))
                    .collect(Collectors.toList());

            if (!userList.isEmpty()) {

                user = userList.get(0);

                if (user != null && user.getPassword().equals(password)) {

                    session.setAttribute(SESSION_ATTRIBUTE_NAME, user.getName());
                    session.setAttribute(SESSION_ATTRIBUTE_EMAIL, user.getEmail());
                }
            }
        }

        String sessionName = (String) session.getAttribute(SESSION_ATTRIBUTE_NAME);
        String sessionEmail = (String) session.getAttribute(SESSION_ATTRIBUTE_EMAIL);

        Map<String, Object> model = new HashMap<>();
        Template template;

        if (sessionEmail != null) {

            model.put("sessionName", sessionName);
            model.put("sessionEmail", sessionEmail);

            if (user != null) {
                template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME_LOGIN_ADMIN);
            } else {
                template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME_LOGIN_OK);
            }
        } else {
            template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME_LOGIN_FAILED);
            LOG.warn("Failed to. Incorrect login or password");
        }

        setDataTemplate(writer, model, sessionName, template);

    }

    private void setDataTemplate(PrintWriter writer, Map<String, Object> model, Object sessionName, Template template) throws IOException {
        try {
            template.process(model, writer);
            LOG.info("Login user {}", sessionName);
        } catch (TemplateException e) {

            LOG.error("Failed to login user");
        }
    }
}
