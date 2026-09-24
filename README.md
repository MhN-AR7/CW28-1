## QUESTION 1 — ONLINE COURSE REGISTRATION
Scenario
You are building a small web application for an online learning platform called “LearnHub”.
The application allows students to log in, register for a course, and view their registration information.
### PHASE 1 — Course Registration Form
Requirement 1 — course.jsp
Create a JSP page called:
course.jsp
The page must contain a form with the following fields:
• Student name
• Course name
• Course price
• Number of sessions
Example:
Student Name: [ ]
Course Name: [ ]
Course Price: [ ]
Sessions: [ ]
[ Register ]
The form must send the request to: /register
The number of sessions must be a number greater than zero.

### PHASE 2 — Registration Servlet and Result JSP
Requirement 2 — RegistrationServlet
Create a Servlet mapped to: /register
The Servlet must:
1. Read the form parameters:
   studentName , courseName , coursePrice , sessions
2. Calculate the total price
3. Store the following values as request attributes:
   studentName
   courseName
   coursePrice
   sessions
   total
4. Forward the request to: registration-result.jsp
   The Servlet must not generate the HTML response.
   Requirement 3 — registration-result.jsp
   Create a JSP page called: registration-result.jsp
   The page must display:

   Registration Summary
   Student: Ali
   Course: Java Backend
   Price per session: 20.0
   Sessions: 5
   Total Price: 100.0
   Use Expression Language to display the values:
   ${studentName}
   ${courseName}
   ${coursePrice}
   ${sessions}
   ${total}

### PHASE 3 — JSP Logic
Requirement 4 — Discount
Modify the application so that students receive a discount when they register for at least 5 sessions.
If the number of sessions is 5 or more: Discount: 10%
Otherwise: Discount: 0%
Display the final price.
Example:
Price: 100
Discount: 10%
Final Price: 90
The calculation can be performed in the Servlet.
Store the final price as a request attribute
Display it in the JSP using: ${finalPrice}

Requirement 5 — JSP Conditional Message
Add a message to registration-result.jsp.
If the final price is greater than or equal to 100:
Registration requires payment confirmation.
Otherwise:
Registration completed successfully.
Use JSP logic for this requirement.