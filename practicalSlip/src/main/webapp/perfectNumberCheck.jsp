<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="checkPerfectNumber.jsp" %> <!-- Include the logic file -->

<html>
<head>
    <title>Perfect Number Check</title>
</head>
<body>
    <h2>Check if a Number is Perfect</h2>
    <form action="perfectNumberCheck.jsp" method="post">
        Enter a number: 
        <input type="number" name="number" required />
        <input type="submit" value="Check" />
    </form>

    <br>

    <% 
        String result = (String) request.getAttribute("result"); // Get result from the logic file
        if (result != null) {
            out.println("<h3>" + result + "</h3>"); // Display result
        }
    %>
</body>
</html>
