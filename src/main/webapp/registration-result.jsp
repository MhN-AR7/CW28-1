<%@ page import="java.math.BigDecimal" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 9/24/2026
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Registration-Result</title>
</head>
<body>

<h2>
    Result
</h2>

<p>
    Student Name: ${studentName}
</p>

<p>
    Course Name: ${courseName}
</p>

<p>
    Course Price: ${coursePrice}$
</p>

<p>
    Session Number: ${sessionNum}
</p>

<hr>

<p>
    Total Price: ${totalPrice}$
</p>

<hr>

<p>
    Discount: ${discount}%
</p>

<hr>

<p>
    Final Price: ${finalPrice}$
</p>

<p>
    <%
        BigDecimal finalPrice = (BigDecimal) request.getAttribute("finalPrice");
        if (finalPrice.compareTo(BigDecimal.valueOf(100)) > 0) {

    %>

    Registration requires payment confirmation.

    <%
        }
        else {
    %>

    Registration completed successfully.

    <% } %>
</p>

<a href="my-course.jsp">View My Course</a>

</body>
</html>
