import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class GradeServlet extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse
response)

throws ServletException, IOException {
// Get the subject marks from the request parameters
int mark1 = Integer.parseInt(request.getParameter("mark1"));
int mark2 = Integer.parseInt(request.getParameter("mark2"));
int mark3 = Integer.parseInt(request.getParameter("mark3"));
int mark4 = Integer.parseInt(request.getParameter("mark4"));
int mark5 = Integer.parseInt(request.getParameter("mark5"));
// Calculate the total marks and average
int total = mark1 + mark2 + mark3 + mark4 + mark5;
double average = (double) total / 5;
// Determine the grade based on the average
String grade;
if (average >= 90) {
grade = "A+";
} else if (average >= 80) {
grade = "A";
} else if (average >= 70) {
grade = "B";
} else if (average >= 60) {
grade = "C";
} else if (average >= 50) {
grade = "D";
} else {
grade = "F";
}

// Set the content type and write the response
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<html><body>");
out.println("<h2>Your grade is: " + grade + "</h2>");
out.println("</body></html>");
}
}