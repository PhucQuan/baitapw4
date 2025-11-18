package murach.survey;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

public class SurveyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Set current year
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        request.setAttribute("currentYear", currentYear);
        
        // Get form data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String referral = request.getParameter("referral");
        String wantOffers = request.getParameter("wantOffers");
        String emailOK = request.getParameter("emailOK");
        String contactBy = request.getParameter("contactBy");
        
        // Set attributes for JSP
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("email", email);
        request.setAttribute("dob", dob);
        request.setAttribute("referral", referral);
        request.setAttribute("wantOffers", wantOffers != null ? "on" : "off");
        request.setAttribute("emailOK", emailOK != null ? "on" : "off");
        request.setAttribute("contactBy", contactBy);
        
        // Forward to thanks page
        getServletContext()
                .getRequestDispatcher("/survey_thanks.jsp")
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}