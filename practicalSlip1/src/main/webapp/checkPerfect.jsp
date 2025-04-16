<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    // Get the number from the request
    String numStr = request.getParameter("num");
    int num = Integer.parseInt(numStr);
    int sum = 0;

    // Calculate sum of divisors
    for (int i = 1; i <= num / 2; i++) {
        if (num % i == 0) {
            sum += i;
        }
    }

    // Store result in request attributes (instead of declaring local variable in result.jsp)
    request.setAttribute("number", num);
    request.setAttribute("isPerfect", sum == num);
%>
