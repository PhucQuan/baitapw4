<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.html" %>
    <div class="container">
        <h2>Thanks for joining our email list</h2>
        <p>Here is the information that you entered:</p>
        <p>Email: <span class="value">${user.email}</span></p>
        <p>First Name: <span class="value">${user.firstName}</span></p>
        <p>Last Name: <span class="value">${user.lastName}</span></p>

        <form action="emailList" method="post">
            <input type="hidden" name="action" value="join">
            <button type="submit">Return</button>
        </form>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>

