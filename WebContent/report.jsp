<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.internship.model.Internship" %>
<%
    Internship internship = (Internship) session.getAttribute("internship");
    if (internship == null) {
        response.sendRedirect("index.jsp");
        return;
    }
    String message = (String) request.getAttribute("message");
    double progress = internship.getProgress();
    boolean isCompleted = internship.isCompleted();
    String status = isCompleted ? "Completed" : "In Progress";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Internship Report</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f5f7fb; color: #333; }
        .container { width: 580px; margin: 40px auto; padding: 24px; background: #fff; border-radius: 10px; box-shadow: 0 4px 18px rgba(0,0,0,0.08); }
        h1 { margin-bottom: 12px; font-size: 24px; }
        .field { margin: 12px 0; }
        .label { color: #555; font-weight: bold; }
        .value { margin-top: 4px; font-size: 16px; }
        .status { margin-top: 12px; padding: 14px; background: #eef6ff; border-left: 4px solid #007acc; border-radius: 6px; }
        input[type=number] { width: 120px; padding: 10px; border: 1px solid #ccd0da; border-radius: 6px; }
        button { margin-top: 12px; padding: 12px 18px; background: #007acc; border: none; color: #fff; border-radius: 6px; cursor: pointer; }
        button:hover { background: #005fa3; }
        .message { margin: 18px 0; padding: 14px; background: #e8f3de; border-left: 4px solid #4caf50; border-radius: 6px; }
        .actions { margin-top: 22px; }
    </style>
</head>
<body>
<div class="container">
    <h1>Internship Report</h1>
    <% if (message != null) { %>
        <div class="message"><%= message %></div>
    <% } %>

    <div class="field"><span class="label">Student Name:</span><div class="value"><%= internship.getStudentName() %></div></div>
    <div class="field"><span class="label">Student ID:</span><div class="value"><%= internship.getStudentId() %></div></div>
    <div class="field"><span class="label">Company Name:</span><div class="value"><%= internship.getCompanyName() %></div></div>
    <div class="field"><span class="label">Duration:</span><div class="value"><%= internship.getDurationWeeks() %> weeks</div></div>
    <div class="field"><span class="label">Current Progress:</span><div class="value"><%= String.format("%.1f", progress) %>%</div></div>
    <div class="field"><span class="label">Status:</span><div class="value"><strong><%= status %></strong></div></div>

    <div class="status">
        <% if (isCompleted) { %>
            Congratulations! The internship is completed.
        <% } else { %>
            The internship is still ongoing. Update progress until it reaches 100%.
        <% } %>
    </div>

    <form method="post" action="internship">
        <input type="hidden" name="action" value="update" />
        <label for="progress">Update Progress</label>
        <input type="number" id="progress" name="progress" min="0" max="100" step="0.1" value="<%= String.format("%.1f", progress) %>" required />
        <div class="actions">
            <button type="submit">Save Progress</button>
        </div>
    </form>

    <div class="actions">
        <a href="index.jsp">Back to Create Page</a>
    </div>
</div>
</body>
</html>
