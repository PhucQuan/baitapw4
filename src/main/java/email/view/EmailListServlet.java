package email.view;

import email.business.User;
import email.data.UserDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set current year as request attribute
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        request.setAttribute("currentYear", currentYear);

        String url = "/index.jsp";
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }
        System.out.println("EmailListServlet#doPost action=" + action);
        getServletContext().log("EmailListServlet action parameter: " + action);

        if ("join".equals(action)) {
            url = "/index.jsp";
        } else if ("add".equals(action)) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            String message;
            if (isBlank(firstName) || isBlank(lastName) || isBlank(email)) {
                message = "Please fill out all three text boxes.";
                url = "/index.jsp";
            } else {
                message = "";
                url = "/thanks.jsp";
                User user = new User(firstName, lastName, email);
                UserDB.insert(user);
                request.setAttribute("user", user);
            }
            request.setAttribute("message", message);
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}

