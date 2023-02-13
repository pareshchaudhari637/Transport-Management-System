package Employee.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Employee.Dao.Emp_dao;


@WebServlet("/DeleteTransport")
public class DeleteTransport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteTransport() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String number=request.getParameter("vehical_no");
		
		Emp_dao.deletetransport(number);
		
		RequestDispatcher rd=request.getRequestDispatcher("AllTransportController");
		rd.forward(request, response);
	}

}
