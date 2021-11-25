package com.suraj.csv.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.suraj.csv.entity.User;
import com.suraj.csv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @Controller
    public class WelcomeController {
        @GetMapping("/")
        public String welcome() {
            return "welcome";
        }
    }

    @GetMapping("/users/export")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<User> listUsers = service.listAll();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"User ID", "Name", "Phone", "E-mail", "Country"};
        String[] nameMapping = {"id", "name", "phone", "email", "country"};

        csvWriter.writeHeader(csvHeader);

        for (User user : listUsers) {
            csvWriter.write(user, nameMapping);
        }
        csvWriter.close();
    }
}