<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    String result = "";
    String numberStr = request.getParameter("number");

    if (numberStr != null && !numberStr.isEmpty()) {
        int number = Integer.parseInt(numberStr);
        int sum = 0;

        // Calculate the sum of divisors
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        // Check if the number is perfect
        if (sum == number) {
            result = number + " is a Perfect Number.";
        } else {
            result = number + " is not a Perfect Number.";
        }
    }

    request.setAttribute("result", result); // Store result for main JSP page
%>
