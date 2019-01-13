package com.infoshareacademy.tailandczycy.cdi;

import com.infoshareacademy.tailandczycy.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RequestScoped
public class TemplateBean {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    TemplateProvider templateProvider;

    public void handleTemplate(ServletContext servletContext, String templateName, Map model, HttpServletResponse resp) throws IOException {
        Template template = templateProvider.getTemplate(servletContext, templateName);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }
}
