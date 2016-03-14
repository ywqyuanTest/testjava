package ywq.dr.chaptr.ywq.dr.chaptr.controller;

import ywq.dr.chaptr.ywq.dr.chaptr.model.Customer;
import ywq.dr.chaptr.ywq.dr.chaptr.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by xm001 on 2016/3/14.
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService;

    @Override
    public void init() throws ServletException{
        customerService = new CustomerService();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Customer>  customerList =customerService.getCustomerList();
        request.setAttribute("customerList",customerList);
        request.getRequestDispatcher("/WEB-INF/jsp/customer.jsp").forward(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
