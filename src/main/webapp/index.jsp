<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="email.business.User" %>
<%@ include file="header.html" %>
<%
    User user = (User) request.getAttribute("user");
    if (user == null) {
        user = new User();
    }
    String message = (String) request.getAttribute("message");
    if (message == null) {
        message = "";
    }
%>
    <div class="container">
        <h2>Join our email list</h2>
        <p>To join our email list, enter your name and email address below.</p>

        <% if (!message.isEmpty()) { %>
            <div class="error"><%= message %></div>
        <% } %>

        <form action="emailList" method="post">
            <input type="hidden" name="action" value="add">

            <div>
                <label for="email">Email:</label>
                <input id="email" name="email" type="email" value="<%= user.getEmail() %>">
            </div>

            <div>
                <label for="firstName">First Name:</label>
                <input id="firstName" name="firstName" type="text" value="<%= user.getFirstName() %>">
            </div>

            <div>
                <label for="lastName">Last Name:</label>
                <input id="lastName" name="lastName" type="text" value="<%= user.getLastName() %>">
            </div>

            <div class="actions">
                <button type="submit">Join Now</button>
            </div>
        </form>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>

