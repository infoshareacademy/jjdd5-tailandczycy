package com.infoshareacademy.tailandczycy.web;
import com.infoshareacademy.tailandczycy.freemarker.TemplateProvider;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/contact-us")
public class ContactUsServlet extends HttpServlet {
    private static final String TEMPLATE_NAME = "static/contactUs";
    private final Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.addHeader("Content-Type", "text/html; charset=utf-8");

    }
}
