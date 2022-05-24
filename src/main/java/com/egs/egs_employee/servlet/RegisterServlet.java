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

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    public final EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/register.html").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(request.getParameter("firstname"));
        employeeDTO.setLastName(request.getParameter("lastname"));
        employeeDTO.setUsername(request.getParameter("email"));
        employeeDTO.setPassword(request.getParameter("pass"));

        if (employeeService.createEmployee(employeeDTO) == null) {
            response.sendRedirect("/register");
        } else {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("username",employeeDTO.getUsername());
            httpSession.setAttribute("firstName",employeeDTO.getFirstName());
            httpSession.setAttribute("lastName",employeeDTO.getLastName());
            response.sendRedirect("/home");
        }
    }
}
