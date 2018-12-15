package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.freemarker.TemplateProvider;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/home")
public class MainPageServlet extends HttpServlet {
    private static final String TEMPLATE_NAME = "home";
    private  final Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        Map<String, Object> dataModel = new HashMap<>();
        List<Integer> expenses = new ArrayList<>();
        dataModel.put("expenses", expenses);
        handleTemplate(dataModel, TEMPLATE_NAME, resp);
    }

    private void handleTemplate(Map<String, Object> model, String templateName, HttpServletResponse resp) throws IOException {
        Template template = templateProvider.getTemplate(getServletContext(), templateName);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}

