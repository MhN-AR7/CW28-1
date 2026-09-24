<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 9/24/2026
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course</title>
</head>
<body>

<form action="register" method="post">
    <label>
        Student Name:
        <input type="text" name="studentName" placeholder="Enter student name" required>
    </label>

    <br>
    <br>

    <label>
        Course Name:
        <input type="text" name="courseName" placeholder="Enter course name" required>
    </label>

    <br>
    <br>

    <label>
        Course Price:
        <input type="number" step="0.01" min="0" name="coursePrice" placeholder="Enter course price" required>
    </label>

    <br>
    <br>

    <label>
        Number of Sessions:
        <input type="number" min="1" name="sessionNum" placeholder="Enter session number" required>
    </label>

    <br>
    <br>

    <button type="submit">Submit</button>
</form>

</body>
</html>
