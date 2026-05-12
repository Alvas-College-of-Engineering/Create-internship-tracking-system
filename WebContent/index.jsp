<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = (String) request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Internship Tracking System</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f5f7fb; color: #333; }
        .container { width: 520px; margin: 40px auto; padding: 24px; background: #fff; border-radius: 10px; box-shadow: 0 4px 18px rgba(0,0,0,0.08); }
        h1 { margin-bottom: 18px; font-size: 24px; }
        label { display: block; margin: 14px 0 6px; font-weight: bold; }
        input[type=text], input[type=number] { width: 100%; padding: 10px; border: 1px solid #ccd0da; border-radius: 6px; }
        button { margin-top: 18px; padding: 12px 18px; background: #007acc; border: none; color: #fff; border-radius: 6px; cursor: pointer; }
        button:hover { background: #005fa3; }
        .info { margin: 18px 0; padding: 14px; background: #eef6ff; border-left: 4px solid #007acc; border-radius: 6px; }
        .link { margin-top: 12px; display: inline-block; }
    </style>
</head>
<body>
<div class="container">
    <h1>Internship Tracking System</h1>
    <p>Enter internship details below to create a new record.</p>

    <% if (message != null) { %>
        <div class="info"><%= message %></div>
    <% } %>

    <form method="post" action="internship">
        <input type="hidden" name="action" value="create" />

        <label for="studentName">Student Name</label>
        <input type="text" id="studentName" name="studentName" placeholder="e.g. Kaveri" required />

        <label for="studentId">Student ID (USN)</label>
        <input type="text" id="studentId" name="studentId" placeholder="e.g. 4AL23CS062" required />

        <label for="companyName">Company Name</label>
        <input type="text" id="companyName" name="companyName" placeholder="e.g. Infosys" required />

        <label for="durationWeeks">Duration (weeks)</label>
        <input type="number" id="durationWeeks" name="durationWeeks" min="1" placeholder="e.g. 8" required />

        <button type="submit">Create Internship</button>
    </form>

    <a class="link" href="internship?action=report">Go to Internship Report</a>
</div>
</body>
</html>
