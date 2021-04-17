package com.Le_Huy_Hai.Servlet;

import com.Le_Huy_Hai.Dao.PhoneDao;
import com.Le_Huy_Hai.Entity.PhoneEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home", "/"})
public class HomeServlet extends HttpServlet {
    PhoneDao dao = new PhoneDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PhoneEntity> phones = dao.getPhones();

        if (phones.isEmpty()) {
            seedData();
            phones = dao.getPhones();
        }

        request.setAttribute("phones", phones);
        request.getRequestDispatcher("phone-list.jsp").forward(request, response);
    }

    private void seedData() {
        dao.insertPhone(new PhoneEntity("Samsung S8", "Samsung", 8000000, "Samsung S8 phone"));
        dao.insertPhone(new PhoneEntity("Samsung S9", "Samsung", 9000000, "Samsung S9 phone"));
        dao.insertPhone(new PhoneEntity("Samsung S10", "Samsung", 10000000, "Samsung S10 phone"));
        dao.insertPhone(new PhoneEntity("Samsung S11", "Samsung", 11000000, "Samsung S11 phone"));
        dao.insertPhone(new PhoneEntity("Samsung S12", "Samsung", 12000000, "Samsung S12 phone"));
        dao.insertPhone(new PhoneEntity("Samsung S13", "Samsung", 13000000, "Samsung S13 phone"));
        dao.insertPhone(new PhoneEntity("Apple 5", "Apple", 5000000, "Apple 5 phone"));
        dao.insertPhone(new PhoneEntity("Apple 6", "Apple", 6000000, "Apple 6 phone"));
        dao.insertPhone(new PhoneEntity("Apple 7", "Apple", 7000000, "Apple 7 phone"));
        dao.insertPhone(new PhoneEntity("Apple 8", "Apple", 8000000, "Apple 8 phone"));
    }
}
