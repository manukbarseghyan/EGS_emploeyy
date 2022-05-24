package com.egs.egs_employee.servlet;

import com.egs.egs_employee.dto.EmployeeDTO;
import com.egs.egs_employee.service.EmployeeService;
import com.egs.egs_employee.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(false);
        if (session != null) {
            request.getRequestDispatcher("/home.html").include(request, response);
        } else request.getRequestDispatcher("/login.html").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("email");
        String pass = request.getParameter("pass");
        if (username != null && pass != null) {
            EmployeeDTO employeeDTO = employeeService.loginEmployee(username, pass);
            if (employeeDTO != null) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("username", employeeDTO.getUsername());
                httpSession.setAttribute("firstName", employeeDTO.getFirstName());
                httpSession.setAttribute("lastName", employeeDTO.getLastName());
                response.sendRedirect("/home");
                out.print("Hello, " + employeeDTO.getUsername() + " " + employeeDTO.getFirstName() + " Welcome to Profile");

            } else {
                out.print("Please login first");
                request.getRequestDispatcher("/login").include(request, response);
            }
        }
    }
}
