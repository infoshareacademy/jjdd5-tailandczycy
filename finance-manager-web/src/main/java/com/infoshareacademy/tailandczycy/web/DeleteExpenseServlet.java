package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.cdi.ExpenseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;




@WebServlet("/delete-expense")
public class DeleteExpenseServlet extends HttpServlet {
    private static final String TEMPLATE_MAIN_PAGE = "expense-list";
    private final Logger LOG = LoggerFactory.getLogger(getClass().getName());
    @Inject
    private ExpenseBean expenseBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        Long id = Long.parseLong(req.getParameter("id"));
        handleResponse(resp, id);
    }
    private void handleResponse(HttpServletResponse resp, Long id) throws IOException {
        LOG.info("Deleting Expense with {} id", id);
        expenseBean.deleteExpense(id);
        resp.sendRedirect(TEMPLATE_MAIN_PAGE);
    }
//    private void handleTemplate(Map<String, Object> model, String templateName, HttpServletResponse resp) throws IOException {
//        Template template = templateProvider.getTemplate(getServletContext(), templateName);
//
//        try {
//            template.process(model, resp.getWriter());
//        } catch (TemplateException e) {
//            LOG.warn("Error while processing template" +  e.getMessage());
//        }
//    }
}
