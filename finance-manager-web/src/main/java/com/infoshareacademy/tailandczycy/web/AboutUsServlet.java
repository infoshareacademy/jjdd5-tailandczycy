package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.cdi.TemplateBean;
import com.infoshareacademy.tailandczycy.staticVariables.Template;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/about")
public class AboutUsServlet extends HttpServlet {

    @Inject
    TemplateBean templateBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, Object> dataModel = new HashMap<>();
        templateBean.handleTemplate(getServletContext(), Template.ABOUT_US, dataModel, resp);
    }
}
