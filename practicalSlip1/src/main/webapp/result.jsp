<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="checkPerfect.jsp" %>

<html>
<head>
    <title>Perfect Number Result</title>
</head>
<body>
    <h2>Perfect Number Result</h2>
    <%
        // Retrieve values from request attributes (no need to declare variables again)
        int number = (int) request.getAttribute("number");
        boolean isPerfect = (boolean) request.getAttribute("isPerfect");

        if (isPerfect) {
            out.println("<h3>" + number + " is a Perfect Number ✅</h3>");
        } else {
            out.println("<h3>" + number + " is NOT a Perfect Number ❌</h3>");
        }
    %>
    <br>
    <a href="index.jsp">Check Another Number</a>
</body>
</html>
