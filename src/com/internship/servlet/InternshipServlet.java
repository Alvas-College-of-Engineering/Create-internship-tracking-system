package com.internship.servlet;

import com.internship.model.Internship;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class InternshipServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("InternshipServlet: doGet called with action=" + request.getParameter("action"));
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        Internship internship = (Internship) session.getAttribute("internship");

        if ("report".equals(action) && internship != null) {
            System.out.println("InternshipServlet: Forwarding to report.jsp");
            request.getRequestDispatcher("report.jsp").forward(request, response);
        } else {
            System.out.println("InternshipServlet: Forwarding to index.jsp");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("InternshipServlet: doPost called with action=" + request.getParameter("action"));
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String message = null;

        if ("create".equals(action)) {
            String studentName = request.getParameter("studentName");
            String studentId = request.getParameter("studentId");
            String companyName = request.getParameter("companyName");
            String durationWeeksValue = request.getParameter("durationWeeks");

            System.out.println("InternshipServlet: Creating internship for " + studentName + " at " + companyName);

            if (studentName == null || studentName.isEmpty()
                    || studentId == null || studentId.isEmpty()
                    || companyName == null || companyName.isEmpty()
                    || durationWeeksValue == null || durationWeeksValue.isEmpty()) {
                message = "Please fill in all required fields.";
                request.setAttribute("message", message);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }

            int durationWeeks;
            try {
                durationWeeks = Integer.parseInt(durationWeeksValue);
            } catch (NumberFormatException e) {
                message = "Duration must be a valid integer.";
                request.setAttribute("message", message);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }

            Internship internship = new Internship(studentName, studentId, companyName, durationWeeks);
            session.setAttribute("internship", internship);
            System.out.println("InternshipServlet: Internship created successfully");
            response.sendRedirect("internship?action=report");
            return;
        }

        if ("update".equals(action)) {
            Internship internship = (Internship) session.getAttribute("internship");
            if (internship == null) {
                System.out.println("InternshipServlet: No internship in session, redirecting to index");
                response.sendRedirect("index.jsp");
                return;
            }

            String progressValue = request.getParameter("progress");
            System.out.println("InternshipServlet: Updating progress to " + progressValue);
            try {
                double progress = Double.parseDouble(progressValue);
                if (progress < 0 || progress > 100) {
                    message = "Progress must be between 0 and 100.";
                } else {
                    internship.setProgress(progress);
                    session.setAttribute("internship", internship);
                    message = "Progress updated successfully.";
                    System.out.println("InternshipServlet: Progress updated to " + progress + "%");
                }
            } catch (NumberFormatException e) {
                message = "Enter a valid numeric progress value.";
            }

            request.setAttribute("message", message);
            request.getRequestDispatcher("report.jsp").forward(request, response);
            return;
        }

        System.out.println("InternshipServlet: Unknown action, redirecting to index");
        response.sendRedirect("index.jsp");
    }
}
