<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thanks for joining our survey</title>
    <link rel="stylesheet" href="styles/survey.css">
</head>
<body>
    <main class="container thanks-container">
        <h1>Thanks for joining our survey</h1>
        <p>Here is the information that you entered:</p>
        
        <div class="info-display">
            <p><strong>First Name:</strong> ${firstName}</p>
            <p><strong>Last Name:</strong> ${lastName}</p>
            <p><strong>Email:</strong> ${email}</p>
            <p><strong>Date of Birth:</strong> ${dob}</p>
            <p><strong>Heard From:</strong> 
                <% 
                String referral = (String) request.getAttribute("referral");
                if ("search".equals(referral)) out.print("Search engine");
                else if ("word".equals(referral)) out.print("Word of mouth");
                else if ("social".equals(referral)) out.print("Social Media");
                else if ("other".equals(referral)) out.print("Other");
                %>
            </p>
            <p><strong>Contact for Offers:</strong> ${wantOffers}</p>
            <p><strong>Send Email Announcements:</strong> ${emailOK}</p>
            <p><strong>Preferred Contact:</strong> ${contactBy}</p>
        </div>
        
        <p>To enter another email address, click on the Back button in your browser or the Return button shown below.</p>
        
        <form action="survey.html" method="get">
            <button type="submit">Return</button>
        </form>
    </main>
    
    <footer class="footer">
        <p>&copy; ${currentYear} Mike Murach & Associates</p>
    </footer>
</body>
</html>